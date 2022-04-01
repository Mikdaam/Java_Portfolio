import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Library {
	//private final ArrayList<Book> books;
	private final LinkedHashMap<String, Book> books;
	
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
		books = new LinkedHashMap<>();
	}

	public void add(Book book) {
		Objects.requireNonNull(book, "book must not be null");
		books.put(book.title(), book);
	}
	
	public Book findByTitle(String title) {
		return books.get(title);
	}
	
	public void removeAllBooksFromAuthor(String author) {
		/*var iterator = books.values().iterator();
		while (iterator.hasNext()) {
			Book book = iterator.next();
			if (book.author().equals(author)) {
				iterator.remove();
			}
		}*/
		Objects.requireNonNull(author, "author must not be null");
		books.values().removeIf(book -> (book.author().equals(author)));
	}

	@Override
	public String toString() {
		var output = new StringBuilder();
		var seperator = "";
		for (var book : books.values()) {
			output.append(seperator).append(book.toString());
			seperator = "\n";
		}
		return output.toString();
	}
	
}
