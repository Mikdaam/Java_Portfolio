import java.util.ArrayList;
import java.util.Objects;

public class Library {
	private ArrayList<Book> books = new ArrayList<Book>();
	
	public void add(Book book) {
		Objects.requireNonNull(book);
		books.add(book);
	}
	
	public Book findByTitle(String title) {
		for (Book book : books) {
			if (book.title().equals(title)) {
				return book;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		var output = new StringBuilder();
		for (Book book : books) {
			output.append(book.title()).append("\n");
		}
		return output.toString();
	}
	
}
