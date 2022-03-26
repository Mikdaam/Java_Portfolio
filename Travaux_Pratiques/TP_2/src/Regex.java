import java.util.regex.Pattern;

public class Regex {
    // 1. a. La class java.util.regex.Pattern permet de definir un pattern pour le moteur regex
    // La methode compile() compile l'expression donnee sous forme de string en pattern.

    // b. La classe java.util.regex.Matcher permet de verifier si un pattern correspond à une chaine
    // de caractère.

    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("Usage: java Regex <arg1> <arg2> ...");
            return;
        }

        // Pattern number = Pattern.compile("\\d+");
        
        // /* Question: vu que j'alloue la memoire dans las booucle + ou stringbuilder */
        // for(String argument: args) {
        //     if(number.matcher(argument).matches()) {
        //         System.out.println(argument + " is a number.");
        //     }
        // }
        
        // for(String argument: args) {
        //     if(Pattern.matches("\\D*\\d+$", argument)) {
        //         System.out.print(argument + " ");
        //     }
        // }

        // 4. stack overflow link : https://stackoverflow.com/questions/5284147/validating-ipv4-addresses-with-regexp
        System.out.println("IP? : " + args[0]);
        System.out.println("====================");
        var ip_parts = splitIPAdress(args[0]);
        for (int i = 0; i < ip_parts.length; i++) {
            System.out.println("Part "+ i +" => " + (ip_parts[i] & 0xFF));
        }
    }

    public static byte[] splitIPAdress(String ip) {
        var pattern = Pattern.compile("((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)(\\.(?!$)|$))");
        var matcher = pattern.matcher(ip);
        boolean isIP = Pattern.matches("^((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)(\\.(?!$)|$)){4}$", ip);
        var result = new byte[4];
        if(!isIP) {
            throw new IllegalArgumentException("Not a valid IPv4 address");
        }

        int i = 0;
        while (matcher.find()) {
            var part = i < 3 
                ? Integer.parseInt(matcher.group().substring(0, matcher.group().length() - 1))
                : Integer.parseInt(matcher.group());
            result[i] = (byte) part;
            i++;
        }
        return result;
    }
}
