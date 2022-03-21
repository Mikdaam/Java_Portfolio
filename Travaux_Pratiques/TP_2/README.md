# TP : String, StringBuilder, egalité et expressions régulières

##  Exercice 1
1. 
   a. Le type de `p` est `Pixel`
   b. A répondre

2. Le code affiche : 
    ```sh
        user:~/Exo1/bin$ java --enable-preview Pixel
        true
        false
        false
        user:~/Exo1/bin$ 
    ```
- La première comparaison renvoie `true` parce que `p1` est une copie de la référence de l'objet `p2`.

1. La methode à utiliser si l'on veut tester si le contenu des chaines de caractères est la même est : `equals()`. En faisant : 
```java
    var s4 = "toto";
    var s5 = new String(s4);

    System.out.println(s4.equals(s5));
```
4. La deuxieme comparaison renvoie `false` parce qu'il faut reecrire la methode `equals()` de la classe `Pixel`.

## Exercice 2


