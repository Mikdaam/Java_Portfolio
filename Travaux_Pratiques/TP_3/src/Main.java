public class Main {
    /**
     * Problem: pas acces aux composants de l'objet Book
     * recuperer avec getters et setters
     * @param args
     */
    public static void main(String[] args) {
        var book = new Book("Da Vinci Code", "Dan Brown");
        System.out.println(book.title() + ' ' + book.author());

        var noAuthorBook = new Book("The Alchemist");
        System.out.println(noAuthorBook.title() + ' ' + noAuthorBook.author());

        book = book.withTitle("The Da Vinci Code");
        System.out.println(book.title() + ' ' + book.author());

        var book1 = new Book("Da Vinci Code", "Dan Brown");
        var book2 = new Book("Angels & Demons", new String("Dan Brown"));

        System.out.println("Same author ? " + book1.isFromTheSameAuthor(book2));

        /*var weirdBook = new Book(null, "oops");
        System.out.println(weirdBook.title() + ' ' + weirdBook.author());*/

        var b1 = new Book("Da Java Code", "Duke Brown");
        System.out.println(b1);
    }
    /*
    * Il n'a pas implemanter la methode equals 
    */

    public static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    public static int indexOfMin(int array[]) {
        int min = array[0];
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                index = i;
            }
        }
        return index;
    }

    public static int indexOfMin(int array[], int start, int end) {
        int min = array[start];
        int index = start;
        for (int i = start + 1; i < end; i++) {
            if (array[i] < min) {
                min = array[i];
                index = i;
            }
        }
        return index;
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = indexOfMin(array, i, array.length);
            swap(array, i, minIndex);
        }
    }
}
