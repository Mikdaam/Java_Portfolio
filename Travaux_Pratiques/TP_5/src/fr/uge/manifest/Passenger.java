package fr.uge.manifest;

import java.util.Objects;

/**
 * @author Mick Cool
 *
 */
public record Passenger(String destination) implements Item {
	public Passenger {
		Objects.requireNonNull(destination, "destination must be not null");
	}

	@Override
	public String toString() {
		return destination + " (passenger)";
	}

	@Override
	public int weight() {
		return 0;
	}

	@Override
	public int onboardPrice() {
		return 10;
	}
}
