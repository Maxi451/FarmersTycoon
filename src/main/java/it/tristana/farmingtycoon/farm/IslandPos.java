package it.tristana.farmingtycoon.farm;

public record IslandPos(int x, int z) {

	public IslandPos copy() {
		return new IslandPos(x, z);
	}
}
