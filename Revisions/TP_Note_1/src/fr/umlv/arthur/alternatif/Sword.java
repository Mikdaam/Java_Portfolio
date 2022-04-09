package fr.umlv.arthur.alternatif;

import java.util.Objects;

public record Sword(String name, int damage) implements Equipment {
	public Sword {
		Objects.requireNonNull(name, "Name can't be null");
		if (damage <= 0) {
			throw new IllegalArgumentException("Damage can't be lesser than 0");
		}
	}
	
	@Override
	public int protection() {
		return 0;
	}

	@Override
	public String toString() {
		return  name;
	}

	/**
	 * Je ne maitrise pas encore(point en moins :( )
	 */
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Sword sword
				&& damage == sword.damage
				&& name.equals(sword.name);
	}
	
}
