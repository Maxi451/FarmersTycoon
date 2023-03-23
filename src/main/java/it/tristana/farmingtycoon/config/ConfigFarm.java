package it.tristana.farmingtycoon.config;

import java.io.File;

import it.tristana.commons.config.Config;

public class ConfigFarm extends Config {

	private static final String BASE_INCOME = "base-income";
	private static final String BASE_BUY_PRICE = "base-buy-price";
	private static final String BASE_UPGRADE_PRICE = "base-upgrade-price";

	private static final String WHEAT = "wheat.";
	public static final String WHEAT_BASE_INCOME = WHEAT + BASE_INCOME;
	public static final String WHEAT_BASE_BUY_PRICE = WHEAT + BASE_BUY_PRICE;
	public static final String WHEAT_BASE_UPGRADE_PRICE = WHEAT + BASE_UPGRADE_PRICE;

	private static final String POTATO = "potato.";
	public static final String POTATO_BASE_INCOME = POTATO + BASE_INCOME;
	public static final String POTATO_BASE_BUY_PRICE = POTATO + BASE_BUY_PRICE;
	public static final String POTATO_BASE_UPGRADE_PRICE = POTATO + BASE_UPGRADE_PRICE;

	private static final String CARROT = "carrot.";
	public static final String CARROT_BASE_INCOME = CARROT + BASE_INCOME;
	public static final String CARROT_BASE_BUY_PRICE = CARROT + BASE_BUY_PRICE;
	public static final String CARROT_BASE_UPGRADE_PRICE = CARROT + BASE_UPGRADE_PRICE;

	private static final String SUGAR_CANE = "sugar-cane.";
	public static final String SUGAR_CANE_BASE_INCOME = SUGAR_CANE + BASE_INCOME;
	public static final String SUGAR_CANE_BASE_BUY_PRICE = SUGAR_CANE + BASE_BUY_PRICE;
	public static final String SUGAR_CANE_BASE_UPGRADE_PRICE = SUGAR_CANE + BASE_UPGRADE_PRICE;

	private static final String MUSHROOM = "mushroom.";
	public static final String MUSHROOM_BASE_INCOME = MUSHROOM + BASE_INCOME;
	public static final String MUSHROOM_BASE_BUY_PRICE = MUSHROOM + BASE_BUY_PRICE;
	public static final String MUSHROOM_BASE_UPGRADE_PRICE = MUSHROOM + BASE_UPGRADE_PRICE;

	private static final String CACTUS = "cactus.";
	public static final String CACTUS_BASE_INCOME = CACTUS + BASE_INCOME;
	public static final String CACTUS_BASE_BUY_PRICE = CACTUS + BASE_BUY_PRICE;
	public static final String CACTUS_BASE_UPGRADE_PRICE = CACTUS + BASE_UPGRADE_PRICE;

	private static final String SAPLING = "sapling.";
	public static final String SAPLING_BASE_INCOME = SAPLING + BASE_INCOME;
	public static final String SAPLING_BASE_BUY_PRICE = SAPLING + BASE_BUY_PRICE;
	public static final String SAPLING_BASE_UPGRADE_PRICE = SAPLING + BASE_UPGRADE_PRICE;

	private static final String WATER_LILY = "water-lily.";
	public static final String WATER_LILY_BASE_INCOME = WATER_LILY + BASE_INCOME;
	public static final String WATER_LILY_BASE_BUY_PRICE = WATER_LILY + BASE_BUY_PRICE;
	public static final String WATER_LILY_BASE_UPGRADE_PRICE = WATER_LILY + BASE_UPGRADE_PRICE;

	private static final String MELON = "melon.";
	public static final String MELON_BASE_INCOME = MELON + BASE_INCOME;
	public static final String MELON_BASE_BUY_PRICE = MELON + BASE_BUY_PRICE;
	public static final String MELON_BASE_UPGRADE_PRICE = MELON + BASE_UPGRADE_PRICE;

	private static final String PUMPKIN = "pumpkin.";
	public static final String PUMPKIN_BASE_INCOME = PUMPKIN + BASE_INCOME;
	public static final String PUMPKIN_BASE_BUY_PRICE = PUMPKIN + BASE_BUY_PRICE;
	public static final String PUMPKIN_BASE_UPGRADE_PRICE = PUMPKIN + BASE_UPGRADE_PRICE;

	private static final String SWEET_BERRIES = "sweet-berries.";
	public static final String SWEET_BERRIES_BASE_INCOME = SWEET_BERRIES + BASE_INCOME;
	public static final String SWEET_BERRIES_BASE_BUY_PRICE = SWEET_BERRIES + BASE_BUY_PRICE;
	public static final String SWEET_BERRIES_BASE_UPGRADE_PRICE = SWEET_BERRIES + BASE_UPGRADE_PRICE;

	private static final String CHORUS = "chorus.";
	public static final String CHORUS_BASE_INCOME = CHORUS + BASE_INCOME;
	public static final String CHORUS_BASE_BUY_PRICE = CHORUS + BASE_BUY_PRICE;
	public static final String CHORUS_BASE_UPGRADE_PRICE = CHORUS + BASE_UPGRADE_PRICE;

	private static final String CORAL = "coral.";
	public static final String CORAL_BASE_INCOME = CORAL + BASE_INCOME;
	public static final String CORAL_BASE_BUY_PRICE = CORAL + BASE_BUY_PRICE;
	public static final String CORAL_BASE_UPGRADE_PRICE = CORAL + BASE_UPGRADE_PRICE;

	private static final String COCOA = "cocoa.";
	public static final String COCOA_BASE_INCOME = COCOA + BASE_INCOME;
	public static final String COCOA_BASE_BUY_PRICE = COCOA + BASE_BUY_PRICE;
	public static final String COCOA_BASE_UPGRADE_PRICE = COCOA + BASE_UPGRADE_PRICE;

	private static final String NETHER_WART = "nether-wart.";
	public static final String NETHER_WART_BASE_INCOME = NETHER_WART + BASE_INCOME;
	public static final String NETHER_WART_BASE_BUY_PRICE = NETHER_WART + BASE_BUY_PRICE;
	public static final String NETHER_WART_BASE_UPGRADE_PRICE = NETHER_WART + BASE_UPGRADE_PRICE;

	private static final String DEAD_BUSH = "dead-bush.";
	public static final String DEAD_BUSH_BASE_INCOME = DEAD_BUSH + BASE_INCOME;
	public static final String DEAD_BUSH_BASE_BUY_PRICE = DEAD_BUSH + BASE_BUY_PRICE;
	public static final String DEAD_BUSH_BASE_UPGRADE_PRICE = DEAD_BUSH + BASE_UPGRADE_PRICE;

	public ConfigFarm(File folder) {
		super(folder);
	}
	0.1,
	2,
	16,
	47,
	260,
	1.4e3,
	7.8e3,
	4.4e4,
	2.6e5,
	1.6e6,
	1e7,
	6.5e7,
	4.3e8,
	2.9e9,
	2e10,
	1e11
	@Override
	protected void createDefault() {
		set(WHEAT_BASE_INCOME, "0.1");
		set(WHEAT_BASE_BUY_PRICE, "25");
		set(WHEAT_BASE_UPGRADE_PRICE, "");

		set(POTATO_BASE_INCOME, "2");
		set(POTATO_BASE_BUY_PRICE, "1e3");
		set(POTATO_BASE_UPGRADE_PRICE, "");

		set(CARROT_BASE_INCOME, "16");
		set(CARROT_BASE_BUY_PRICE, "1.25e4");
		set(CARROT_BASE_UPGRADE_PRICE, "");

		set(SUGAR_CANE_BASE_INCOME, "47");
		set(SUGAR_CANE_BASE_BUY_PRICE, "4.4e4");
		set(SUGAR_CANE_BASE_UPGRADE_PRICE, "");

		set(MUSHROOM_BASE_INCOME, "260");
		set(MUSHROOM_BASE_BUY_PRICE, "2.75e5");
		set(MUSHROOM_BASE_UPGRADE_PRICE, "");

		set(CACTUS_BASE_INCOME, "1.4e3");
		set(CACTUS_BASE_BUY_PRICE, "1.8e6");
		set(CACTUS_BASE_UPGRADE_PRICE, "");

		set(SAPLING_BASE_INCOME, "7.8e3");
		set(SAPLING_BASE_BUY_PRICE, "1.2e7");
		set(SAPLING_BASE_UPGRADE_PRICE, "");

		set(WATER_LILY_BASE_INCOME, "4.4e4");
		set(WATER_LILY_BASE_BUY_PRICE, "1.05e8");
		set(WATER_LILY_BASE_UPGRADE_PRICE, "");

		set(MELON_BASE_INCOME, "0.2");
		set(MELON_BASE_BUY_PRICE, "1.2e9");
		set(MELON_BASE_UPGRADE_PRICE, "");

		set(PUMPKIN_BASE_INCOME, "0.2");
		set(PUMPKIN_BASE_BUY_PRICE, "8.5e9");
		set(PUMPKIN_BASE_UPGRADE_PRICE, "");

		set(SWEET_BERRIES_BASE_INCOME, "0.2");
		set(SWEET_BERRIES_BASE_BUY_PRICE, "6.2e10");
		set(SWEET_BERRIES_BASE_UPGRADE_PRICE, "");

		set(CHORUS_BASE_INCOME, "0.2");
		set(CHORUS_BASE_BUY_PRICE, "4e11");
		set(CHORUS_BASE_UPGRADE_PRICE, "");

		set(CORAL_BASE_INCOME, "0.2");
		set(CORAL_BASE_BUY_PRICE, "2.8e12");
		set(CORAL_BASE_UPGRADE_PRICE, "");

		set(COCOA_BASE_INCOME, "0.2");
		set(COCOA_BASE_BUY_PRICE, "1.4e13");
		set(COCOA_BASE_UPGRADE_PRICE, "");

		set(NETHER_WART_BASE_INCOME, "0.2");
		set(NETHER_WART_BASE_BUY_PRICE, "1.26e14");
		set(NETHER_WART_BASE_UPGRADE_PRICE, "");

		set(DEAD_BUSH_BASE_INCOME, "0.2");
		set(DEAD_BUSH_BASE_BUY_PRICE, "6.15e15");
		set(DEAD_BUSH_BASE_UPGRADE_PRICE, "");
	}
}
