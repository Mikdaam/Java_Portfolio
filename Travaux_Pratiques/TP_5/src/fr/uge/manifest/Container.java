/**
 * 
 */
package fr.uge.manifest;

import java.util.Objects;

/**
 * @author Mick Cool
 *
 */
public record Container(String destination, int weight) implements Item {
	public Container {
		Objects.requireNonNull(destination, "destination must be not null");
		if (weight <= 0) {
			throw new IllegalArgumentException("weight must be positive");
		}
	}

	@Override
	public String toString() {
		return destination + " " + weight + "kg";
	}

	@Override
	public int onboardPrice() {
		return weight * 2;
	}
	
	@Override
	public boolean isContainer() {
		return true;
	}
}
