package it.tristana.farmingtycoon.config;

import java.io.File;

import it.tristana.commons.config.Config;

public class ConfigFarm extends Config {

	public static final String BUY_PRICE_MULTIPLIER = "buy-price-multiplier";
	public static final String UPGRADE_PRICE_MULTIPLIER = "upgrade-price-multiplier";
	public static final String INCOME_LEVEL_MULTIPLIER = "income-level-multiplier";
	
	private static final String NAME = "name";
	private static final String BASE_INCOME = "base-income";
	private static final String BASE_BUY_PRICE = "base-buy-price";
	private static final String BASE_UPGRADE_PRICE = "base-upgrade-price";

	private static final String GRASS = "grass.";
	public static final String GRASS_NAME = GRASS + NAME;
	public static final String GRASS_BASE_INCOME = GRASS + BASE_INCOME;
	public static final String GRASS_BASE_UPGRADE_PRICE = GRASS + BASE_UPGRADE_PRICE;
	public static final String GRASS_LEVEL_MULTIPLIER = GRASS + "level-multiplier";
	public static final String GRASS_UPGRADE_PRICE_MULTIPLIER = GRASS + UPGRADE_PRICE_MULTIPLIER;
	public static final String GRASS_TICKS_RESET = GRASS + "ticks-reset";
	public static final String GRASS_INCREASE_MULTIPLIER_PERFECT = "increase-multiplier-perfect";
	public static final String GRASS_MAX_MULTIPLIER = GRASS + "max-multiplier";
	
	private static final String WHEAT = "wheat.";
	public static final String WHEAT_NAME = WHEAT + NAME;
	public static final String WHEAT_BASE_INCOME = WHEAT + BASE_INCOME;
	public static final String WHEAT_BASE_BUY_PRICE = WHEAT + BASE_BUY_PRICE;
	public static final String WHEAT_BASE_UPGRADE_PRICE = WHEAT + BASE_UPGRADE_PRICE;

	private static final String POTATO = "potato.";
	public static final String POTATO_NAME = POTATO + NAME;
	public static final String POTATO_BASE_INCOME = POTATO + BASE_INCOME;
	public static final String POTATO_BASE_BUY_PRICE = POTATO + BASE_BUY_PRICE;
	public static final String POTATO_BASE_UPGRADE_PRICE = POTATO + BASE_UPGRADE_PRICE;

	private static final String CARROT = "carrot.";
	public static final String CARROT_NAME = CARROT + NAME;
	public static final String CARROT_BASE_INCOME = CARROT + BASE_INCOME;
	public static final String CARROT_BASE_BUY_PRICE = CARROT + BASE_BUY_PRICE;
	public static final String CARROT_BASE_UPGRADE_PRICE = CARROT + BASE_UPGRADE_PRICE;

	private static final String BEETROOT = "beetroot.";
	public static final String BEETROOT_NAME = BEETROOT + NAME;
	public static final String BEETROOT_BASE_INCOME = BEETROOT + BASE_INCOME;
	public static final String BEETROOT_BASE_BUY_PRICE = BEETROOT + BASE_BUY_PRICE;
	public static final String BEETROOT_BASE_UPGRADE_PRICE = BEETROOT + BASE_UPGRADE_PRICE;

	private static final String SUGAR_CANE = "sugar-cane.";
	public static final String SUGAR_CANE_NAME = SUGAR_CANE + NAME;
	public static final String SUGAR_CANE_BASE_INCOME = SUGAR_CANE + BASE_INCOME;
	public static final String SUGAR_CANE_BASE_BUY_PRICE = SUGAR_CANE + BASE_BUY_PRICE;
	public static final String SUGAR_CANE_BASE_UPGRADE_PRICE = SUGAR_CANE + BASE_UPGRADE_PRICE;

	private static final String MUSHROOM = "mushroom.";
	public static final String MUSHROOM_NAME = MUSHROOM + NAME;
	public static final String MUSHROOM_BASE_INCOME = MUSHROOM + BASE_INCOME;
	public static final String MUSHROOM_BASE_BUY_PRICE = MUSHROOM + BASE_BUY_PRICE;
	public static final String MUSHROOM_BASE_UPGRADE_PRICE = MUSHROOM + BASE_UPGRADE_PRICE;

	private static final String CACTUS = "cactus.";
	public static final String CACTUS_NAME = CACTUS + NAME;
	public static final String CACTUS_BASE_INCOME = CACTUS + BASE_INCOME;
	public static final String CACTUS_BASE_BUY_PRICE = CACTUS + BASE_BUY_PRICE;
	public static final String CACTUS_BASE_UPGRADE_PRICE = CACTUS + BASE_UPGRADE_PRICE;

	private static final String SAPLING = "sapling.";
	public static final String SAPLING_NAME = SAPLING + NAME;
	public static final String SAPLING_BASE_INCOME = SAPLING + BASE_INCOME;
	public static final String SAPLING_BASE_BUY_PRICE = SAPLING + BASE_BUY_PRICE;
	public static final String SAPLING_BASE_UPGRADE_PRICE = SAPLING + BASE_UPGRADE_PRICE;

	private static final String WATER_LILY = "water-lily.";
	public static final String WATER_LILY_NAME = WATER_LILY + NAME;
	public static final String WATER_LILY_BASE_INCOME = WATER_LILY + BASE_INCOME;
	public static final String WATER_LILY_BASE_BUY_PRICE = WATER_LILY + BASE_BUY_PRICE;
	public static final String WATER_LILY_BASE_UPGRADE_PRICE = WATER_LILY + BASE_UPGRADE_PRICE;

	private static final String MELON = "melon.";
	public static final String MELON_NAME = MELON + NAME;
	public static final String MELON_BASE_INCOME = MELON + BASE_INCOME;
	public static final String MELON_BASE_BUY_PRICE = MELON + BASE_BUY_PRICE;
	public static final String MELON_BASE_UPGRADE_PRICE = MELON + BASE_UPGRADE_PRICE;

	private static final String PUMPKIN = "pumpkin.";
	public static final String PUMPKIN_NAME = PUMPKIN + NAME;
	public static final String PUMPKIN_BASE_INCOME = PUMPKIN + BASE_INCOME;
	public static final String PUMPKIN_BASE_BUY_PRICE = PUMPKIN + BASE_BUY_PRICE;
	public static final String PUMPKIN_BASE_UPGRADE_PRICE = PUMPKIN + BASE_UPGRADE_PRICE;

	private static final String SWEET_BERRIES = "sweet-berries.";
	public static final String SWEET_BERRIES_NAME = SWEET_BERRIES + NAME;
	public static final String SWEET_BERRIES_BASE_INCOME = SWEET_BERRIES + BASE_INCOME;
	public static final String SWEET_BERRIES_BASE_BUY_PRICE = SWEET_BERRIES + BASE_BUY_PRICE;
	public static final String SWEET_BERRIES_BASE_UPGRADE_PRICE = SWEET_BERRIES + BASE_UPGRADE_PRICE;

	private static final String CHORUS = "chorus.";
	public static final String CHORUS_NAME = CHORUS + NAME;
	public static final String CHORUS_BASE_INCOME = CHORUS + BASE_INCOME;
	public static final String CHORUS_BASE_BUY_PRICE = CHORUS + BASE_BUY_PRICE;
	public static final String CHORUS_BASE_UPGRADE_PRICE = CHORUS + BASE_UPGRADE_PRICE;

	private static final String COCOA = "cocoa.";
	public static final String COCOA_NAME = COCOA + NAME;
	public static final String COCOA_BASE_INCOME = COCOA + BASE_INCOME;
	public static final String COCOA_BASE_BUY_PRICE = COCOA + BASE_BUY_PRICE;
	public static final String COCOA_BASE_UPGRADE_PRICE = COCOA + BASE_UPGRADE_PRICE;

	private static final String NETHER_WART = "nether-wart.";
	public static final String NETHER_WART_NAME = NETHER_WART + NAME;
	public static final String NETHER_WART_BASE_INCOME = NETHER_WART + BASE_INCOME;
	public static final String NETHER_WART_BASE_BUY_PRICE = NETHER_WART + BASE_BUY_PRICE;
	public static final String NETHER_WART_BASE_UPGRADE_PRICE = NETHER_WART + BASE_UPGRADE_PRICE;

	private static final String DEAD_BUSH = "dead-bush.";
	public static final String DEAD_BUSH_NAME = DEAD_BUSH + NAME;
	public static final String DEAD_BUSH_BASE_INCOME = DEAD_BUSH + BASE_INCOME;
	public static final String DEAD_BUSH_BASE_BUY_PRICE = DEAD_BUSH + BASE_BUY_PRICE;
	public static final String DEAD_BUSH_BASE_UPGRADE_PRICE = DEAD_BUSH + BASE_UPGRADE_PRICE;

	public ConfigFarm(File folder) {
		super(new File(folder, "farm.yml"));
	}

	@Override
	protected void createDefault() {
		set(BUY_PRICE_MULTIPLIER, "1.4");
		set(UPGRADE_PRICE_MULTIPLIER, "10");
		set(INCOME_LEVEL_MULTIPLIER, "2");
		
		set(GRASS_NAME, "Grass");
		set(GRASS_BASE_INCOME, "1");
		set(GRASS_BASE_UPGRADE_PRICE, "10000");
		set(GRASS_LEVEL_MULTIPLIER, "25");
		set(GRASS_UPGRADE_PRICE_MULTIPLIER, "1000");
		set(GRASS_TICKS_RESET, "60");
		set(GRASS_INCREASE_MULTIPLIER_PERFECT, "0.05");
		set(GRASS_MAX_MULTIPLIER, "3");
		
		set(WHEAT_NAME, "Wheat");
		set(WHEAT_BASE_INCOME, "0.1");
		set(WHEAT_BASE_BUY_PRICE, "25");
		set(WHEAT_BASE_UPGRADE_PRICE, "100");

		set(POTATO_NAME, "Potato");
		set(POTATO_BASE_INCOME, "2");
		set(POTATO_BASE_BUY_PRICE, "1e3");
		set(POTATO_BASE_UPGRADE_PRICE, "5e3");

		set(CARROT_NAME, "Carrot");
		set(CARROT_BASE_INCOME, "16");
		set(CARROT_BASE_BUY_PRICE, "1.25e4");
		set(CARROT_BASE_UPGRADE_PRICE, "1e5");

		set(BEETROOT_NAME, "Beetroot");
		set(BEETROOT_BASE_INCOME, "47");
		set(BEETROOT_BASE_BUY_PRICE, "4.4e4");
		set(BEETROOT_BASE_UPGRADE_PRICE, "4.2e5");

		set(MUSHROOM_NAME, "Mushroom");
		set(MUSHROOM_BASE_INCOME, "260");
		set(MUSHROOM_BASE_BUY_PRICE, "2.75e5");
		set(MUSHROOM_BASE_UPGRADE_PRICE, "1.6e6");

		set(CACTUS_NAME, "Cactus");
		set(CACTUS_BASE_INCOME, "1.4e3");
		set(CACTUS_BASE_BUY_PRICE, "1.8e6");
		set(CACTUS_BASE_UPGRADE_PRICE, "7.8e6");

		set(SAPLING_NAME, "Sapling");
		set(SAPLING_BASE_INCOME, "7.8e3");
		set(SAPLING_BASE_BUY_PRICE, "1.2e7");
		set(SAPLING_BASE_UPGRADE_PRICE, "1.5e8");

		set(WATER_LILY_NAME, "Water lily");
		set(WATER_LILY_BASE_INCOME, "4.4e4");
		set(WATER_LILY_BASE_BUY_PRICE, "1.05e8");
		set(WATER_LILY_BASE_UPGRADE_PRICE, "2e9");

		set(MELON_NAME, "Melon");
		set(MELON_BASE_INCOME, "2.6e5");
		set(MELON_BASE_BUY_PRICE, "1.2e9");
		set(MELON_BASE_UPGRADE_PRICE, "3e10");

		set(PUMPKIN_NAME, "Pumpkin");
		set(PUMPKIN_BASE_INCOME, "1.6e6");
		set(PUMPKIN_BASE_BUY_PRICE, "8.5e9");
		set(PUMPKIN_BASE_UPGRADE_PRICE, "4e11");

		set(SWEET_BERRIES_NAME, "Sweet berries");
		set(SWEET_BERRIES_BASE_INCOME, "1e7");
		set(SWEET_BERRIES_BASE_BUY_PRICE, "6.2e10");
		set(SWEET_BERRIES_BASE_UPGRADE_PRICE, "6.5e12");

		set(CHORUS_NAME, "Chorus plant");
		set(CHORUS_BASE_INCOME, "6.5e7");
		set(CHORUS_BASE_BUY_PRICE, "4e11");
		set(CHORUS_BASE_UPGRADE_PRICE, "1.2e13");

		set(SUGAR_CANE_NAME, "Sugar cane");
		set(SUGAR_CANE_BASE_INCOME, "4.3e8");
		set(SUGAR_CANE_BASE_BUY_PRICE, "2.8e12");
		set(SUGAR_CANE_BASE_UPGRADE_PRICE, "8.4e13");

		set(COCOA_NAME, "Cocoa");
		set(COCOA_BASE_INCOME, "2.9e9");
		set(COCOA_BASE_BUY_PRICE, "1.4e13");
		set(COCOA_BASE_UPGRADE_PRICE, "5e15");

		set(NETHER_WART_NAME, "Nether wart");
		set(NETHER_WART_BASE_INCOME, "2e10");
		set(NETHER_WART_BASE_BUY_PRICE, "1.26e14");
		set(NETHER_WART_BASE_UPGRADE_PRICE, "6e16");

		set(DEAD_BUSH_NAME, "Dead bush");
		set(DEAD_BUSH_BASE_INCOME, "1e11");
		set(DEAD_BUSH_BASE_BUY_PRICE, "6.15e15");
		set(DEAD_BUSH_BASE_UPGRADE_PRICE, "1e18");
	}
}
