package fr.uge.manifest.main;

import fr.uge.manifest.Container;
import fr.uge.manifest.Manifest;
import fr.uge.manifest.Passenger;

/**
 * 
 * {@code} This class
 * @see Me too
 * @author Mick Cool
 *
 */
public class TestFirst {
	public static void main(String[] args) {
		var container = new Container("Germany", 500);
	    System.out.println(container.destination());  
	    System.out.println(container.weight()); 
	    
	    System.out.println("===============================");
	    
	    var container2 = new Container("Italy", 400);
	    var container3 = new Container("Austria", 200);
	    var manifest = new Manifest();
	    manifest.add(container2);
	    manifest.add(container3);
	    System.out.println(manifest.weight());
	    
	    System.out.println("===============================");
	    
	    var container4 = new Container("Spain", 250);
	    var container5 = new Container("Swiss", 200);
	    var manifest2 = new Manifest();
	    manifest2.add(container4);
	    manifest2.add(container5);
	    System.out.println(manifest2);
	    
	    System.out.println("================================");
	    
	    var passenger1 = new Passenger("France");
	    var container6 = new Container("England", 350);
	    var manifest3 = new Manifest();
	    manifest3.add(passenger1);
	    manifest3.add(container6);
	    System.out.println(manifest3);
	    System.out.println(manifest3.price());
	    
	    System.out.println("================================");
	    
	    var container8 = new Container("Russia", 450);
	    var container9 = new Container("China", 200);
	    var container10 = new Container("Russia", 125);
	    var passenger2 = new Passenger("Russia");
	    var manifest4 = new Manifest();
	    manifest4.add(container8);
	    manifest4.add(container9);
	    manifest4.add(container10);
	    manifest4.add(passenger2);
	    manifest4.removeAllContainersFrom("Russia");
	    System.out.println(manifest4);
	}
}
