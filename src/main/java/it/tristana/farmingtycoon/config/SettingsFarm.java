package it.tristana.farmingtycoon.config;

import java.io.File;

import it.tristana.commons.config.Settings;
import it.tristana.commons.helper.CommonsHelper;

public class SettingsFarm extends Settings<ConfigFarm> {

	private double buyPriceMultiplier;
	private double upgradePriceMultiplier;
	private double incomeLevelMultiplier;
	
	private String grassName;
	private double grassBaseIncome;
	private double grassBaseUpgradePrice;
	private double grassLevelMultiplier;
	private double grassUpgradePriceMultiplier;
	private int grassResetTicks;
	private double grassIncreaseMultiplierPerfect;
	private double grassMaxMultiplier;
	
	private String wheatName;
	private double wheatBaseIncome;
	private double wheatBaseBuyPrice;
	private double wheatBaseUpgradePrice;

	private String potatoName;
	private double potatoBaseIncome;
	private double potatoBaseBuyPrice;
	private double potatoBaseUpgradePrice;

	private String carrotName;
	private double carrotBaseIncome;
	private double carrotBaseBuyPrice;
	private double carrotBaseUpgradePrice;

	private String beetrootName;
	private double beetrootBaseIncome;
	private double beetrootBaseBuyPrice;
	private double beetrootBaseUpgradePrice;

	private String sugarCaneName;
	private double sugarCaneBaseIncome;
	private double sugarCaneBaseBuyPrice;
	private double sugarCaneBaseUpgradePrice;

	private String mushroomName;
	private double mushroomBaseIncome;
	private double mushroomBaseBuyPrice;
	private double mushroomBaseUpgradePrice;

	private String cactusName;
	private double cactusBaseIncome;
	private double cactusBaseBuyPrice;
	private double cactusBaseUpgradePrice;

	private String saplingName;
	private double saplingBaseIncome;
	private double saplingBaseBuyPrice;
	private double saplingBaseUpgradePrice;

	private String waterLilyName;
	private double waterLilyBaseIncome;
	private double waterLilyBaseBuyPrice;
	private double waterLilyBaseUpgradePrice;

	private String melonName;
	private double melonBaseIncome;
	private double melonBaseBuyPrice;
	private double melonBaseUpgradePrice;

	private String pumpkinName;
	private double pumpkinBaseIncome;
	private double pumpkinBaseBuyPrice;
	private double pumpkinBaseUpgradePrice;

	private String sweetBerriesName;
	private double sweetBerriesBaseIncome;
	private double sweetBerriesBaseBuyPrice;
	private double sweetBerriesBaseUpgradePrice;

	private String chorusName;
	private double chorusBaseIncome;
	private double chorusBaseBuyPrice;
	private double chorusBaseUpgradePrice;

	private String cocoaName;
	private double cocoaBaseIncome;
	private double cocoaBaseBuyPrice;
	private double cocoaBaseUpgradePrice;

	private String netherWartName;
	private double netherWartBaseIncome;
	private double netherWartBaseBuyPrice;
	private double netherWartBaseUpgradePrice;

	private String deadBushName;
	private double deadBushBaseIncome;
	private double deadBushBaseBuyPrice;
	private double deadBushBaseUpgradePrice;

	public SettingsFarm(File folder) {
		super(folder, ConfigFarm.class);
	}

	@Override
	protected void reload(ConfigFarm config) {
		buyPriceMultiplier = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.BUY_PRICE_MULTIPLIER), 1.4);
		upgradePriceMultiplier = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.UPGRADE_PRICE_MULTIPLIER), 10);
		incomeLevelMultiplier = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.INCOME_LEVEL_MULTIPLIER), 2);

		grassName = config.getString(ConfigFarm.GRASS_NAME);
		grassBaseIncome = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.GRASS_BASE_INCOME), 1);
		grassBaseUpgradePrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.GRASS_BASE_UPGRADE_PRICE), 10000);
		grassLevelMultiplier = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.GRASS_LEVEL_MULTIPLIER), 25);
		grassUpgradePriceMultiplier = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.GRASS_UPGRADE_PRICE_MULTIPLIER), 1000);
		grassResetTicks = CommonsHelper.parseIntOrGetDefault(config.getString(ConfigFarm.GRASS_RESET_TICKS), 4);
		grassIncreaseMultiplierPerfect = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.GRASS_INCREASE_MULTIPLIER_PERFECT), 0.05);
		grassMaxMultiplier = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.GRASS_MAX_MULTIPLIER), 3);
		
		wheatName = config.getString(ConfigFarm.WHEAT_NAME);
		wheatBaseIncome = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.WHEAT_BASE_INCOME), 0.2);
		wheatBaseBuyPrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.WHEAT_BASE_BUY_PRICE), 25);
		wheatBaseUpgradePrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.WHEAT_BASE_UPGRADE_PRICE), 0);

		potatoName = config.getString(ConfigFarm.POTATO_NAME);
		potatoBaseIncome = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.POTATO_BASE_INCOME), 0.2);
		potatoBaseBuyPrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.POTATO_BASE_BUY_PRICE), 25);
		potatoBaseUpgradePrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.POTATO_BASE_UPGRADE_PRICE), 0);

		carrotName = config.getString(ConfigFarm.CARROT_NAME);
		carrotBaseIncome = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.CARROT_BASE_INCOME), 0.2);
		carrotBaseBuyPrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.CARROT_BASE_BUY_PRICE), 25);
		carrotBaseUpgradePrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.CARROT_BASE_UPGRADE_PRICE), 0);

		beetrootName = config.getString(ConfigFarm.BEETROOT_NAME);
		beetrootBaseIncome = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.BEETROOT_BASE_INCOME), 0.2);
		beetrootBaseBuyPrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.BEETROOT_BASE_BUY_PRICE), 25);
		beetrootBaseUpgradePrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.BEETROOT_BASE_UPGRADE_PRICE), 0);

		sugarCaneName = config.getString(ConfigFarm.SUGAR_CANE_NAME);
		sugarCaneBaseIncome = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.SUGAR_CANE_BASE_INCOME), 0.2);
		sugarCaneBaseBuyPrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.SUGAR_CANE_BASE_BUY_PRICE), 25);
		sugarCaneBaseUpgradePrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.SUGAR_CANE_BASE_UPGRADE_PRICE), 0);

		mushroomName = config.getString(ConfigFarm.MUSHROOM_NAME);
		mushroomBaseIncome = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.MUSHROOM_BASE_INCOME), 0.2);
		mushroomBaseBuyPrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.MUSHROOM_BASE_BUY_PRICE), 25);
		mushroomBaseUpgradePrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.MUSHROOM_BASE_UPGRADE_PRICE), 0);

		cactusName = config.getString(ConfigFarm.CACTUS_NAME);
		cactusBaseIncome = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.CACTUS_BASE_INCOME), 0.2);
		cactusBaseBuyPrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.CACTUS_BASE_BUY_PRICE), 25);
		cactusBaseUpgradePrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.CACTUS_BASE_UPGRADE_PRICE), 0);

		saplingName = config.getString(ConfigFarm.SAPLING_NAME);
		saplingBaseIncome = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.SAPLING_BASE_INCOME), 0.2);
		saplingBaseBuyPrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.SAPLING_BASE_BUY_PRICE), 25);
		saplingBaseUpgradePrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.SAPLING_BASE_UPGRADE_PRICE), 0);

		waterLilyName = config.getString(ConfigFarm.WATER_LILY_NAME);
		waterLilyBaseIncome = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.WATER_LILY_BASE_INCOME), 0.2);
		waterLilyBaseBuyPrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.WATER_LILY_BASE_BUY_PRICE), 25);
		waterLilyBaseUpgradePrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.WATER_LILY_BASE_UPGRADE_PRICE), 0);

		melonName = config.getString(ConfigFarm.MELON_NAME);
		melonBaseIncome = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.MELON_BASE_INCOME), 0.2);
		melonBaseBuyPrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.MELON_BASE_BUY_PRICE), 25);
		melonBaseUpgradePrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.MELON_BASE_UPGRADE_PRICE), 0);

		pumpkinName = config.getString(ConfigFarm.PUMPKIN_NAME);
		pumpkinBaseIncome = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.PUMPKIN_BASE_INCOME), 0.2);
		pumpkinBaseBuyPrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.PUMPKIN_BASE_BUY_PRICE), 25);
		pumpkinBaseUpgradePrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.PUMPKIN_BASE_UPGRADE_PRICE), 0);

		sweetBerriesName = config.getString(ConfigFarm.SWEET_BERRIES_NAME);
		sweetBerriesBaseIncome = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.SWEET_BERRIES_BASE_INCOME), 0.2);
		sweetBerriesBaseBuyPrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.SWEET_BERRIES_BASE_BUY_PRICE), 25);
		sweetBerriesBaseUpgradePrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.SWEET_BERRIES_BASE_UPGRADE_PRICE), 0);

		chorusName = config.getString(ConfigFarm.CHORUS_NAME);
		chorusBaseIncome = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.CHORUS_BASE_INCOME), 0.2);
		chorusBaseBuyPrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.CHORUS_BASE_BUY_PRICE), 25);
		chorusBaseUpgradePrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.CHORUS_BASE_UPGRADE_PRICE), 0);

		cocoaName = config.getString(ConfigFarm.COCOA_NAME);
		cocoaBaseIncome = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.COCOA_BASE_INCOME), 0.2);
		cocoaBaseBuyPrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.COCOA_BASE_BUY_PRICE), 25);
		cocoaBaseUpgradePrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.COCOA_BASE_UPGRADE_PRICE), 0);

		netherWartName = config.getString(ConfigFarm.NETHER_WART_NAME);
		netherWartBaseIncome = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.NETHER_WART_BASE_INCOME), 0.2);
		netherWartBaseBuyPrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.NETHER_WART_BASE_BUY_PRICE), 25);
		netherWartBaseUpgradePrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.NETHER_WART_BASE_UPGRADE_PRICE), 0);

		deadBushName = config.getString(ConfigFarm.DEAD_BUSH_NAME);
		deadBushBaseIncome = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.DEAD_BUSH_BASE_INCOME), 0.2);
		deadBushBaseBuyPrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.DEAD_BUSH_BASE_BUY_PRICE), 25);
		deadBushBaseUpgradePrice = CommonsHelper.parseDoubleOrGetDefault(config.getString(ConfigFarm.DEAD_BUSH_BASE_UPGRADE_PRICE), 0);
	}
	
	public int getGrassResetTicks() {
		return grassResetTicks;
	}

	public double getGrassIncreaseMultiplierPerfect() {
		return grassIncreaseMultiplierPerfect;
	}

	public double getGrassMaxMultiplier() {
		return grassMaxMultiplier;
	}

	public String getGrassName() {
		return grassName;
	}

	public double getGrassBaseIncome() {
		return grassBaseIncome;
	}

	public double getGrassBaseUpgradePrice() {
		return grassBaseUpgradePrice;
	}

	public double getGrassLevelMultiplier() {
		return grassLevelMultiplier;
	}

	public double getGrassUpgradePriceMultiplier() {
		return grassUpgradePriceMultiplier;
	}

	public double getBuyPriceMultiplier() {
		return buyPriceMultiplier;
	}

	public double getUpgradePriceMultiplier() {
		return upgradePriceMultiplier;
	}

	public double getIncomeLevelMultiplier() {
		return incomeLevelMultiplier;
	}

	public String getWheatName() {
		return wheatName;
	}

	public String getPotatoName() {
		return potatoName;
	}

	public String getCarrotName() {
		return carrotName;
	}

	public String getBeetrootName() {
		return beetrootName;
	}

	public String getSugarCaneName() {
		return sugarCaneName;
	}

	public String getMushroomName() {
		return mushroomName;
	}

	public String getCactusName() {
		return cactusName;
	}

	public String getSaplingName() {
		return saplingName;
	}

	public String getWaterLilyName() {
		return waterLilyName;
	}

	public String getMelonName() {
		return melonName;
	}

	public String getPumpkinName() {
		return pumpkinName;
	}

	public String getSweetBerriesName() {
		return sweetBerriesName;
	}

	public String getChorusName() {
		return chorusName;
	}

	public String getCocoaName() {
		return cocoaName;
	}

	public String getNetherWartName() {
		return netherWartName;
	}

	public String getDeadBushName() {
		return deadBushName;
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
