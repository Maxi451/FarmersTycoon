package it.tristana.farmingtycoon.config;

import java.io.File;

import it.tristana.commons.config.Settings;

public class SettingsMessages extends Settings<ConfigMessages> {

	private String[] units;
	
	public SettingsMessages(File folder) {
		super(folder, ConfigMessages.class);
	}

	@Override
	protected void reload(ConfigMessages config) {
		units = config.getList(ConfigMessages.UNITS).toArray(new String[0]);
	}
	
	public String[] getUnits() {
		return units;
	}
}
