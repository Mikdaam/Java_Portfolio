package fr.umlv.arthur.test;

import fr.umlv.arthur.alternatif.Bow;
import fr.umlv.arthur.alternatif.Heroicity;
import fr.umlv.arthur.alternatif.Knight;
import fr.umlv.arthur.alternatif.Shield;
import fr.umlv.arthur.alternatif.Sword;

public class Test {
	public static void main(String[] args) {
		var excalibur = new Sword("excalibur", 10);
	    var arthur = new Knight("arthur", excalibur);
	    System.out.println(excalibur.name());    // affiche: excalibur
	    System.out.println(excalibur.damage());  // affiche: 10
	    System.out.println(excalibur);           // affiche: excalibur
	    System.out.println(arthur.name());       // affiche: arthur
	    System.out.println(arthur.damage());     // affiche: 10
	    
	    var excalibur2 = new Sword("excalibur", 10);
	    System.out.println(excalibur.equals(excalibur2));     // true
	    
	    var secace = new Sword("secace", 7);
	    var seure = new Sword("seure", 4);
	    var lancelot = new Knight("lancelot", secace, seure);
	    System.out.println(lancelot.damage());     // 11
	    
	    System.out.println(lancelot.isBetterThan(arthur));  // true
	    
	    var hydra = new Shield("hydra", 4);
	    var clarent = new Sword("clarent", 7);
	    var mordred = new Knight("mordred", hydra, clarent);
	    System.out.println(mordred.damage());  // 7
	    System.out.println(mordred.protection());  // 4
	    
	    System.out.println(arthur);
	    System.out.println(mordred);
	    
	    var astra = new Sword("astra", 20);
	    var bow1 = new Bow("bow1", 10, 7);  // bow1 est un Bow de name "bow1", 
	                                        // de damage 10 et de protection 7
	    var bow2 = new Bow("bow2", 10, 7);
	    var shield = new Shield("shield", 12);
	    var shiva = new Knight("shiva", astra, bow1, bow2, shield);
	    System.out.println(shiva);  //affiche: shiva damage: 40 protection: 26
	    
	    System.out.println(arthur.isHeroic());   // false
	    arthur.setHeroicity(new Heroicity(2));   // applique un facteur 2
	    System.out.println(arthur.isHeroic());   // true
	    System.out.println(arthur.damage());     // 20
	    System.out.println(arthur.protection()); // 0
	    System.out.println(arthur);  // affiche: arthur damage: 20 protection: 0
	}
}
