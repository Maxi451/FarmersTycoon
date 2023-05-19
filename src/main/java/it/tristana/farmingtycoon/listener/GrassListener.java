package it.tristana.farmingtycoon.listener;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import it.tristana.commons.helper.CommonsHelper;
import it.tristana.farmingtycoon.farm.Island;
import it.tristana.farmingtycoon.farm.IslandsManager;

public class GrassListener implements Listener {

	private IslandsManager islandsManager;
	
	public GrassListener(IslandsManager islandsManager) {
		this.islandsManager = islandsManager;
	}
	
	@EventHandler
	public void on(BlockBreakEvent event) {
		Block block = event.getBlock();
		Location pos = block.getLocation();
		if (pos.getWorld() != islandsManager.getIslandsWorld()) {
			return;
		}

		Island island = islandsManager.getIsland(pos);
		if (island == null) {
			event.setCancelled(true);
			return;
		}
		
		Player player = event.getPlayer();
		CommonsHelper.broadcast(String.format("&b%s&r broke %s in %s's island", player.getName(), block.getType().name(), island.user().getPlayer().getName()));
	}
}
