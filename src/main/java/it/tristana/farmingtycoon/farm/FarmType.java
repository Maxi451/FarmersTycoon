package it.tristana.farmingtycoon.farm;

import org.bukkit.plugin.java.JavaPlugin;

import it.tristana.farmingtycoon.Main;
import it.tristana.farmingtycoon.config.SettingsFarm;
import it.tristana.farmingtycoon.farm.builder.CactusBuilder;
import it.tristana.farmingtycoon.farm.builder.CarrotBuilder;
import it.tristana.farmingtycoon.farm.builder.ChorusBuilder;
import it.tristana.farmingtycoon.farm.builder.CocoaBuilder;
import it.tristana.farmingtycoon.farm.builder.CoralBuilder;
import it.tristana.farmingtycoon.farm.builder.DeadBushBuilder;
import it.tristana.farmingtycoon.farm.builder.MelonBuilder;
import it.tristana.farmingtycoon.farm.builder.MushroomBuilder;
import it.tristana.farmingtycoon.farm.builder.NetherWartBuilder;
import it.tristana.farmingtycoon.farm.builder.PotatoBuilder;
import it.tristana.farmingtycoon.farm.builder.PumpkinBuilder;
import it.tristana.farmingtycoon.farm.builder.SaplingBuilder;
import it.tristana.farmingtycoon.farm.builder.SugarCaneBuilder;
import it.tristana.farmingtycoon.farm.builder.SweetBerriesBuilder;
import it.tristana.farmingtycoon.farm.builder.WaterLilyBuilder;
import it.tristana.farmingtycoon.farm.builder.WheatBuilder;

public enum FarmType {

	WHEAT(new WheatBuilder(), SettingsFarm::getWheatBaseIncome, SettingsFarm::getWheatBaseUpgradePrice),
	POTATO(new PotatoBuilder(), SettingsFarm::getPotatoBaseIncome, SettingsFarm::getPotatoBaseUpgradePrice),
	CARROT(new CarrotBuilder(), SettingsFarm::getCarrotBaseIncome, SettingsFarm::getCarrotBaseUpgradePrice),
	SUGAR_CANE(new SugarCaneBuilder(), SettingsFarm::getSugarCaneBaseIncome, SettingsFarm::getSugarCaneBaseUpgradePrice),
	MUSHROOM(new MushroomBuilder(), SettingsFarm::getMushroomBaseIncome, SettingsFarm::getMushroomBaseUpgradePrice),
	CACTUS(new CactusBuilder(), SettingsFarm::getCactusBaseIncome, SettingsFarm::getCactusBaseUpgradePrice),
	SAPLING(new SaplingBuilder(), SettingsFarm::getSaplingBaseIncome, SettingsFarm::getSaplingBaseUpgradePrice),
	WATER_LILY(new WaterLilyBuilder(), SettingsFarm::getWaterLilyBaseIncome, SettingsFarm::getWaterLilyBaseUpgradePrice),
	MELON(new MelonBuilder(), SettingsFarm::getMelonBaseIncome, SettingsFarm::getMelonBaseUpgradePrice),
	PUMPKIN(new PumpkinBuilder(), SettingsFarm::getPumpkinBaseIncome, SettingsFarm::getPumpkinBaseUpgradePrice),
	SWEET_BERRIES(new SweetBerriesBuilder(), SettingsFarm::getSweetBerriesBaseIncome, SettingsFarm::getSweetBerriesBaseUpgradePrice),
	CHORUS(new ChorusBuilder(), SettingsFarm::getChorusBaseIncome, SettingsFarm::getChorusBaseUpgradePrice),
	CORAL(new CoralBuilder(), SettingsFarm::getCoralBaseIncome, SettingsFarm::getCoralBaseUpgradePrice),
	COCOA(new CocoaBuilder(), SettingsFarm::getCocoaBaseIncome, SettingsFarm::getCocoaBaseUpgradePrice),
	NETHER_WART(new NetherWartBuilder(), SettingsFarm::getNetherWartBaseIncome, SettingsFarm::getNetherWartBaseUpgradePrice),
	DEAD_BUSH(new DeadBushBuilder(), SettingsFarm::getDeadBushBaseIncome, SettingsFarm::getDeadBushBaseUpgradePrice);

	private static final FarmType[] types = values();
	private static SettingsFarm settings;
	static {
		settings = JavaPlugin.getPlugin(Main.class).getSettingsFarm();
		for (FarmType type : types) {
			type.getBuilder().setIndex(type.ordinal());
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

	public FarmBuilder getBuilder() {
		return builder;
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
