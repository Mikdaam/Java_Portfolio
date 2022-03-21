# Debriefing

<!-- Un tableau ici avec Nom, Prenom,  -->

# Exercice 1 - Hello Groland
1. Ecrire le programme dans un fichier `HelloGroland.java`
    Done ✅

2. Compiler le programme en utilisant le commande javac puis vérifier que le fichier `.class` correspondant existe bien. 
    Done ✅

3. Exécuter le programme avec la commande java
    Done ✅

# Exercice 2 - Afficher les arguments de la ligne de commande
1. If you run the program without arguments, the program fails with an exception.
2. Adding code here
3. Here too.

# Exercice 3 - Calculette simple

# Exercice 4 - Record et conversion de String en entier

# Exercice 5 - De C vers Java
1. Compiling the C program with the command `gcc -o pascal pascal.c`. When we run the program with `time` command, we get the following output:
```bash
user@host:~/workdir$ time ./pascal
 Cn, p = -1742193024

real    0m1.074s
user    0m1.070s
sys     0m0.001s
```

2. Compiling the Java program with the command `javac Pascal.java`. When we run the program with `time` command, we get the following output:
```bash
user@host:~/workdir$ time java Pascal
 Cn, p = -1742193024

real    0m0.297s
user    0m0.276s
sys     0m0.029s
```

## Explanation
On constate que le temps d'éxecution du programme en C est 5 fois plus long que celui en Java.
Cette différence s'explique par la façon dont l'allocation et la libération mémoire est effectué.
Le Java utilise un garbage collector qui libère automatiquement les objets mémoire qui ne sont plus utilisés. Ce GC est plus efficace que l'allocation et la libération mémoire faite manuellement en C.