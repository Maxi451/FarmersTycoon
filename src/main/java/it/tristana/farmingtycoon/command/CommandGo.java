package it.tristana.farmingtycoon.command;

import org.bukkit.command.CommandSender;

public class CommandGo extends FarmSubCommand {

	public CommandGo(FarmCommand main, String name, String permission) {
		super(main, name, permission);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		
	}
	
	@Override
	protected boolean requiresPlayer() {
		return true;
	}

	@Override
	protected String getHelp() {
		return settingsCommands.getCommandGoHelp();
	}
}
