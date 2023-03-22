package it.tristana.farmingtycoon.config;

import java.io.File;

import it.tristana.commons.config.Config;

public class ConfigFarm extends Config {

	private static final String BASE_INCOME = "base-income";
	private static final String BASE_UPGRADE_PRICE = "base-upgrade-price";
	
	private static final String WHEAT = "wheat.";
	public static final String WHEAT_BASE_INCOME = WHEAT + BASE_INCOME;
	public static final String WHEAT_BASE_UPGRADE_PRICE = WHEAT + BASE_UPGRADE_PRICE;
	
	public ConfigFarm(File folder) {
		super(folder);
	}

	@Override
	protected void createDefault() {
		set(WHEAT_BASE_INCOME, "0.2");
		set(WHEAT_BASE_UPGRADE_PRICE, "25");
	}
}
