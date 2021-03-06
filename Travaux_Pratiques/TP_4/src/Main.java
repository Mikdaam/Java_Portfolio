public class Main {
	public static void main(String[] args) {
		var book = new Book("Da Vinci Code", "Dan Brown");
		var library = new Library();
		library.add(book);
		library.add(new Book("The Da Vinci Code", "Toto"));
		library.add(new Book("The Dark Code", "Titi"));
		library.add(new Book("The White Code", "Tata"));
		System.out.println(library.findByTitle("Da Vinci Code"));
		
		System.out.println(library);
		
		var library2 = new Library();
		library2.add(new Book("Da Vinci Code", "Dan Brown"));
		library2.add(new Book("Angels & Demons", "Dan Brown"));
		
		System.out.println("Before Delete\n===========");
		System.out.println(library2);
		library2.removeAllBooksFromAuthor("Dan Brown");
		
		System.out.println("After Delete\n============");
		System.out.println(library2);
	}
}
