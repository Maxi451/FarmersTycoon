package it.tristana.farmingtycoon.farm;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Directional;

final class CocoaBuilder extends DirectionalFarmBuilder {

	CocoaBuilder() {
		super(Material.JUNGLE_WOOD);
	}

	@Override
	protected void updateDirection(Block block, Directional directional) {
		directional.setFacing(BlockFace.UP);
	}

	@Override
	Material getCropAt(int row, int column, int height) {
		return column == 1 || column == 3 ? Material.COCOA : (column == 2 ? Material.JUNGLE_WOOD : Material.AIR);
	}

	@Override
	Material getTerrainAt(int row, int column) {
		return Material.GRASS;
	}
}
