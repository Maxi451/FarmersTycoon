package it.tristana.farmingtycoon;

import it.tristana.commons.database.DatabaseManager;
import it.tristana.commons.helper.PluginDraft;
import it.tristana.commons.interfaces.DatabaseHolder;
import it.tristana.commons.interfaces.Reloadable;
import it.tristana.commons.interfaces.database.Database;
import it.tristana.farmingtycoon.command.FarmCommand;
import it.tristana.farmingtycoon.config.SettingsFarm;
import it.tristana.farmingtycoon.database.FarmingUser;

public class Main extends PluginDraft implements Reloadable, DatabaseHolder {

	private SettingsFarm settingsFarm;
	private DatabaseManager<FarmingUser> database;
	
	@Override
	public void onEnable() {
		registerCommand(this, FarmCommand.class, "farm", "");
	}
	
	@Override
	public void onDisable() {
		
	}

	@Override
	public void reload() {
		
	}

	@Override
	public Database getStorage() {
		return database;
	}
	
	public SettingsFarm getSettingsFarm() {
		return settingsFarm;
	}
}
