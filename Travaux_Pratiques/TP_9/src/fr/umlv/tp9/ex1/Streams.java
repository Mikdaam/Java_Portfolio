package fr.umlv.tp9.ex1;
import java.util.ArrayList;
import java.util.List;

public class Streams {
  public record Person(String name, int age) {}

  public static List<String> namesOfTheAdults(List<Person> persons) {
    var names = new ArrayList<String>();
    for(var person: persons) {
      if (person.age() >= 18) {
        names.add(person.name());
      }
    }
    return names;
  }
  
  public static List<String> namesOfTheAdultsStreamVersion(List<Person> persons) {
    return persons.stream()
             .filter(p -> p.age() >= 18)
             .map(Person::name)
             .toList();
  }

  public static void main(String[] args) {
    var persons = List.of(
        new Person("Ana", 21),
        new Person("John", 17),
        new Person("Liv", 29));
    var names = namesOfTheAdults(persons);
    System.out.println(names);
    
    System.out.println("================================");
    
    var streamNames = namesOfTheAdultsStreamVersion(persons);
    System.out.println(streamNames);
  }
}