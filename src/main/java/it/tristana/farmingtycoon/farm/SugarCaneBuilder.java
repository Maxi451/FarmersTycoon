package it.tristana.farmingtycoon.farm;

import org.bukkit.Material;

final class SugarCaneBuilder extends FarmBuilder {

	@Override
	protected Material getCropAt(int row, int column, int height) {
		return (row ^ column) % 2 == 0 ? Material.SUGAR_CANE : Material.AIR;
	}
	
	@Override
	protected Material getTerrainAt(int row, int column) {
		return (row ^ column) % 2 == 0 ? Material.SAND : Material.WATER;
	}
	
	@Override
	protected int getCropHeight() {
		return 2;
	}
}
