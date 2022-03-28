# Pratical Exercices N° 3 - Debriefing

| Nom     | Prenom  |
|:-------:|:-------:|
| BADAROU | Mikdaam |

## Exercice 1 - Book

1. Declare a record `Book` with `title` and `author` components.
   
   ```java
   public record Book(String title, String author) {}
   ```

2. Adding main method to the `Book` record
   
   ```java
    public record Book(String title, String author) {
        public static void main(String[] args) {
            var book = new Book("Da Vinci Code", "Dan Brown");
            System.out.println(book.title + ' ' + book.author);
        }
    }
   ```
   
   ## Exercice 2 - Liberty, Equality, toString

## Exercice 3

## Exercice 4 - Bubble Sort