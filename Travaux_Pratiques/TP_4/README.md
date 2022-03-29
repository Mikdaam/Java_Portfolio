# Debriefing

## Exercice 1 - Masterize Eclipse :)
1. 

2. 

3. Creates a class `Main` and move the `main()` method in it.
    ```java
    public class Main {
        public static void main(String[] args) {
            var book = new Book("Da Vinci Code", "Dan Brown");
            System.out.println(book.title + ' ' + book.author);
        }
    }
    ```
    - In the `main()` method of the class, we can not access directly to the components of the records, so the above code is not valid. A valid code wiil be :
    ```diff
    public class Main {
        public static void main(String[] args) {
    -       var book = new Book("Da Vinci Code", "Dan Brown");
    +       System.out.println(book.title() + ' ' + book.author());
        }
    }
    ```

4. Avoid the record to create object with `null` components
    To avoid the creation of object with `null` components, we can use the static method `requireNonNull` in the constructor of the record.
    ```java
    import java.util.Objects;
    public record Book(String title, String author) {
        public Book(String title, String author) {
            Objects.requireNonNull(title, "title must not be null");
            Objects.requireNonNull(author, "author must not be null");
        }
    }
    ```

5. Use a compact constructor for the previous questions
    ```java
    import java.util.Objects;
    public record Book(String title, String author) {
        public Book {
            Objects.requireNonNull(title, "title must not be null");
            Objects.requireNonNull(author, "author must not be null");
        }
    }
    ```

6. Create a second constructor who takes just the `title` components
    ```diff
    import java.util.Objects;
    public record Book(String title, String author) {
        public Book {
            Objects.requireNonNull(title, "title must not be null");
            Objects.requireNonNull(author, "author must not be null");
        }

    +   public Book(String title) {
    +       this(title, "<no author>");
    +   }
    }
    ```

7. How does the compiler know what constructor call ?
    > The compiler looks the signature of each constructor to decide what constructor call.


## Exercice 2 - Library
1. Create a class `Libary` with an attribute `book`;
```java
import java.util.LinkedHashMap;

public class Library {
	private final ArrayList<Book> books;
	
	public Library() {
		books = new ArrayList<Book>();
	}

	public void add(Book book) {
		Objects.requireNonNull(book, "book must not be null");
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
}
```

2. Add a method `add()` in the class
```diff
import java.util.ArrayList;

public class Library {
	private final ArrayList<Book> books;
	
	public Library() {
		books = new ArrayList<Book>();
	}

+	public void add(Book book) {
+		Objects.requireNonNull(book, "book must not be null");
+		books.add(book);
+	}
}
```
    
3. Add a method `findByTitle()` to the class
```diff
import java.util.ArrayList;

public class Library {
	private final ArrayList<Book> books;
	
	public Library() {
		books = new ArrayList<Book>();
	}

	public void add(Book book) {
		Objects.requireNonNull(book, "book must not be null");
		books.add(book);
	}

+    public Book findByTitle(String title) {
+		for (Book book : books) {
+			if (book.title().equals(title)) {
+				return book;
+			}
+		}
+		return null;
+	}
}
```

4. When the compiler found a `foreachloop`, he convert it in an iterator.


5. I don't know, ask to teacher

6. Add a method `toString()` to the class
```diff
import java.util.ArrayList;

public class Library {
	private final ArrayList<Book> books;
	
	public Library() {
		books = new ArrayList<Book>();
	}

	public void add(Book book) {
		Objects.requireNonNull(book, "book must not be null");
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

+    @Override
+	public String toString() {
+		var output = new StringBuilder();
+		for (Map.Entry<String, Book> entry : books.entrySet()) {
+			output.append(entry.getKey()).append("\n");
+		}
+		return output.toString();
+	}
}
```

## Exercice 3 - Library 2 - The return of vengeance
- Exception 
```sh
Exception in thread "main" java.util.ConcurrentModificationException
	at java.base/java.util.LinkedHashMap$LinkedHashIterator.nextNode(LinkedHashMap.java:756)
	at java.base/java.util.LinkedHashMap$LinkedValueIterator.next(LinkedHashMap.java:783)
	at Library.removeAllBooksFromAuthor(Library.java:44)
	at Main.main(Main.java:19)

```
parce qu'on parcout et modifie en meme temps

1. The complexity of the method `findByTitle` is O(n).

2. The Data structure imlemanting in HashMap is a dictionnary
    - The complexity of a `HashMap` is o(1);

3. Rewrites the methods `add()` and `findByTitle()` using an HashMap.
    ```java
    
    ```