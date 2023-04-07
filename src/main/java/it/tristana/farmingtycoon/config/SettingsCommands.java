package it.tristana.farmingtycoon.config;

import java.io.File;

import it.tristana.commons.config.Settings;

public class SettingsCommands extends Settings<ConfigCommands> {

	private String commandGoExecuted;
	private String commandGoHelp;
	
	public SettingsCommands(File folder) {
		super(folder, ConfigCommands.class);
	}

	@Override
	protected void reload(ConfigCommands config) {
		commandGoExecuted = config.getString(ConfigCommands.COMMAND_GO_EXECUTED);
		commandGoHelp = config.getString(ConfigCommands.COMMAND_GO_HELP);
	}

	public String getCommandGoExecuted() {
		return commandGoExecuted;
	}

	public String getCommandGoHelp() {
		return commandGoHelp;
	}
}
