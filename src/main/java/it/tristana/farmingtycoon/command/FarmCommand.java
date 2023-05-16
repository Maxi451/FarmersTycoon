package it.tristana.farmingtycoon.command;

import it.tristana.commons.command.MainCommand;
import it.tristana.commons.config.SettingsDefaultCommands;
import it.tristana.farmingtycoon.Main;

public class FarmCommand extends MainCommand<Main> {
	
	public FarmCommand(Main plugin, SettingsDefaultCommands settings, String command) {
		super(plugin, settings, command);
		registerSubCommand(new CommandGo(this, "go", null));
	}
}
