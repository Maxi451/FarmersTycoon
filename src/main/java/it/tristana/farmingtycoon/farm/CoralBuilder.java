package it.tristana.farmingtycoon.farm;

import org.bukkit.Material;

final class CoralBuilder extends FarmBuilder {

	@Override
	protected Material getCropAt(int row, int column) {
		return (row ^ column) % 2 == 0 ? Material.SUGAR_CANE : Material.AIR;
	}
	
	@Override
	protected Material getTerrainAt(int row, int column) {
		return (row ^ column) % 2 == 0 ? Material.SAND : Material.WATER;
	}
}
