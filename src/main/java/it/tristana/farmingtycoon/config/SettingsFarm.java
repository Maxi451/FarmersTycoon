package it.tristana.farmingtycoon.config;

import java.io.File;

import it.tristana.commons.config.Settings;
import it.tristana.commons.helper.CommonsHelper;

public class SettingsFarm extends Settings<ConfigFarm> {

	private double wheatBaseIncome;
	private double wheatBaseBuyPrice;
	private double wheatBaseUpgradePrice;

	private double potatoBaseIncome;
	private double potatoBaseBuyPrice;
	private double potatoBaseUpgradePrice;

	private double carrotBaseIncome;
	private double carrotBaseBuyPrice;
	private double carrotBaseUpgradePrice;

	private double beetrootBaseIncome;
	private double beetrootBaseBuyPrice;
	private double beetrootBaseUpgradePrice;

	private double sugarCaneBaseIncome;
	private double sugarCaneBaseBuyPrice;
	private double sugarCaneBaseUpgradePrice;

	private double mushroomBaseIncome;
	private double mushroomBaseBuyPrice;
	private double mushroomBaseUpgradePrice;

	private double cactusBaseIncome;
	private double cactusBaseBuyPrice;
	private double cactusBaseUpgradePrice;

	private double saplingBaseIncome;
	private double saplingBaseBuyPrice;
	private double saplingBaseUpgradePrice;

	private double waterLilyBaseIncome;
	private double waterLilyBaseBuyPrice;
	private double waterLilyBaseUpgradePrice;

	private double melonBaseIncome;
	private double melonBaseBuyPrice;
	private double melonBaseUpgradePrice;

	private double pumpkinBaseIncome;
	private double pumpkinBaseBuyPrice;
	private double pumpkinBaseUpgradePrice;

	private double sweetBerriesBaseIncome;
	private double sweetBerriesBaseBuyPrice;
	private double sweetBerriesBaseUpgradePrice;

	private double chorusBaseIncome;
	private double chorusBaseBuyPrice;
	private double chorusBaseUpgradePrice;

	private double cocoaBaseIncome;
	private double cocoaBaseBuyPrice;
	private double cocoaBaseUpgradePrice;

	private double netherWartBaseIncome;
	private double netherWartBaseBuyPrice;
	private double netherWartBaseUpgradePrice;

	private double deadBushBaseIncome;
	private double deadBushBaseBuyPrice;
	private double deadBushBaseUpgradePrice;

	public SettingsFarm(File folder) {
		super(folder, ConfigFarm.class);
	}

	@Override
	protected void reload(ConfigFarm config) {
		wheatBaseIncome = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.WHEAT_BASE_INCOME), 0.2);
		wheatBaseBuyPrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.WHEAT_BASE_BUY_PRICE), 25);
		wheatBaseUpgradePrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.WHEAT_BASE_UPGRADE_PRICE), 0);

		potatoBaseIncome = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.POTATO_BASE_INCOME), 0.2);
		potatoBaseBuyPrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.POTATO_BASE_BUY_PRICE), 25);
		potatoBaseUpgradePrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.POTATO_BASE_UPGRADE_PRICE), 0);

		carrotBaseIncome = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.CARROT_BASE_INCOME), 0.2);
		carrotBaseBuyPrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.CARROT_BASE_BUY_PRICE), 25);
		carrotBaseUpgradePrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.CARROT_BASE_UPGRADE_PRICE), 0);

		beetrootBaseIncome = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.BEETROOT_BASE_INCOME), 0.2);
		beetrootBaseBuyPrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.BEETROOT_BASE_BUY_PRICE), 25);
		beetrootBaseUpgradePrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.BEETROOT_BASE_UPGRADE_PRICE), 0);

		sugarCaneBaseIncome = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.SUGAR_CANE_BASE_INCOME), 0.2);
		sugarCaneBaseBuyPrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.SUGAR_CANE_BASE_BUY_PRICE), 25);
		sugarCaneBaseUpgradePrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.SUGAR_CANE_BASE_UPGRADE_PRICE), 0);

		mushroomBaseIncome = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.MUSHROOM_BASE_INCOME), 0.2);
		mushroomBaseBuyPrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.MUSHROOM_BASE_BUY_PRICE), 25);
		mushroomBaseUpgradePrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.MUSHROOM_BASE_UPGRADE_PRICE), 0);

		cactusBaseIncome = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.CACTUS_BASE_INCOME), 0.2);
		cactusBaseBuyPrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.CACTUS_BASE_BUY_PRICE), 25);
		cactusBaseUpgradePrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.CACTUS_BASE_UPGRADE_PRICE), 0);

		saplingBaseIncome = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.SAPLING_BASE_INCOME), 0.2);
		saplingBaseBuyPrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.SAPLING_BASE_BUY_PRICE), 25);
		saplingBaseUpgradePrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.SAPLING_BASE_UPGRADE_PRICE), 0);

		waterLilyBaseIncome = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.WATER_LILY_BASE_INCOME), 0.2);
		waterLilyBaseBuyPrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.WATER_LILY_BASE_BUY_PRICE), 25);
		waterLilyBaseUpgradePrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.WATER_LILY_BASE_UPGRADE_PRICE), 0);

		melonBaseIncome = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.MELON_BASE_INCOME), 0.2);
		melonBaseBuyPrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.MELON_BASE_BUY_PRICE), 25);
		melonBaseUpgradePrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.MELON_BASE_UPGRADE_PRICE), 0);

		pumpkinBaseIncome = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.PUMPKIN_BASE_INCOME), 0.2);
		pumpkinBaseBuyPrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.PUMPKIN_BASE_BUY_PRICE), 25);
		pumpkinBaseUpgradePrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.PUMPKIN_BASE_UPGRADE_PRICE), 0);

		sweetBerriesBaseIncome = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.SWEET_BERRIES_BASE_INCOME), 0.2);
		sweetBerriesBaseBuyPrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.SWEET_BERRIES_BASE_BUY_PRICE), 25);
		sweetBerriesBaseUpgradePrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.SWEET_BERRIES_BASE_UPGRADE_PRICE), 0);

		chorusBaseIncome = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.CHORUS_BASE_INCOME), 0.2);
		chorusBaseBuyPrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.CHORUS_BASE_BUY_PRICE), 25);
		chorusBaseUpgradePrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.CHORUS_BASE_UPGRADE_PRICE), 0);

		cocoaBaseIncome = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.COCOA_BASE_INCOME), 0.2);
		cocoaBaseBuyPrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.COCOA_BASE_BUY_PRICE), 25);
		cocoaBaseUpgradePrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.COCOA_BASE_UPGRADE_PRICE), 0);

		netherWartBaseIncome = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.NETHER_WART_BASE_INCOME), 0.2);
		netherWartBaseBuyPrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.NETHER_WART_BASE_BUY_PRICE), 25);
		netherWartBaseUpgradePrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.NETHER_WART_BASE_UPGRADE_PRICE), 0);

		deadBushBaseIncome = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.DEAD_BUSH_BASE_INCOME), 0.2);
		deadBushBaseBuyPrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.DEAD_BUSH_BASE_BUY_PRICE), 25);
		deadBushBaseUpgradePrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.DEAD_BUSH_BASE_UPGRADE_PRICE), 0);
	}

	public double getWheatBaseIncome() {
		return wheatBaseIncome;
	}

	public double getWheatBaseBuyPrice() {
		return wheatBaseBuyPrice;
	}

	public double getWheatBaseUpgradePrice() {
		return wheatBaseUpgradePrice;
	}

	public double getPotatoBaseIncome() {
		return potatoBaseIncome;
	}

	public double getPotatoBaseBuyPrice() {
		return potatoBaseBuyPrice;
	}

	public double getPotatoBaseUpgradePrice() {
		return potatoBaseUpgradePrice;
	}

	public double getCarrotBaseIncome() {
		return carrotBaseIncome;
	}

	public double getCarrotBaseBuyPrice() {
		return carrotBaseBuyPrice;
	}

	public double getCarrotBaseUpgradePrice() {
		return carrotBaseUpgradePrice;
	}

	public double getBeetrootBaseIncome() {
		return beetrootBaseIncome;
	}

	public double getBeetrootBaseBuyPrice() {
		return beetrootBaseBuyPrice;
	}

	public double getBeetrootBaseUpgradePrice() {
		return beetrootBaseUpgradePrice;
	}

	public double getSugarCaneBaseIncome() {
		return sugarCaneBaseIncome;
	}

	public double getSugarCaneBaseBuyPrice() {
		return sugarCaneBaseBuyPrice;
	}

	public double getSugarCaneBaseUpgradePrice() {
		return sugarCaneBaseUpgradePrice;
	}

	public double getMushroomBaseIncome() {
		return mushroomBaseIncome;
	}

	public double getMushroomBaseBuyPrice() {
		return mushroomBaseBuyPrice;
	}

	public double getMushroomBaseUpgradePrice() {
		return mushroomBaseUpgradePrice;
	}

	public double getCactusBaseIncome() {
		return cactusBaseIncome;
	}

	public double getCactusBaseBuyPrice() {
		return cactusBaseBuyPrice;
	}

	public double getCactusBaseUpgradePrice() {
		return cactusBaseUpgradePrice;
	}

	public double getSaplingBaseIncome() {
		return saplingBaseIncome;
	}

	public double getSaplingBaseBuyPrice() {
		return saplingBaseBuyPrice;
	}

	public double getSaplingBaseUpgradePrice() {
		return saplingBaseUpgradePrice;
	}

	public double getWaterLilyBaseIncome() {
		return waterLilyBaseIncome;
	}

	public double getWaterLilyBaseBuyPrice() {
		return waterLilyBaseBuyPrice;
	}

	public double getWaterLilyBaseUpgradePrice() {
		return waterLilyBaseUpgradePrice;
	}

	public double getMelonBaseIncome() {
		return melonBaseIncome;
	}

	public double getMelonBaseBuyPrice() {
		return melonBaseBuyPrice;
	}

	public double getMelonBaseUpgradePrice() {
		return melonBaseUpgradePrice;
	}

	public double getPumpkinBaseIncome() {
		return pumpkinBaseIncome;
	}

	public double getPumpkinBaseBuyPrice() {
		return pumpkinBaseBuyPrice;
	}

	public double getPumpkinBaseUpgradePrice() {
		return pumpkinBaseUpgradePrice;
	}

	public double getSweetBerriesBaseIncome() {
		return sweetBerriesBaseIncome;
	}

	public double getSweetBerriesBaseBuyPrice() {
		return sweetBerriesBaseBuyPrice;
	}

	public double getSweetBerriesBaseUpgradePrice() {
		return sweetBerriesBaseUpgradePrice;
	}

	public double getChorusBaseIncome() {
		return chorusBaseIncome;
	}

	public double getChorusBaseBuyPrice() {
		return chorusBaseBuyPrice;
	}

	public double getChorusBaseUpgradePrice() {
		return chorusBaseUpgradePrice;
	}

	public double getCocoaBaseIncome() {
		return cocoaBaseIncome;
	}

	public double getCocoaBaseBuyPrice() {
		return cocoaBaseBuyPrice;
	}

	public double getCocoaBaseUpgradePrice() {
		return cocoaBaseUpgradePrice;
	}

	public double getNetherWartBaseIncome() {
		return netherWartBaseIncome;
	}

	public double getNetherWartBaseBuyPrice() {
		return netherWartBaseBuyPrice;
	}

	public double getNetherWartBaseUpgradePrice() {
		return netherWartBaseUpgradePrice;
	}

	public double getDeadBushBaseIncome() {
		return deadBushBaseIncome;
	}

	public double getDeadBushBaseBuyPrice() {
		return deadBushBaseBuyPrice;
	}

	public double getDeadBushBaseUpgradePrice() {
		return deadBushBaseUpgradePrice;
	}
}
