package fr.umlv.data;

import java.util.StringJoiner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LinkedLink<T> {
	private Link<T> headList;
	private int length;
	
	public LinkedLink() {
		headList = null;
		length = 0;
	}
	
	public void add(T value) {
		Link<T> newLink = new Link<T>(value, headList);
		headList = newLink;
		length++;
	}
	
	public Link<T> get(int index) {
		if (index < 0 || index  >= length) {
			throw new IllegalArgumentException("Index of element should be positive and less than the size of the list");
		}
		
		Link<T> headPointer = headList;
		
		for (int current_index = 0; current_index < (length - 1 - index); current_index++) {
			headPointer = headPointer.next();
		}
		
		return headPointer;
	}
	
	public void forEach(Consumer<Link<T>> consumer) {
		Link<T> pointer = headList;
		while (pointer != null) {
			consumer.accept(pointer);
			pointer = pointer.next();
		}
	}
	
	public void removeIf(Predicate<T> predicate) {
		
	}

	@Override
	public String toString() {
		/*Stream.iterate(null, null, null) TODO: Ask the professor about how to use iterate */
		var listString = new StringJoiner(" --> ");
		
		for (int i = 0; i < length; i++) {
			listString.add(get(i).value()+"");
		}
		
		return listString.toString();
	}
}
