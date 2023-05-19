package it.tristana.farmingtycoon.farm;

public record IslandPos(int x, int z) {
	
	@Override
	public int hashCode() {
		return x << 8 + z;
	}
	
	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		
		if (!(other instanceof IslandPos otherPos)) {
			return false;
		}
		
		return x == otherPos.x && z == otherPos.z;
	}
}
