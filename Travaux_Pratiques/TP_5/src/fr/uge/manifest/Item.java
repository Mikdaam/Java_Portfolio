/**
 * 
 */
package fr.uge.manifest;

/**
 * @author Mick Cool
 *
 */
public sealed interface Item permits Container, Passenger {
	
	int weight();
	
	String destination();
	
	int onboardPrice();
	
	default boolean isContainer() {
		return false;
	}
	
}
