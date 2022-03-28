import java.util.Objects;

public record Book(String title, String author) {
    public Book {
        Objects.requireNonNull(title, "title must not be null");
        Objects.requireNonNull(author, "author must not be null");
    }

    public Book(String title) {
        this(title, "<no author>");
    }
    // on ne peut pas modifier un champs final
    public Book withTitle(String title) {
        return new Book(title, author);
    }

    public boolean isFromTheSameAuthor(Book other) {
        return author.equals(other.author);
    }

    @Override
    public String toString() {
        return title + " by " + author;
    }
}
