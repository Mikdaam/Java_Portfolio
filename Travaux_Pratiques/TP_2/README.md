# Report: String, StringBuilder, aquality and regulars expressions

##  Exercice 1
1. Considering the following code
    ```java
    var s = "toto";
    System.out.println(s.length());
    ```
    - The variable s has the `String` type.
    - The compiler know that the variable s have `length()` method because it know that the type of `s` is `String`.

2. The following code :
    ```java
    var s1 = "toto";
    var s2 = s1;
    var s3 = new String(s1);

    System.out.println(s1 == s2);
    System.out.println(s1 == s3);
    ```
    displays : 
    ```sh
    user:~/Exo1/bin$ java Main
    true
    false
    ```
    - The first comparison return `true` because the `s2` and `s1` contains the reference of `"toto"` string.
    - The second comparison return `false` because the reference of `new String(s1)` is different of the reference`s1`

3. To compares the contains of two strings, we have to use the `equals()` method.
    ```java
    var s4 = "toto";
    var s5 = new String(s4);

    System.out.println(s4.equals(s5));
    ```

4. The following code
    ```java
    var s6 = "toto";
    var s7 = "toto";
    System.out.println(s6 == s7);
    ```
    display
    ```
    true
    ```
    > The comparison return `true` because the JVM create an object `"toto"` in the heap and assign the reference of this object to `s6` and `s7` variable
    So both variables contains the reference of `"toto"` object.

5. The `String` has to be immutable to ensure the integrity of the contains of the string.

6. The following code
    ```java
    var s8 = "hello";
    s8.toUpperCase();
    System.out.println(s8);
    ```
     display 
    ```
    hello
    ```
    > The `toUpperCase()` methode return a string, so the return has to be assigned to a variable.

## Exercice 2 - Morse Stop.
1. Write a code using the `+` operator to concatenate
    ```java
    public class Morse {
        public static void main(String[] args) {
            int len = args.length;
            if(len == 0) {
                System.err.println("Usage: java Morse <arg1> <arg2> ....");
                return;
            }
            var output = "";
            for(String arg: args) {
                output + args + " Stop. ";
            }
            System.out.println(output);
        }
   }
    ```

2. The `StringBuilder` object allow us to build a string with better performance.
    - The `append(String)` method return a `StringBuilder` object to allow us the chaining of method call like :
    ```java
        var myString = new StringBuilder().append("Hello).append("World);
    ``` 

3. Rewrite the previous code using `StringBuilder`
    ```java
    public class Morse {
        public static void main(String[] args) {
            int len = args.length;
            if(len == 0) {
                System.err.println("Usage: java Morse <arg1> <arg2> ....");
                return;
            }
            var output = new StringBuilder();
            for(String arg: args) {
                output.append(args)
                    .append(" Stop. ");
            }
            System.out.println(output);
        }
   }
    ```
    > Using the `Sringbuilder` is better than the concatenation beacause the `+` operator allocate the momory for each concatenation.  

4. We can use `' '` instead of `" "` because if an operand of `+` operateur is a string, the result of the operation is a string.
    - We can deduce that the JVM replace the `+` operator with the method `append()` of `StringBuilder` .

5. We can deduce that the JVM replace the `+` operator with the method `append()` of `StringBuilder` .
    - We can use a `StringBuilder` in case of a loop and the `+` operator incase of inline code
    - The usage of `+` operator in the `append()` method is bad beacuse the `+` operator allocate a memory each time there is an operand


## Exercice 3 - Regex pattern
1. The `Pattern` classe 

2. Write a program who match the command line arguments
    ```java
    import java.util.regex.Pattern;

    public class Regex {
        public static void main(String[] args) {
            if(args.length == 0) {
                System.out.println("Usage: java Regex <arg1> <arg2> ...");
                return;
            }

            Pattern number = Pattern.compile("\\d+");

            for(String argument: args) {
                if(number.matcher(argument).matches()) {
                    System.out.println(argument + " is a number.");
                }
            }
        }
    }
    ```

3. Edit the previous code to macthes the argument who contains at leat one digit
    ```java
    import java.util.regex.Pattern;

    public class Regex {
        public static void main(String[] args) {
            if(args.length == 0) {
                System.out.println("Usage: java Regex <arg1> <arg2> ...");
                return;
            }

            for(String argument: args) {
                if(Pattern.matches("\\D*\\d+$", argument)) {
                    System.out.print(argument + " ");
                }
            }
        }
    }
    ```

4. Write a method who matches an IPv4 adress
    ```java
    import java.util.regex.Pattern;

    public class Regex {
        public static void main(String[] args) {
            ...
        }

        public static byte[] splitIPAdress(String ip) {
            Boolean isIPv4 = Pattern.matches("((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)(\\.(?!$)|$)){4}$", ip);
            if(isIPv4) {
                
            }
        }
    }
    ```