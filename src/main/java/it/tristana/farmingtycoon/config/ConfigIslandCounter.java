package it.tristana.farmingtycoon.config;

import java.io.File;

import it.tristana.commons.config.Config;

public class ConfigIslandCounter extends Config {

	public static final String X = "x";
	public static final String Z = "z";
	
	public ConfigIslandCounter(File folder) {
		super(new File(folder, "dont-touch-me.yml"));
	}

	@Override
	protected void createDefault() {
		set(X, "0");
		set(Z, "0");
	}
}
