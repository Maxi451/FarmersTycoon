package it.tristana.farmingtycoon.command;

import it.tristana.commons.command.MainCommand;
import it.tristana.commons.config.SettingsDefaultCommands;
import it.tristana.farmingtycoon.Main;

public class FarmCommand extends MainCommand<Main> {
	
	public static final String ADMIN_PERMS = "farm.admin";
	
	public FarmCommand(Main plugin, SettingsDefaultCommands settings, String command) {
		super(plugin, settings, command);
		String adminPerms = getAdminPerms();
		registerSubCommand(new CommandMoney(this, "money", adminPerms));
		
		registerSubCommand(new CommandGo(this, "go", null));
	}
	
	@Override
	protected String getAdminPerms() {
		return ADMIN_PERMS;
	}
}
