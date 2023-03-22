package it.tristana.farmingtycoon.config;

import java.io.File;

import it.tristana.commons.config.Settings;
import it.tristana.commons.helper.CommonsHelper;

public class SettingsFarm extends Settings<ConfigFarm> {

	private double wheatBaseIncome;
	private double wheatBaseUpgradePrice;
	
	public SettingsFarm(File folder) {
		super(folder, ConfigFarm.class);
	}

	@Override
	protected void reload(ConfigFarm config) {
		wheatBaseIncome = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.WHEAT_BASE_INCOME), 0.2);
		wheatBaseUpgradePrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.WHEAT_BASE_UPGRADE_PRICE), 25);
	}

	public double getWheatBaseIncome() {
		return wheatBaseIncome;
	}

	public double getWheatBaseUpgradePrice() {
		return wheatBaseUpgradePrice;
	}
}
