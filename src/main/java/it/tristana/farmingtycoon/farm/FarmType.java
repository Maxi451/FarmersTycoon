package it.tristana.farmingtycoon.farm;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import it.tristana.farmingtycoon.Main;
import it.tristana.farmingtycoon.config.SettingsFarm;

public enum FarmType {

	WHEAT(new FarmBuilder(Material.FARMLAND, Material.WHEAT), SettingsFarm::getWheatBaseIncome, SettingsFarm::getWheatBaseUpgradePrice),
	POTATO(new FarmBuilder(Material.FARMLAND, Material.POTATOES), SettingsFarm::getPotatoBaseIncome, SettingsFarm::getPotatoBaseUpgradePrice),
	CARROT(new FarmBuilder(Material.FARMLAND, Material.CARROTS), SettingsFarm::getCarrotBaseIncome, SettingsFarm::getCarrotBaseUpgradePrice),
	SUGAR_CANE(new SugarCaneBuilder(), SettingsFarm::getSugarCaneBaseIncome, SettingsFarm::getSugarCaneBaseUpgradePrice),
	MUSHROOM(new MushroomBuilder(), SettingsFarm::getMushroomBaseIncome, SettingsFarm::getMushroomBaseUpgradePrice),
	CACTUS(new CactusBuilder(), SettingsFarm::getCactusBaseIncome, SettingsFarm::getCactusBaseUpgradePrice),
	SAPLING(new FarmBuilder(Material.GRASS_BLOCK, Material.OAK_SAPLING), SettingsFarm::getSaplingBaseIncome, SettingsFarm::getSaplingBaseUpgradePrice),
	WATER_LILY(new FarmBuilder(Material.WATER, Material.LILY_PAD), SettingsFarm::getWaterLilyBaseIncome, SettingsFarm::getWaterLilyBaseUpgradePrice),
	MELON(new MelonBuilder(), SettingsFarm::getMelonBaseIncome, SettingsFarm::getMelonBaseUpgradePrice),
	PUMPKIN(new PumpkinBuilder(), SettingsFarm::getPumpkinBaseIncome, SettingsFarm::getPumpkinBaseUpgradePrice),
	SWEET_BERRIES(new FarmBuilder(Material.PODZOL, Material.SWEET_BERRY_BUSH), SettingsFarm::getSweetBerriesBaseIncome, SettingsFarm::getSweetBerriesBaseUpgradePrice),
	CHORUS(new FarmBuilder(Material.END_STONE, Material.CHORUS_FLOWER), SettingsFarm::getChorusBaseIncome, SettingsFarm::getChorusBaseUpgradePrice),
	CORAL(new CoralBuilder(), SettingsFarm::getCoralBaseIncome, SettingsFarm::getCoralBaseUpgradePrice),
	COCOA(new CocoaBuilder(), SettingsFarm::getCocoaBaseIncome, SettingsFarm::getCocoaBaseUpgradePrice),
	NETHER_WART(new FarmBuilder(Material.SOUL_SAND, Material.NETHER_WART), SettingsFarm::getNetherWartBaseIncome, SettingsFarm::getNetherWartBaseUpgradePrice),
	DEAD_BUSH(new FarmBuilder(Material.SAND, Material.DEAD_BUSH), SettingsFarm::getDeadBushBaseIncome, SettingsFarm::getDeadBushBaseUpgradePrice);

	private static final FarmType[] types = values();
	private static SettingsFarm settings;
	static {
		settings = JavaPlugin.getPlugin(Main.class).getSettingsFarm();
		for (FarmType type : types) {
			type.builder.setIndex(type.ordinal());
		}
	}

	private FarmBuilder builder;
	private SettingsRetriever baseIncomeSupplier;
	private SettingsRetriever baseUpgradePriceSupplier;

	FarmType(FarmBuilder builder, SettingsRetriever baseIncomeSupplier, SettingsRetriever baseUpgradePriceSupplier) {
		this.builder = builder;
		this.baseIncomeSupplier = baseIncomeSupplier;
		this.baseUpgradePriceSupplier = baseUpgradePriceSupplier;
	}

	public void build(World world, Island island, int row) {
		builder.build(world, island, row);
	}

	public double getBaseIncome() {
		return baseIncomeSupplier.get(settings);
	}

	public double getBaseUpgradePrice() {
		return baseUpgradePriceSupplier.get(settings);
	}

	@FunctionalInterface
	private interface SettingsRetriever {
		double get(SettingsFarm settings);
	}
}
