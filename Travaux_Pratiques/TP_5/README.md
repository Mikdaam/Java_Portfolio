# Pratical Exercices N° 5 - Debriefing

## Exercice 1 - Masterize Eclipse :)
> A container ship is a ship that, as the name suggests, transports containers from one port to another. Each container ship has a manifest, which is a paper document containing a list of all containers it carries.
The purpose of this TP is to model this paper document.

1. **Define the `Container` type in `fr.uge.manifest`.**
    ```java
    package fr.uge.manifest;

    import java.util.Objects;

    public record Container(String destination, int weight){
        public Container {
            Objects.requireNonNull(destination, "destination must be not null");
            if (weight <= 0) {
                throw new IllegalArgumentException("weight must be positive");
            }
        }
    }
    ```
    > To define the `Container`, a record is the best way because we don't want to modify a container data.

2. **Define the `Manifest` type in `fr.uge.manifest` which contains a list of containers.**
    ```java
    package fr.uge.manifest;
    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.Objects;

    public class Manifest {
        private final ArrayList<Item> containers;
        
        public Manifest() {
            containers = new ArrayList<>();
        }
        
        public void add(Item container) {
            Objects.requireNonNull(container, "container must not be null");
            containers.add(container);
        }
        
    }
    ```
    > To define the Manifest, we have to use a class instead of a record because we don't want anyone to modify 

7. Parce que le code n'est plus maintenable si on ajoute un nouveau type à notre interface

