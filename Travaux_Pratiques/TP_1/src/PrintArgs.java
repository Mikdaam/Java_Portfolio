public class PrintArgs {
    public static void main(String[] args) {
        /**
            Si l'on ne passe pas d'argument au programme, on a une exception
            System.out.println(args[0]);
            Pour eviter ça, on peut faire :
        */
        int len = args.length;

        if(len == 0) {
            System.err.println("Usage: java PrintArgs <arg1> <arg2> ....");
            return;
        }

        /**
            Boucle affichant le contenu des tableaux
        */
        for(int i = 0; i < len; i++) {
            System.out.println(args[i]);
        }

        /**
            Utilisation de la boucle foreach
        */
        for(String arg: args) {
            System.out.println(arg);
        }
    }
}