package it.tristana.farmingtycoon.farm;

import org.bukkit.Material;

final class MushroomBuilder extends FarmBuilder {

	@Override
	protected Material getCropAt(int row, int column, int height) {
		return row % 2 == 0 ? Material.WARPED_FUNGUS : Material.CRIMSON_FUNGUS;
	}
	
	@Override
	protected Material getTerrainAt(int row, int column) {
		return row % 2 == 0 ? Material.CRIMSON_NYLIUM : Material.WARPED_NYLIUM;
	}
}
