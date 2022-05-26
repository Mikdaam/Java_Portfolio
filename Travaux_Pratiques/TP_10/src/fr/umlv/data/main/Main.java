package fr.umlv.data.main;

import fr.umlv.data.LinkedLink;

public class Main {
	public static void main(String[] args) {
		var myList = new LinkedLink<Integer>();
		myList.add(1);
		myList.add(2);
		myList.add(3);
		myList.add(4);
		myList.add(5);
		
		System.out.println(myList.get(3));
		
		myList.forEach(e -> System.out.println(e));
		
		System.out.println(myList);
		
		/*===========MORE GENERIC CODE WITH OBJECTS==================*/
		var l = new LinkedLink<String>();
	       l.add("hello");
	       l.add("world");
	       l.forEach( s -> System.out.println("string " + s + " length " + s.length()));
	}
}
