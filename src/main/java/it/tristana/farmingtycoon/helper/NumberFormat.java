package it.tristana.farmingtycoon.helper;

import org.bukkit.plugin.java.JavaPlugin;

import it.tristana.farmingtycoon.Main;
import it.tristana.farmingtycoon.config.SettingsMessages;

public class NumberFormat {

	private static final SettingsMessages settings = JavaPlugin.getPlugin(Main.class).getSettingsMessages();

	private static final int MAX_DIGITS = 3;
	private static final int BASE = 10;
	private static final double POWER_DIGITS = Math.pow(BASE, MAX_DIGITS);
	private static final double LOG = Math.log(POWER_DIGITS);
	private static final double BASE_LOG = Math.log(BASE);

	private NumberFormat() {}

	public static String format(double num) {
		if (num < POWER_DIGITS && num > -POWER_DIGITS) {
			return Integer.toString((int) num);
		}

		boolean isNegative = false;
		if (num < 0) {
			num *= -1;
			isNegative = true;
		}

		double log = Math.log(num);
		int index = (int) (log / LOG);
		int digits = (int) (log / BASE_LOG) + 1;
		int afterComma = (MAX_DIGITS - digits % MAX_DIGITS) % MAX_DIGITS;
		int piece = (int) (num / Math.pow(BASE, digits - MAX_DIGITS));
		String[] words = settings.getUnits();
		return (isNegative ? "-" : "") + String.format("%." + afterComma + "f", piece / Math.pow(BASE, afterComma)) + " " + (index < words.length ? words[index] : "e" + index * MAX_DIGITS);
	}
}
