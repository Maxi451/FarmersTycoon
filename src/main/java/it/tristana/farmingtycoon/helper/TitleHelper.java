package it.tristana.farmingtycoon.helper;

import org.bukkit.entity.Player;

public class TitleHelper {

	private TitleHelper() {}
	
	public static void send(Player player, String text, String subtitle) {
		player.sendTitle(text, subtitle, 20, 70, 10);
	}
}
