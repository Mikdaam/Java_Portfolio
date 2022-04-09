package fr.umlv.arthur.alternatif;

import java.util.ArrayList;
import java.util.Objects;

public final class Knight {
	
	private final String name;
	private final ArrayList<Equipment> equipmentList = new ArrayList<Equipment>();
	private Heroicity heroicity;
	
	public Knight (String name, Equipment...equipments) {
		Objects.requireNonNull(name, "Name can't be null");
		for (Equipment equipment : equipments) {
			Objects.requireNonNull(equipment, "Equipemnt of the knight can't be null");
		}
		
		this.name = name;
		for (Equipment equipment : equipments) {
			this.equipmentList.add(equipment);
		}
	}
	
	public String name() {
		return name;
	}
	
	/*public ArrayList<Equipment> equipments() {
		return equipmentList;
	}*/
	
	public int damage() {
		int totalDamage = 0;
		for (Equipment equipment : equipmentList) {
			totalDamage += equipment.damage();
		}
		
		return totalDamage;
	}
	
	public int protection() {
		int totalProtection = 0;
		for (Equipment equipment : equipmentList) {
			totalProtection += equipment.protection();
		}
		return totalProtection;
	}
	
	public boolean isHeroic() {
		return heroicity != null;
	}
	
	public boolean isBetterThan(Knight anotherKnight) {
		return damage() > anotherKnight.damage();
	}
	
	public void setHeroicity(Heroicity herocity) {
		Objects.requireNonNull(herocity, "heroicity can't be null");
		this.heroicity = herocity;
	}

	@Override
	public String toString() {
		var output = new StringBuilder();
		var seperator = "";
		output.append(name).append(" damage: ").append(damage())
			.append(" protection: ").append(protection()).append("\n  [");
		
		for (Equipment equipment : equipmentList) {
			output.append(seperator).append(equipment);
			seperator = ", ";
		}
		
		output.append("]");
		
		return output.toString();
	}
	
}
