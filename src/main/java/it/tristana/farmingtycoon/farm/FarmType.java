package it.tristana.farmingtycoon.farm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import it.tristana.farmingtycoon.Main;
import it.tristana.farmingtycoon.config.SettingsFarm;

public enum FarmType {

	WHEAT(new FarmBuilder(Material.FARMLAND, Material.WHEAT), SettingsFarm::getWheatBaseIncome, SettingsFarm::getWheatBaseUpgradePrice),
	POTATO(new FarmBuilder(Material.FARMLAND, Material.POTATOES), SettingsFarm::getPotatoBaseIncome, SettingsFarm::getPotatoBaseUpgradePrice),
	CARROT(new FarmBuilder(Material.FARMLAND, Material.CARROTS), SettingsFarm::getCarrotBaseIncome, SettingsFarm::getCarrotBaseUpgradePrice),
	BEETROOT(new FarmBuilder(Material.FARMLAND, Material.BEETROOTS), SettingsFarm::getBeetrootBaseIncome, SettingsFarm::getBeetrootBaseUpgradePrice),
	SUGAR_CANE(new SugarCaneBuilder(), SettingsFarm::getSugarCaneBaseIncome, SettingsFarm::getSugarCaneBaseUpgradePrice),
	MUSHROOM(new MushroomBuilder(), SettingsFarm::getMushroomBaseIncome, SettingsFarm::getMushroomBaseUpgradePrice),
	CACTUS(new CactusBuilder(), SettingsFarm::getCactusBaseIncome, SettingsFarm::getCactusBaseUpgradePrice),
	SAPLING(new FarmBuilder(Material.GRASS_BLOCK, Material.OAK_SAPLING), SettingsFarm::getSaplingBaseIncome, SettingsFarm::getSaplingBaseUpgradePrice),
	WATER_LILY(new FarmBuilder(Material.WATER, Material.LILY_PAD), SettingsFarm::getWaterLilyBaseIncome, SettingsFarm::getWaterLilyBaseUpgradePrice),
	MELON(new MelonBuilder(), SettingsFarm::getMelonBaseIncome, SettingsFarm::getMelonBaseUpgradePrice),
	PUMPKIN(new PumpkinBuilder(), SettingsFarm::getPumpkinBaseIncome, SettingsFarm::getPumpkinBaseUpgradePrice),
	SWEET_BERRIES(new FarmBuilder(Material.PODZOL, Material.SWEET_BERRY_BUSH), SettingsFarm::getSweetBerriesBaseIncome, SettingsFarm::getSweetBerriesBaseUpgradePrice),
	CHORUS(new FarmBuilder(Material.END_STONE, Material.CHORUS_FLOWER), SettingsFarm::getChorusBaseIncome, SettingsFarm::getChorusBaseUpgradePrice),
	COCOA(new CocoaBuilder(), SettingsFarm::getCocoaBaseIncome, SettingsFarm::getCocoaBaseUpgradePrice),
	NETHER_WART(new FarmBuilder(Material.SOUL_SAND, Material.NETHER_WART), SettingsFarm::getNetherWartBaseIncome, SettingsFarm::getNetherWartBaseUpgradePrice),
	DEAD_BUSH(new FarmBuilder(Material.SAND, Material.DEAD_BUSH), SettingsFarm::getDeadBushBaseIncome, SettingsFarm::getDeadBushBaseUpgradePrice);

	private static final FarmType[] types = values();
	private static final List<FarmType> typesAsList;
	private static final SettingsFarm settings;
	static {
		for (FarmType type : types) {
			type.builder.setIndex(type.ordinal());
		}
		typesAsList = Collections.unmodifiableList(Arrays.asList(types));
		settings = JavaPlugin.getPlugin(Main.class).getSettingsFarm();
	}

	private FarmBuilder builder;
	private SettingsRetriever baseIncomeSupplier;
	private SettingsRetriever baseUpgradePriceSupplier;

	FarmType(FarmBuilder builder, SettingsRetriever baseIncomeSupplier, SettingsRetriever baseUpgradePriceSupplier) {
		this.builder = builder;
		this.baseIncomeSupplier = baseIncomeSupplier;
		this.baseUpgradePriceSupplier = baseUpgradePriceSupplier;
	}
	
	public static List<FarmType> asList() {
		return typesAsList;
	}
	
	public static FarmType get(int ordinal) {
		return ordinal >= 0 && ordinal < types.length ? types[ordinal] : null;
	}
	
	public static int length() {
		return types.length;
	}

	public void build(World world, Location island, int row) {
		builder.build(world, island, row);
	}
	
	public void update(World world, Location island) {
		builder.updateSign(world, island);
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
