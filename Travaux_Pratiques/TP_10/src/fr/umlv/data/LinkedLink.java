package fr.umlv.data;

import java.util.Objects;
import java.util.StringJoiner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LinkedLink<T> {
	private Link<T> headList;
	private int length;
	
	/*public LinkedLink() { Don't need this constructor. Is done by default by the constructor
		headList = null;
		length = 0;
	}*/
	
	public void add(T value) {
		Link<T> newLink = new Link<T>(value, headList);
		headList = newLink;
		length++;
	}
	
	public T get(int index) {
		/*if (index < 0 || index  >= length) {
			throw new IllegalArgumentException("Index of element should be positive and less than the size of the list");
		}*/
		
		Objects.checkIndex(index, length);
		
		Link<T> headPointer = headList;
		for (int current_index = 0; current_index < index; current_index++) {
			headPointer = headPointer.next();
		}
		return headPointer.value();
	}
	
	public void forEach(Consumer<T> consumer) {
		Link<T> pointer = headList;
		while (pointer != null) {
			consumer.accept(pointer.value());
			pointer = pointer.next();
		}
	}
	
	/*private LinkedLink<T> removeIfLoop(Link<T> link, Predicate<T> predicate) {
    if(link == null) {
      return new LinkedList<>();
    }
    
    var removedList = removeIfLoop(link.next(), predicate);
    
    if()
    
  }*/
	
	public void removeIf(Predicate<T> predicate) {
		
	}

	@Override
	public String toString() {
		/*Stream.iterate(null, null, null) TODO: Ask the professor about how to use iterate */
		var listString = new StringJoiner(" --> ");
		
		for (int i = 0; i < length; i++) {
			listString.add(get(i)+"");
		}
		
		return listString.toString();
	}
}
