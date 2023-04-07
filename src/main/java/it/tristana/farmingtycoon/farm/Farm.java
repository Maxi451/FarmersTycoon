package it.tristana.farmingtycoon.farm;

import it.tristana.commons.interfaces.Tickable;
import it.tristana.commons.interfaces.shop.BalanceHolder;

public class Farm implements Tickable {

	private BalanceHolder owner;
	private FarmType farmType;
	private int amount;
	private int level;
	private double totalIncome;

	private double cachedIncomePerSecond;
	private double cachedNextUpgradePrice;

	public Farm(BalanceHolder owner, FarmType farmType) {
		this(owner, farmType, 0, 0, 0);
	}
	
	public Farm(BalanceHolder owner, FarmType farmType, int amount, int level, double totalIncome) {
		this.owner = owner;
		this.farmType = farmType;
		this.amount = amount;
		this.level = level;
		this.totalIncome = totalIncome;
		recalcNextUpgradePrice();
		recalcMoneyPerSecond();
	}

	@Override
	public void runTick() {
		owner.giveMoney(cachedIncomePerSecond);
		totalIncome += cachedIncomePerSecond;
	}

	public BalanceHolder getOwner() {
		return owner;
	}

	public FarmType getFarmType() {
		return farmType;
	}

	public void upgrade() {
		amount ++;
		recalcNextUpgradePrice();
		recalcMoneyPerSecond();
	}

	public int getAmount() {
		return amount;
	}

	public void addLevel() {
		level ++;
		recalcMoneyPerSecond();
	}

	public int getLevel() {
		return level;
	}

	public double getTotalIncome() {
		return totalIncome;
	}

	public double getNextUpgradePrice() {
		return cachedNextUpgradePrice;
	}

	public double getIncomePerSecond() {
		return cachedIncomePerSecond;
	}

	private void recalcNextUpgradePrice() {
		cachedNextUpgradePrice = farmType.getBaseUpgradePrice() * Math.pow(1.4, amount);
	}

	private void recalcMoneyPerSecond() {
		cachedIncomePerSecond = farmType.getBaseIncome() * amount * Math.pow(2, level);
	}
}
