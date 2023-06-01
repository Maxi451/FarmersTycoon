package it.tristana.farmingtycoon.listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import it.tristana.farmingtycoon.command.FarmCommand;
import it.tristana.farmingtycoon.farm.Island;
import it.tristana.farmingtycoon.farm.IslandsManager;

public class GrassListener implements Listener {

	private final IslandsManager islandsManager;

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

		if (block.getType() == Material.GRASS) {
			island.user().getGrassField().onGrassBroken();
			return;
		}
		
		if (!event.getPlayer().hasPermission(FarmCommand.ADMIN_PERMS)) {
			event.setCancelled(true);
		}
	}
}
