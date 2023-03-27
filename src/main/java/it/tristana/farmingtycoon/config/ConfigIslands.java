package it.tristana.farmingtycoon.config;

import java.io.File;

import it.tristana.commons.config.Config;

public class ConfigIslands extends Config {

	public ConfigIslands(File folder) {
		super(new File(folder, "islands.yml"));
	}

	@Override
	protected void createDefault() {
		
	}

}
