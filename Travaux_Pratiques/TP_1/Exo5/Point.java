//  Ligne de commande pour compiler le fichier Point.java est 'javac --enable-preview Point.java'
public record Point(int x, int y) {
    /* Parametre
    *  x : int
    *  y : int
    *  Retour float
    */
    public float distance(int x, int y) {  
        float dist;
        dist = Math.sqrt((x() - 0) + (y() - 0));
        return dist;
    }
};

public class Point {

    /* */
    public static void main(String[] args) {

        if(args.length != 2) {
            System.err.println("Usage: java Point x y");
            System.exit(0);
        }

        /* Affichage des valeurs convertis */
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);

        /*3) Une méthode statique veut dire qu'on peut utiliser cette méthode sans instancier la classe auquel
        * elle appartient
        */

        System.out.println("x="+ x +", y="+ y);
		Point p = new Point(x, y);
		System.out.println(p.toString());
    }  
}
