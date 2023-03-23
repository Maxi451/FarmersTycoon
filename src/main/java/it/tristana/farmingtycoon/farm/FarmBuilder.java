package it.tristana.farmingtycoon.farm;

public abstract class FarmBuilder {
	
	private static final int X_OFFSET = 10;
	private static final int Y_OFFSET = 3;
	private static final int Z_OFFSET = 9;
	
	private static final int WIDTH = 5;
	private static final int LENGTH = 150;

	private int idx; // x
	
	public final void build(Island island, int fieldCount, int width, int length) {
		build(island.posX() + 10 + WIDTH * idx, island.posY() + 3, island.posZ() + 9 + fieldCount); // TODO: wrong values
	}
	
	final void setIndex(int idx) {
		this.idx = idx;
	}

	protected abstract void build(int x, int y, int z, int width);
	
	protected abstract void placeTerrain(int x, int y, int z, int width, int length);
}
