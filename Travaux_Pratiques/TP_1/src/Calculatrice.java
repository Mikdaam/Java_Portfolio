import java.util.Scanner;

public class Calculatrice {
    public static void main(String[] args) {
        /**
            Scanner input;  Q? : Pourquoi ne pas faire initialisation sur la meme ligne; R: repondu à la question suivante *
            input = new Scanner(System.in);
        */
        // 1 et 2 
        Scanner input = new Scanner(System.in); // Variable: input; Type: Scanner
        System.out.print("Entier 1 : ");
        int value1 = input.nextInt(); // Variable: value; Type: int

        /* Affichage du nombre entre par l'utilisateur 
         *  System.out.println(value);
        */
        
        // 3) nextInt() n'est pas une fonction car il appartient à la classe Scanner. De ce fait nextInt() est une méthode de la classe Scanner

        // 4) La ligne 'import java.util.Scanner;' importe la classe Scanner du package java.util dans le programme
        System.out.print("Entier 2 : ");
        int value2 = input.nextInt();

        // 5) Affichage somme
        System.out.println("Somme: " + value1 + " + " + value2 + " = " + (value1 + value2));

        // 6) Affichage produit, soustraction, division, reste
        System.out.println("Produit: " + value1 + " * " + value2 + " = " + (value1 * value2));
        System.out.println("Difference: " + value1 + " - " + value2 + " = " + (value1 - value2));
        System.out.println("Quotient: " + value1 + " / " + value2 + " = " + (value1 / value2));
        System.out.println("Reste: " + value1 + " % " + value2 + " = " + (value1 % value2));
    }
}