package it.tristana.farmingtycoon.farm;

import java.util.function.Supplier;

import it.tristana.farmingtycoon.config.SettingsFarm;

public enum FarmType {

	WHEAT(new WheatBuilder(), SettingsFarm::getWheatBaseIncome);

	private FarmBuilder builder;
	private Supplier<Double> baseUpgradePriceSupplier;
	private Supplier<Double> baseIncomeSupplier;

	FarmType(FarmBuilder builder, Supplier<Double> baseUpgradePriceSupplier, Supplier<Double> baseIncomeSupplier) {
		this.builder = builder;
		this.baseUpgradePriceSupplier = baseUpgradePriceSupplier;
		this.baseIncomeSupplier = baseIncomeSupplier;
	}
	
	public double getBaseIncome() {
		
	}
}
