package it.tristana.farmingtycoon.command;

import org.bukkit.entity.Player;

import it.tristana.commons.command.SubCommand;
import it.tristana.commons.interfaces.database.UsersManager;
import it.tristana.farmingtycoon.Main;
import it.tristana.farmingtycoon.config.SettingsCommands;
import it.tristana.farmingtycoon.database.FarmingUser;

public abstract class FarmSubCommand extends SubCommand {

	protected final Main plugin;
	protected final FarmCommand main;
	protected final UsersManager<FarmingUser> usersManager;
	protected final SettingsCommands settingsCommands;

	public FarmSubCommand(FarmCommand main, String name, String permission) {
		super(main, name, permission);
		this.plugin = main.getPlugin();
		this.main = main;
		this.usersManager = plugin.getUsersManager();
		this.settingsCommands = plugin.getSettingsCommands();
	}

	protected FarmingUser getUser(Player player) {
		return usersManager.getUser(player);
	}
}
