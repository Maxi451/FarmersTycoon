package it.tristana.farmingtycoon.farm;

import org.bukkit.Location;

import it.tristana.farmingtycoon.config.SettingsIslands;

public class IslandsBroker {

	private SettingsIslands settings;
	private IslandPos previous;

	public IslandsBroker(SettingsIslands settings, IslandPos previous) {
		this.settings = settings;
		this.previous = previous;
	}

	public Location nextIsland() {
		updatePos();
		return fromIslandPos(previous);
	}

	public Location fromIslandPos(IslandPos pos) {
		int distance = settings.getIslandsDistance();
		return new Location(settings.getWorld(), pos.x() * distance, settings.getIslandsHeight(), pos.z() * distance);
	}
	
	public IslandPos fromLocation(Location location) {
		if (location.getWorld() != settings.getWorld()) {
			return null;
		}

		
	}

	private void updatePos() {
		previous = previous.copy();
		int x = previous.x();
		int z = previous.z();
		if (x < z) {
			if (x * -1 < z) {
				previous = new IslandPos(x + 1, z);
				return;
			}

			previous = new IslandPos(x, z + 1);
			return;
		}

		if (x > z) {
			if (x * -1 >= z) {
				previous = new IslandPos(x - 1, z);
				return;
			}

			previous = new IslandPos(x, z - 1);
			return;
		}

		if (x <= 0) {
			previous = new IslandPos(x, z + 1);
			return;
		}

		previous = new IslandPos(x, z - 1);
		return;
	}
}
