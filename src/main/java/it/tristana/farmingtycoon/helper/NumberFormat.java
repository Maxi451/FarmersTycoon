package it.tristana.farmingtycoon.helper;

public class NumberFormat {

	private static final double LOG_1000 = Math.log(1000);
	
	private static final String[] words = {
			"",
			"Thousand",
			"Million",
			"Billion",
			"Trillion",
			"Quadrillion",
			"Quintillion",
			"Sextillion",
			"Septillion",
			"Octillion",
			"Nonillion",
			"Decillion",
			"Undecillion",
			"Duodecillion",
			"Tredecillion",
			"Quattuordecillion",
			"Quindecillion",
			"Sexdecillion",
			"Septendecillion",
			"Octodecillion",
			"Novemdecillion",
			"Vigintillion"
	};

	private NumberFormat() {}

	public static String format(double num) {
		if (num < 1000 && num > -1000) {
			return Integer.toString((int) num);
		}

		boolean isNegative = false;
		if (num < 0) {
			num *= -1;
			isNegative = true;
		}

		int index = (int) (Math.log(num) / LOG_1000);
		int digits = (int) Math.log10(num) + 1;
		int afterComma = (3 - digits % 3) % 3;
		int piece = (int) (num / Math.pow(10, digits - 3));
		return (isNegative ? "-" : "") + String.format("%." + afterComma + "f", piece / Math.pow(10, afterComma)) + " " + (index < words.length ? words[index] : "e" + index * 3);
	}
}
