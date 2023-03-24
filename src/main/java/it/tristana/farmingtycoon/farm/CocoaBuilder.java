package it.tristana.farmingtycoon.farm;

import org.bukkit.Material;

final class CocoaBuilder extends DirectionalFarmBuilder {

	CocoaBuilder() {
		super(Material.JUNGLE_WOOD);
	}

	@Override
	Material getCropAt(int row, int column, int height) {
		return column == 1 || column == 3 ? Material.COCOA : (column == 2 ? Material.JUNGLE_WOOD : Material.AIR);
	}
	
	@Override
	Material getTerrainAt(int row, int column) {
		return (row ^ column) % 2 == 0 ? Material.SAND : Material.WATER;
	}
}
