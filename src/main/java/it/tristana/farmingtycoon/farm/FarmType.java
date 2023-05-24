package it.tristana.farmingtycoon.farm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import it.tristana.commons.helper.CommonsHelper;
import it.tristana.farmingtycoon.Main;
import it.tristana.farmingtycoon.config.SettingsFarm;

public enum FarmType {

	WHEAT(new FarmBuilder(Material.FARMLAND, Material.WHEAT), SettingsFarm::getWheatName, SettingsFarm::getWheatBaseIncome, SettingsFarm::getWheatBaseBuyPrice, SettingsFarm::getWheatBaseUpgradePrice),
	POTATO(new FarmBuilder(Material.FARMLAND, Material.POTATOES), SettingsFarm::getPotatoName, SettingsFarm::getPotatoBaseIncome, SettingsFarm::getPotatoBaseBuyPrice, SettingsFarm::getPotatoBaseUpgradePrice),
	CARROT(new FarmBuilder(Material.FARMLAND, Material.CARROTS), SettingsFarm::getCarrotName, SettingsFarm::getCarrotBaseIncome, SettingsFarm::getCarrotBaseBuyPrice, SettingsFarm::getCarrotBaseUpgradePrice),
	BEETROOT(new FarmBuilder(Material.FARMLAND, Material.BEETROOTS), SettingsFarm::getBeetrootName, SettingsFarm::getBeetrootBaseIncome, SettingsFarm::getBeetrootBaseBuyPrice, SettingsFarm::getBeetrootBaseUpgradePrice),
	SUGAR_CANE(new SugarCaneBuilder(), SettingsFarm::getSugarCaneName, SettingsFarm::getSugarCaneBaseIncome, SettingsFarm::getSugarCaneBaseBuyPrice, SettingsFarm::getSugarCaneBaseUpgradePrice),
	MUSHROOM(new MushroomBuilder(), SettingsFarm::getMushroomName, SettingsFarm::getMushroomBaseIncome, SettingsFarm::getMushroomBaseBuyPrice, SettingsFarm::getMushroomBaseUpgradePrice),
	CACTUS(new CactusBuilder(), SettingsFarm::getCactusName, SettingsFarm::getCactusBaseIncome, SettingsFarm::getCactusBaseBuyPrice, SettingsFarm::getCactusBaseUpgradePrice),
	SAPLING(new FarmBuilder(Material.GRASS_BLOCK, Material.OAK_SAPLING), SettingsFarm::getSaplingName, SettingsFarm::getSaplingBaseIncome, SettingsFarm::getSaplingBaseBuyPrice, SettingsFarm::getSaplingBaseUpgradePrice),
	WATER_LILY(new FarmBuilder(Material.WATER, Material.LILY_PAD), SettingsFarm::getWaterLilyName, SettingsFarm::getWaterLilyBaseIncome, SettingsFarm::getWaterLilyBaseBuyPrice, SettingsFarm::getWaterLilyBaseUpgradePrice),
	MELON(new MelonBuilder(), SettingsFarm::getMelonName, SettingsFarm::getMelonBaseIncome, SettingsFarm::getMelonBaseBuyPrice, SettingsFarm::getMelonBaseUpgradePrice),
	PUMPKIN(new PumpkinBuilder(), SettingsFarm::getPumpkinName, SettingsFarm::getPumpkinBaseIncome, SettingsFarm::getPumpkinBaseBuyPrice, SettingsFarm::getPumpkinBaseUpgradePrice),
	SWEET_BERRIES(new FarmBuilder(Material.PODZOL, Material.SWEET_BERRY_BUSH), SettingsFarm::getSweetBerriesName, SettingsFarm::getSweetBerriesBaseIncome, SettingsFarm::getSweetBerriesBaseBuyPrice, SettingsFarm::getSweetBerriesBaseUpgradePrice),
	CHORUS(new FarmBuilder(Material.END_STONE, Material.CHORUS_FLOWER), SettingsFarm::getChorusName, SettingsFarm::getChorusBaseIncome, SettingsFarm::getChorusBaseBuyPrice, SettingsFarm::getChorusBaseUpgradePrice),
	COCOA(new CocoaBuilder(), SettingsFarm::getCocoaName, SettingsFarm::getCocoaBaseIncome, SettingsFarm::getCocoaBaseBuyPrice, SettingsFarm::getCocoaBaseUpgradePrice),
	NETHER_WART(new FarmBuilder(Material.SOUL_SAND, Material.NETHER_WART), SettingsFarm::getNetherWartName, SettingsFarm::getNetherWartBaseIncome, SettingsFarm::getNetherWartBaseBuyPrice, SettingsFarm::getNetherWartBaseUpgradePrice),
	DEAD_BUSH(new FarmBuilder(Material.SAND, Material.DEAD_BUSH), SettingsFarm::getDeadBushName, SettingsFarm::getDeadBushBaseIncome, SettingsFarm::getDeadBushBaseBuyPrice, SettingsFarm::getDeadBushBaseUpgradePrice);

	private static final FarmType[] types = values();
	private static final List<FarmType> typesAsList;
	private static final SettingsFarm settings;
	static {
		for (FarmType type : types) {
			type.builder.setType(type);
		}
		typesAsList = Collections.unmodifiableList(Arrays.asList(types));
		settings = JavaPlugin.getPlugin(Main.class).getSettingsFarm();
	}

	private final FarmBuilder builder;
	private final SettingsObjectRetriever<String> nameSupplier;
	private final SettingsDoubleRetriever baseIncomeSupplier;
	private final SettingsDoubleRetriever baseBuyPriceSupplier;
	private final SettingsDoubleRetriever baseUpgradePriceSupplier;

	FarmType(FarmBuilder builder, SettingsObjectRetriever<String> nameSupplier, SettingsDoubleRetriever baseIncomeSupplier, SettingsDoubleRetriever baseBuyPriceSupplier, SettingsDoubleRetriever baseUpgradePriceSupplier) {
		this.builder = builder;
		this.nameSupplier = nameSupplier;
		this.baseIncomeSupplier = baseIncomeSupplier;
		this.baseBuyPriceSupplier = baseBuyPriceSupplier;
		this.baseUpgradePriceSupplier = baseUpgradePriceSupplier;
	}

	public static List<FarmType> asList() {
		return typesAsList;
	}

	public static FarmType get(int ordinal) {
		return ordinal >= 0 && ordinal < types.length ? types[ordinal] : null;
	}

	public static FarmType fromSign(Island island, Location location) {
		for (FarmType type : types) {
			if (CommonsHelper.samePosInt(type.builder.getSignLocation(island), location)) {
				return type;
			}
		}

		return null;
	}

	public static int length() {
		return types.length;
	}

	public void build(Island island, int row) {
		builder.build(island, row);
	}
	
	public void update(Island island) {
		builder.updateSign(island);
	}

	public void update(Island island, int level, double incomePerSecond, double nextUpgradePrice, double money) {
		builder.updateSign(island, level, incomePerSecond, nextUpgradePrice, money);
	}

	public String getName() {
		return nameSupplier.get(settings);
	}

	public double getBaseIncome() {
		return baseIncomeSupplier.get(settings);
	}
	
	public double getBaseBuyPrice() {
		return baseBuyPriceSupplier.get(settings);
	}

	public double getBaseUpgradePrice() {
		return baseUpgradePriceSupplier.get(settings);
	}

	@FunctionalInterface
	private interface SettingsDoubleRetriever {
		double get(SettingsFarm settings);
	}

	@FunctionalInterface
	private interface SettingsObjectRetriever<T> {
		T get(SettingsFarm settings);
	}
}
