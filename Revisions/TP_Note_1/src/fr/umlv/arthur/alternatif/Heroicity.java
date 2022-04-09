package fr.umlv.arthur.alternatif;

public final class Heroicity {
	private final int bonus;
	
	public Heroicity(int bonusFactor) {
		if (bonusFactor <= 0) {
			throw new IllegalArgumentException("bonus can't be lesser than or equals 0");
		}
		this.bonus = bonusFactor;
	}
	
	public int upgrade(Knight knight) {
		return knight.damage() * bonus;
	}
}
