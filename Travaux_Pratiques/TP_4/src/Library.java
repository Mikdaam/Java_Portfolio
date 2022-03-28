import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Library {
	//private ArrayList<Book> books;
	private Map<String, Book> books;
	
	// public Library() {
	// 	books = new ArrayList<Book>();
	// }

	// public void add(Book book) {
	// 	Objects.requireNonNull(book, "book must not be null");
	// 	books.add(book);
	// }
	
	// public Book findByTitle(String title) {
	// 	for (Book book : books) {
	// 		if (book.title().equals(title)) {
	// 			return book;
	// 		}
	// 	}
	// 	return null;
	// }

	public Library() {
		books = new LinkedHashMap<String, Book>();
	}

	public void add(Book book) {
		Objects.requireNonNull(book, "book must not be null");
		books.put(book.title(), book);
	}
	
	public Book findByTitle(String title) {
		return books.get(title);
	}

	@Override
	public String toString() {
		var output = new StringBuilder();
		for (Map.Entry<String, Book> entry : books.entrySet()) {
			output.append(entry.getKey()).append("\n");
		}
		return output.toString();
	}
	
}
