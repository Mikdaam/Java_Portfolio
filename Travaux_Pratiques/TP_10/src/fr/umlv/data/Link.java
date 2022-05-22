package fr.umlv.data;

public record Link<T>(T value, Link<T> next) {
	public static void main(String[] args) {
		Link<Integer> firstLink = new Link<Integer>(13, null); 
		Link<Integer> second = new Link<Integer>(144, firstLink);
	}
}
