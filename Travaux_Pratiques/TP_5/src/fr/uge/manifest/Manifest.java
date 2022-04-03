/**
 * 
 */
package fr.uge.manifest;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Mick Cool
 *
 */
public class Manifest {
	private final ArrayList<ContainerType> container_list;
	
	public Manifest() {
		container_list = new ArrayList<>();
	}
	
	public void add(ContainerType container) {
		Objects.requireNonNull(container, "container must not be null");
		container_list.add(container);
	}
	
	public int weight() {
		var total_weight = 0;
		for (var container : container_list) {
			total_weight += container.weight();
		}
		
		return total_weight;
	}
	
	public int price() {
		var total_price = 0;
		for (var container : container_list) {
			total_price += container.onboardPrice();
		}
		
		return total_price;
	}

	public void removeAllContainersFrom(String destination) {
		Objects.requireNonNull(destination, "destination must not be null");
		
		var iterator = container_list.iterator();
		while (iterator.hasNext()) {
			var container = iterator.next();
			if (container.destination().equals(destination) && container.isContainer()) {
				iterator.remove();
			}
		}
	}
	
	@Override
	public String toString() {
		var output = new StringBuilder();
		var new_line = "";
		for (int i = 0; i < container_list.size(); i++) {
			output.append(new_line).append(i + 1).append(".").append(container_list.get(i));
			new_line = "\n";
		}
		
		return output.toString();
	}
	
}
