package it.tristana.farmingtycoon;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.bukkit.Bukkit;

import it.tristana.commons.arena.Clock;
import it.tristana.commons.database.BasicUsersManager;
import it.tristana.commons.helper.CommonsHelper;
import it.tristana.commons.helper.PluginDraft;
import it.tristana.commons.interfaces.DatabaseHolder;
import it.tristana.commons.interfaces.Reloadable;
import it.tristana.commons.interfaces.database.UsersManager;
import it.tristana.commons.listener.LoginQuitListener;
import it.tristana.farmingtycoon.command.FarmCommand;
import it.tristana.farmingtycoon.config.ConfigFarmDatabase;
import it.tristana.farmingtycoon.config.ConfigIslandCounter;
import it.tristana.farmingtycoon.config.ConfigMessages;
import it.tristana.farmingtycoon.config.SettingsFarm;
import it.tristana.farmingtycoon.config.SettingsIslands;
import it.tristana.farmingtycoon.config.SettingsMessages;
import it.tristana.farmingtycoon.database.FarmingDatabase;
import it.tristana.farmingtycoon.database.FarmingUser;
import it.tristana.farmingtycoon.farm.IslandsManager;
import it.tristana.farmingtycoon.helper.FarmingPapiHook;

public class Main extends PluginDraft implements Reloadable, DatabaseHolder {

	public static final String DEFAULT_SCHEMATIC_FILE = "default_farm.schematic";

	private static final long SAVE_TIMEOUT = 60 * 60 * 1000;

	private File folder;
	private File schematicsFolder;
	private boolean isPapiEnabled;
	private boolean isDisabled;

	private FarmingDatabase database;
	private UsersManager<FarmingUser> usersManager;
	private Clock autosaveClock;
	private Clock usersClock;

	private IslandsManager islandsManager;

	private SettingsMessages settingsMessages;
	private SettingsFarm settingsFarm;
	private SettingsIslands settingsIslands;
	private ConfigIslandCounter configIslandCounter;

	@Override
	public void onEnable() {
		folder = getFolder();
		try {
			schematicsFolder = checkSchematicsFolder();
			database = getDatabase();
			database.closeConnection(database.openConnection());
		} catch (Exception e) {
			writeThrowableOnErrorsFile(e);
			CommonsHelper.consoleInfo("Can't open the database connection! Check the config and the errors file");
			isDisabled = true;
			return;
		}

		loadConfigs();
		setupManagers();
		startClocks();
		registerListeners();
		isPapiEnabled = Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null;
		if (isPapiEnabled) {
			new FarmingPapiHook(this, usersManager);
		}
		registerCommand(this, FarmCommand.class, "farm", ConfigMessages.FILE_NAME);
	}

	@Override
	public void onDisable() {
		if (isDisabled) {
			return;
		}

		stopClocks();
		usersManager.saveOnlineUsers();
	}

	@Override
	public void reload() {
		settingsMessages.reload();
		settingsFarm.reload();
		settingsIslands.reload();
	}

	@Override
	public FarmingDatabase getStorage() {
		return database;
	}

	public UsersManager<FarmingUser> getUsersManager() {
		return usersManager;
	}
	
	public SettingsMessages getSettingsMessages() {
		return settingsMessages;
	}

	public SettingsFarm getSettingsFarm() {
		return settingsFarm;
	}
	
	public SettingsIslands getSettingsIslands() {
		return settingsIslands;
	}

	public IslandsManager getIslandsBroker() {
		return islandsManager;
	}

	public File getSchematic(String name) {
		return new File(schematicsFolder, name);
	}
	
	public boolean isPapiEnabled() {
		return isPapiEnabled;
	}

	private File checkSchematicsFolder() throws IOException {
		File schematicsFolder = new File(folder, "schematics");
		if (schematicsFolder.exists()) {
			return schematicsFolder;
		}

		Files.copy(getResource(DEFAULT_SCHEMATIC_FILE), Path.of(new File(schematicsFolder, DEFAULT_SCHEMATIC_FILE).getAbsolutePath()));
		return schematicsFolder;
	}

	private void loadConfigs() {
		settingsMessages = new SettingsMessages(folder);
		settingsIslands = new SettingsIslands(folder);
		settingsFarm = new SettingsFarm(folder);
		configIslandCounter = new ConfigIslandCounter(folder);
	}

	private void setupManagers() {
		usersManager = new BasicUsersManager<>(database);
		islandsManager = new IslandsManager(this, usersManager, settingsIslands, configIslandCounter);
	}

	private void registerListeners() {
		register(new LoginQuitListener<>(usersManager, database, this, (loginEvent, user) -> {
			usersClock.add(user);
		}, (quitEvent, user) -> {
			usersClock.remove(user);
		}));
	}

	private void startClocks() {
		autosaveClock = new Clock();
		autosaveClock.add(() -> usersManager.saveOnlineUsers());
		autosaveClock.schedule(this, SAVE_TIMEOUT);

		usersClock = new Clock();
		usersClock.schedule(this, 1000);
	}

	private void stopClocks() {
		autosaveClock.cancel();
		usersClock.cancel();
	}

	private FarmingDatabase getDatabase() {
		ConfigFarmDatabase config = new ConfigFarmDatabase(folder);
		String host = config.getString(ConfigFarmDatabase.HOST);
		String database = config.getString(ConfigFarmDatabase.DATABASE);
		String username = config.getString(ConfigFarmDatabase.USER);
		String password = config.getString(ConfigFarmDatabase.PASSWORD);
		int port = Integer.parseInt(config.getString(ConfigFarmDatabase.PORT));
		String tablePlayers = config.getString(ConfigFarmDatabase.TABLE_PLAYERS);
		String tableIslands = config.getString(ConfigFarmDatabase.TABLE_ISLANDS);
		String tableFarms = config.getString(ConfigFarmDatabase.TABLE_FARMS);
		return new FarmingDatabase(host, database, username, password, port, this, tableIslands, tableFarms, tablePlayers);
	}
}
