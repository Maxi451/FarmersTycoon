package it.tristana.farmingtycoon.farm;

import it.tristana.commons.interfaces.Tickable;
import it.tristana.farmingtycoon.database.FarmingUser;

public class Farm implements Tickable {

	private FarmingUser owner;
	private FarmType farmType;
	private int amount;
	private int level;
	private double totalIncome;

	private double cachedIncomePerSecond;
	private double cachedNextUpgradePrice;

	public Farm(FarmingUser owner, FarmType farmType) {
		this(owner, farmType, 0, 0, 0);
	}
	
	public Farm(FarmingUser owner, FarmType farmType, int amount, int level, double totalIncome) {
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
		if (amount == 0) {
			return;
		}

		owner.giveMoney(cachedIncomePerSecond);
		totalIncome += cachedIncomePerSecond;
		farmType.update(owner.getIsland());
	}

	public FarmingUser getOwner() {
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
