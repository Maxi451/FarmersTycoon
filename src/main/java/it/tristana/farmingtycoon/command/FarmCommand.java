package it.tristana.farmingtycoon.command;

import it.tristana.commons.command.MainCommand;
import it.tristana.commons.config.SettingsDefaultCommands;
import it.tristana.commons.interfaces.database.UsersManager;
import it.tristana.farmingtycoon.Main;
import it.tristana.farmingtycoon.database.FarmingUser;

public class FarmCommand extends MainCommand<Main> {

	private UsersManager<FarmingUser> usersManager;
	
	public FarmCommand(Main plugin, SettingsDefaultCommands settings, String command) {
		super(plugin, settings, command);
		usersManager = plugin.getUsersManager();
	}

}
