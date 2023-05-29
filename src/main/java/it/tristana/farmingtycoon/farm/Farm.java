package it.tristana.farmingtycoon.farm;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import it.tristana.commons.interfaces.Tickable;
import it.tristana.farmingtycoon.Main;
import it.tristana.farmingtycoon.config.SettingsFarm;
import it.tristana.farmingtycoon.database.FarmingUser;

public class Farm implements Tickable {

	private static final Main plugin = JavaPlugin.getPlugin(Main.class);
	private static final SettingsFarm settings = plugin.getSettingsFarm();
	
	private FarmingUser owner;
	private FarmType farmType;
	private int amount;
	private int level;
	private double totalIncome;

	private double cachedIncomePerSecond;
	private double cachedNextBuyPrice;
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
		recalcNextBuyPrice();
		recalcNextUpgradePrice();
		recalcMoneyPerSecond();
		Bukkit.getScheduler().runTask(plugin, this::updateSign);
	}

	@Override
	public void runTick() {
		owner.giveMoney(cachedIncomePerSecond);
		totalIncome += cachedIncomePerSecond;
	}

	public FarmingUser getOwner() {
		return owner;
	}

	public FarmType getFarmType() {
		return farmType;
	}

	public void buy() {
		farmType.build(owner.getIsland(), amount);
		amount ++;
		recalcNextBuyPrice();
		recalcMoneyPerSecond();
		updateSign();
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
	
	public double getNextBuyPrice() {
		return cachedNextBuyPrice;
	}

	public double getNextUpgradePrice() {
		return cachedNextUpgradePrice;
	}

	public double getIncomePerSecond() {
		return cachedIncomePerSecond;
	}
	
	private void updateSign() {
		farmType.update(owner.getIsland(), level, cachedIncomePerSecond, cachedNextBuyPrice, owner.getMoney());
	}

	private void recalcNextBuyPrice() {
		cachedNextBuyPrice = farmType.getBaseBuyPrice() * Math.pow(settings.getBuyPriceMultiplier(), amount);
	}

	private void recalcNextUpgradePrice() {
		cachedNextUpgradePrice = farmType.getBaseUpgradePrice() * Math.pow(settings.getUpgradePriceMultiplier(), amount);
	}

	private void recalcMoneyPerSecond() {
		cachedIncomePerSecond = farmType.getBaseIncome() * amount * Math.pow(settings.getIncomeLevelMultiplier(), level);
	}
}
