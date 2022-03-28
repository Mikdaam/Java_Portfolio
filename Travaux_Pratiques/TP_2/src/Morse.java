public class Morse {
    public static void main(String[] args) {
        int len = args.length;
        if(len == 0) {
            System.err.println("Usage: java Morse <arg1> <arg2> ....");
            return;
        }
        var output = "";
        for(String arg: args) {
            output += arg + " Stop. ";
        }
        System.out.println(output);
    }
}