package it.tristana.farmingtycoon.config;

import java.io.File;

import it.tristana.commons.config.Config;

public class ConfigCommands extends Config {

	public static final String FILE_NAME = "commands.yml";
	
	private static final String COMMAND = "command.";
	private static final String HELP = "help";
	private static final String EXECUTED = "executed";

	public static final String WAITING_PROFILE_LOAD = "waiting-profile-load";
	
	private static final String COMMAND_GO = COMMAND + "go.";
	public static final String COMMAND_GO_EXECUTED = COMMAND_GO + EXECUTED;
	public static final String COMMAND_GO_HELP = COMMAND_GO + HELP;

	public ConfigCommands(File folder) {
		super(new File(folder, FILE_NAME));
	}

	@Override
	protected void createDefault() {
		set(WAITING_PROFILE_LOAD, "&cThe profile is loading");
		
		set(COMMAND_GO_EXECUTED, "&aWhoosh!");
		set(COMMAND_GO_HELP, "Teleports back to your island");
	}
}
