package it.tristana.farmingtycoon.listener;

import org.bukkit.block.data.type.Farmland;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.block.MoistureChangeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.world.StructureGrowEvent;

public class RemovedEventsListener implements Listener {

	@EventHandler
	public void on(BlockIgniteEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void on(BlockFadeEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void on(BlockBurnEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void on(BlockFormEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void on(FoodLevelChangeEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void on(WeatherChangeEvent event) {
		if (!event.getWorld().hasStorm()) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void on(BlockSpreadEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void on(ItemSpawnEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void on(PlayerDropItemEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void on(BlockGrowEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void on(StructureGrowEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void on(MoistureChangeEvent event) {
		if (!(event.getNewState() instanceof Farmland farmland)) {
			return;
		}

		int maxMoisture = farmland.getMaximumMoisture();
		if (farmland.getMoisture() < maxMoisture) {
			event.setCancelled(true);
		}
	}
}
