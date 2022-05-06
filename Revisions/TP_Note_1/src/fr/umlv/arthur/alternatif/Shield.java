package fr.umlv.arthur.alternatif;

import java.util.Objects;

public record Shield(String name, int protection) implements Equipment {
	
	public Shield {
		Objects.requireNonNull(name, "Name can't be null");
		if (protection <= 0) {
			throw new IllegalArgumentException("Protection can't be lesser than 0");
		}
	}
	
	@Override
	public int damage() {
		return 0;
	}
	
	@Override
	public String toString() {
		return  name;
	}
}
