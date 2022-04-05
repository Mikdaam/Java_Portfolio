package fr.uge.blockbuster.main;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.time.Duration;

import fr.uge.blockbuster.articles.Article;
import fr.uge.blockbuster.articles.LaserDisc;
import fr.uge.blockbuster.articles.VideoTape;
import fr.uge.blockbuster.catalog.Catalog;

public class Main {
	public static void main(String[] args) throws IOException {
		var laserDisc = new LaserDisc("Jaws");
	    var videoTape = new VideoTape("The Cotton Club", Duration.ofMinutes(128));
	    var videoTape2 = new VideoTape("Mission Impossible", Duration.ofMinutes(110));
	    
	    var catalog = new Catalog();
	    catalog.add(laserDisc);
	    catalog.add(videoTape);
	    catalog.add(videoTape2);
	    //catalog.add(new LaserDisc("Mission Impossible"));  // exception !
	    System.out.println(catalog.lookup("Jaws"));
	    System.out.println(catalog.lookup("The Cotton Club"));
	    System.out.println(catalog.lookup("Indiana Jones"));
	    
	    System.out.println("===============================");
	    
	    var laserDiscText = laserDisc.toText();
	    var videoTapeText = videoTape.toText();
	    System.out.println(laserDiscText);  // LaserDisc:Jaws
	    System.out.println(videoTapeText);
	    
	    System.out.println("===============================");
	    
	    var laserDisc2 = Article.fromText(laserDiscText);
	    var videoTape3 = Article.fromText(videoTapeText);
	    System.out.println(laserDisc.equals(laserDisc2));  // true
	    System.out.println(videoTape.equals(videoTape3));
	    
	    var catalog2 = new Catalog();
	    catalog2.add(laserDisc);
	    catalog2.add(videoTape);
	    
	    try {
	    	catalog2.save(Path.of("catalog.txt"));
		} catch (IOException e) {
			System.err.println(e.getMessage());
			System.exit(1);
			return;
		}
	    
	    System.out.println("===============================");
	    
	    var catalog3 = new Catalog();
	
	    	catalog3.load(Path.of("catalog.txt"));
	    System.out.println(catalog3.lookup("Jaws"));  // LaserDisc:Jaws
	    System.out.println(catalog3.lookup("The Cotton Club"));  // VideoTape:The Cotton Club:128
	    
	    System.out.println("===============================");
	    
	    var catalog4 = new Catalog();
	    catalog4.add(new LaserDisc("A Fistful of"));
	    catalog4.add(new VideoTape("For a Few s More", Duration.ofMinutes(132)));
	    catalog4.save(Path.of("catalog-windows-1252.txt"), Charset.forName("Windows-1252"));
	
	    var catalog5 = new Catalog();
	  
	    	
	    catalog5.load(Path.of("catalog-windows-1252.txt"), Charset.forName("Windows-1252"));
	
	    System.out.println(catalog5.lookup("A Fistful of"));
	    System.out.println(catalog5.lookup("For a Few s More"));
	    
	    System.out.println("===============================1");
	    
	    var catalog6 = new Catalog();
	    catalog6.add(new VideoTape("Back to the future", Duration.ofMinutes(116)));
	    catalog6.add(new LaserDisc("Back to the future part II"));
	    catalog6.add(new LaserDisc("Back to the future part III"));
	    	catalog6.saveInBinary(Path.of("catalog.binary"));

	    var catalog7 = new Catalog();
	    
	    catalog7.loadFromBinary(Path.of("catalog.binary"));
	    
	    System.out.println(catalog7.lookup("Back to the future"));
	    System.out.println(catalog7.lookup("Back to the future part II"));
	    System.out.println(catalog7.lookup("Back to the future part III"));
	}
}
