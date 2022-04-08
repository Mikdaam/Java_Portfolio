package fr.uge.manifest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * @author Mick Cool
 *
 */
public class Manifest {
	private final ArrayList<Item> containers;
	
	public Manifest() {
		containers = new ArrayList<>();
	}
	
	public void add(Item container) {
		Objects.requireNonNull(container, "container must not be null");
		containers.add(container);
	}
	
	public int weight() {
		var totalWeight = 0;
		for (var container : containers) {
			totalWeight += container.weight();
		}
		
		return totalWeight;
	}
	
	public int price() {
		var totalPrice = 0;
		for (var container : containers) {
			totalPrice += container.onboardPrice();
		}
		
		return totalPrice;
	}

	public void removeAllContainersFrom(String destination) {
		Objects.requireNonNull(destination, "destination must not be null");
		
		var iterator = containers.iterator();
		while (iterator.hasNext()) {
			var item = iterator.next();
			if (item.destination().equals(destination) && item.isContainer()) {
				iterator.remove();
			}
		}
	}
	
	public HashMap<String, Integer> weightPerDestination() {
		var weightSummary = new HashMap<String, Integer>();
		for (var item : containers) {
			if (item.isContainer()) {
				var previousValue = weightSummary.getOrDefault(item.destination(), 0);
				weightSummary.put(item.destination(), previousValue + item.weight());
			}
		}
		
		return weightSummary;
	}
	
	@Override
	public String toString() {
		var output = new StringBuilder();
		var refactor = "";

		var i = 1;
		for (var item : containers) {
			output.append(refactor).append(i).append(".").append(item);
			refactor = "\n";
			i++;
		}
		
		return output.toString();
	}
	
}
