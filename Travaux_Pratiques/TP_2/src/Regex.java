import java.util.regex.Pattern;

public class Regex {
    // 1. a. La class java.util.regex.Pattern permet de definir un pattern pour le moteur regex
    // La methode compile() compile l'expression donnee sous forme de string en pattern.

    // b. La classe java.util.regex.Matcher permet de verifier si un pattern correspond à une chaine
    // de caractère.

    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("Usage: java Regex <arg1> <arg2> ...");
            System.exit(0);
        }

        Pattern number = Pattern.compile("\\d+");

        // 2. 
        for(String argument: args) {
            if(number.matcher(argument).matches()) {
                System.out.println(argument + " is a number.");
            }
        }
        
        // 3. 
        for(String argument: args) {
            if(Pattern.matches("\\D*\\d+$", argument)) {
                System.out.print(argument + " ");
            }
        }
        System.out.println();

        // 4. stack overflow link : https://stackoverflow.com/questions/5284147/validating-ipv4-addresses-with-regexp
    }

    /*public static byte[] splitIPAdress(String ip) {
        Boolean isIP = Pattern.matches("^((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)(\\.(?!$)|$)){4}$", ip);
        
    }*/
}
