package it.tristana.farmingtycoon.farm;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Directional;

sealed abstract class DirectionalFarmBuilder extends FarmBuilder permits CocoaBuilder, MelonBuilder, PumpkinBuilder {

	private Material directionalType;
	
	DirectionalFarmBuilder(Material directionalType) {
		this.directionalType = directionalType;
	}
	
	@Override
	protected void updateDirection(Block block, Directional directional) {
		if (updateStem(block, BlockFace.WEST, directional)) {
			return;
		}
		updateStem(block, BlockFace.EAST, directional);
	}

	private boolean updateStem(Block block, BlockFace face, Directional directional) {
		boolean flag = block.getRelative(face).getType() == directionalType;
		if (flag) {
			directional.setFacing(face);
		}
		return flag;
	}
}
