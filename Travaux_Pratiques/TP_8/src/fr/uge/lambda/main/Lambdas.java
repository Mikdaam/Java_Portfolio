package fr.uge.lambda.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;

import fr.uge.lambda.data.Actor;

public class Lambdas {
  public static void upperCaseAll(ArrayList<String> stringLists) {
    stringLists.replaceAll(s -> s.toUpperCase(Locale.ROOT));
  }
  
  public static Map<String, Integer> occurrences(ArrayList<String> stringLists) {
    var resume = new HashMap<String, Integer>();
    //stringLists.forEach(s -> resume.merge(s, 1, (oldVal, newVal) -> oldVal + newVal));
    stringLists.forEach(s -> resume.merge(s, 1, Integer::sum));
    return resume;
  }
  
  public static Map<String, List<Actor>> actorGroupByFirstName(List<Actor> actorsList) {
    var groupBy = new HashMap<String, List<Actor>>();
    //groupBy.computeIfAbsent(null, null)
    actorsList.forEach(actor -> groupBy.computeIfAbsent(actor.firstName(), k -> new ArrayList<>()).add(actor));
    return groupBy;
  }
  
  public static Map<String, List<Actor>> actorGroupBy(List<Actor> actorsList, Function<Actor, String> groupByFunction) {
    var groupBy = new HashMap<String, List<Actor>>();
    actorsList.forEach(actor -> groupBy.computeIfAbsent(groupByFunction.apply(actor), k -> new ArrayList<>()).add(actor));
    return groupBy;
  }
  
  /*public static <T, V> Map<T, List<V>> groupBy(List<V> lists, Function<T, V> groupByFunction) {
    var groupBy = new HashMap<V, List<T>>();
    lists.forEach(elt -> elt.computeIfAbsent(groupByFunction.apply(V), k -> new ArrayList<>()).add(elt));
    return groupBy;
  }*/
  
  public static void main(String[] args) {
    var lists = new ArrayList<String>(List.of("toto", "toto", "toto", "tata", "tata", "titi", "tutu"));
    
    //lists.forEach(System.out::println);
    System.out.println(lists.toString());
    
    upperCaseAll(lists);
    
    System.out.println("=================PRINTLN=====================");
    //lists.forEach(System.out::println); 
    System.out.println(lists.toString());
    
    var occur = occurrences(lists);
    
    System.out.println("=================OCCURENCES=====================");
    System.out.println(occur.toString());
    
    System.out.println("=================GROUP BY=====================");
    var actorList = List.of(new Actor("bob", "de niro"), new Actor("bob", "cat"), new Actor("willy", "cat"), new Actor("willy", "toto"));
    var groupByFirstName = actorGroupByFirstName(actorList);
    System.out.println(groupByFirstName);
    
    System.out.println("=================GROUP BY(GENERAL)=====================");
    var groupBy = actorGroupBy(actorList, Actor::lastName);
    System.out.println(groupBy);
  }
}
