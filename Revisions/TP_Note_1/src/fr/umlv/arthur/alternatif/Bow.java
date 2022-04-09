package fr.umlv.arthur.alternatif;

import java.util.Objects;

public record Bow(String name, int damage, int protection) implements Equipment {
	
	public Bow {
		Objects.requireNonNull(name, "Name can't be null");
		if (damage <= 0 || protection <= 0) {
			throw new IllegalArgumentException("Damage or Protection can't be lesser than 0");
		}
	}
	
	@Override
	public String toString() {
		return  name;
	}
}
