package fr.umlv.tp9.ex3;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsTest {

	/**
	 * Renvoie une chaÃ®ne des caractÃ¨res contenant les entiers de la liste sÃ©parÃ©s par
	 * des points virgules.
	 * Par exemple, listIntegerToString(List.of(5,6,7,9)) renvoie "5;6;7;9".
	 */
	public static String listIntegerToString(List<Integer> list){
	  return list.stream()
	      .map(i -> i.toString())
	      .collect(Collectors.joining(";"));
	}

	/**
	 * Renvoie la somme de toutes les longueurs des chaÃ®nes de la liste.
	 * Par exemple, sumLength(List.of("ABC","DE","","F")) renvoie 6.
	 *
	 * Indication : la mÃ©thode sum n'est disponible que sur les streams
	 * de types primitifs IntStream, LongStream... Vous pouvez utiliser
	 * mapToInt pour crÃ©er un IntStream au lieu d'un Stream<Integer>.
	 */

	public static int sumLength(List<String> list){
		return list.stream()
		    .mapToInt(String::length)
		    .sum();
	}

	/**
	 * Renvoie le nombre de chaÃ®nes non vides du tableau
	 * Par exemple, String[] tab = {"ABC", "DE", "", "F"};
	 *              countNonEmpty(tab) renvoie 3.
	 *
	 * Indication : utilisez une des mÃ©thodes Arrays.stream pour crÃ©er un stream Ã  partir d'un tableau.
	 */

	public static long countNonEmpty(String[] array){
		return Arrays.stream(array)
		    .filter(s -> s.length() != 0)
		    .count();
	}

	/**
	 * Renvoie la somme des entiers du tableau
	 * Par exemple, sumLength(Array.of(5, 8, -1, 2)) renvoie 14.
	 */

	public static long sum(int[] tab){
		return Arrays.stream(tab)
		    .sum();
	}

	/**
	 * Renvoie la liste des chaÃ®nes mises en majuscules.
	 */
	public static List<String> capitalizeList(List<String> list){
		return list.stream()
		    .map(String::toUpperCase)
		    .toList();
	}

	/**
	 * Renvoie une Map qui associe Ã  chaque caractÃ¨re la liste des chaÃ®nes commenÃ§ant par ce caractÃ¨re.
	 * Par exemple, mapByFirstCharacter(List.of("AB", "A", "BA", "C") renvoie une map  qui associe
	 * au caractÃ¨re 'A' la liste ["AB","A"], au caractÃ¨re 'B' la liste ["BA"] et au caractÃ¨re 'C' la liste ["C"].
	 *
	 * Indication : utilisez Collectors.groupingBy. Et auusi, attention aux chaÃ®nes vides.
	 */
	public static Map<Character,List<String>> mapByFirstCharacter(List<String> list){
		return  list.stream()
		    .collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.toList()));
	}

	/**
	 * Renvoie une map qui associe Ã  chaque caractÃ¨re l'ensemble des chaÃ®nes commenÃ§ant par ce caractÃ¨re.
	 * Par exemple, mapByFirstCharacterSet(List.of("AB","A","BA","C") renvoie une map  qui associe
	 * au caractÃ¨re 'A' l'ensemble {"AB","A"}, au caractÃ¨re 'B' l'ensemble {"BA"} et au caractÃ¨re 'C' l'ensemble {"C"}.
	 */
	public static Map<Character, Set<String>> mapByFirstCharacterSet(List<String> list){
		return list.stream()
		    .collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.toSet()));
	}

	/**
	 * Renvoie une map qui associe Ã  chaque caractÃ¨re le nombre de chaÃ®nes commenÃ§ant par ce caractÃ¨re.
	 * Par exemple, mapByFirstCharacterSet(List.of("AB","A","BA","C") renvoie une map qui associe
	 * au caractÃ¨re 'A' la valeur 2, au caractÃ¨re 'B' la valeur 1 et au caractÃ¨re 'C' la valeur 1.
	 */
	public static Map<Character, Long> countByFirstCharacter(List<String> list){
		return list.stream()
		    .collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.counting()));
	}

	/**
	 * Renvoie la liste de String privÃ©e de son premier Ã©lÃ©ment.
	 * Indication : utilisez Stream.skip.
	 */

	public static List<String> withoutFirstElement(List<String> list){
		return list.stream()
		    .skip(1)
		    .toList();
	}

	/**
	 * Renvoie la liste de T privÃ©e de son premier Ã©lÃ©ment.
	 * Maintenant cette mÃ©thode peut Ãªtre appliquÃ©e Ã  n'importe quel type de List
	 * List<Integer>, ...
	 */

	public static <T> List<T> withoutFirstElementBetter(List<T> list){
		return list.stream()
		    .skip(1)
		    .toList();
	}

	/**
	 * Renvoie la liste des mots de la chaÃ®ne prise en argument.
	 * Par exemple, words("Abc def   i") renvoie ["Abc","def","i"]
	 * Indication : utilisez String.split() et Ã©liminez les chaÃ®nes vides.
	 */

	public static List<String> words(String s){
		return Arrays.stream(s.split("\\s+"))
		    .toList();
	}

	/**
	 * Renvoie l'ensemble des mots apparaissant dans la liste de chaÃ®nes prise en argument.
	 * Par example, words(List.of("Abc def i","def i","Abc de")) renvoie l'ensemble
	 * {"Abc","def","i","de"}.
	 * Indication : utilisez Stream.flatmap.
	 */

	public static Set<String> words(List<String> list){
		return list.stream()
		    .flatMap(s -> Arrays.stream(s.split("\\s+")))
		    .collect(Collectors.toSet());
	}

	/**
	 * Renvoie l'ensemble des chaÃ®nes apparaissant dans la liste d'Optional<String> prise en argument.
	 * Par exemple, unpack(List.of(Optional.empty(),Optional.of("A"),Optional.of("B"),Optional.of("A"))) renvoie
	 * l'ensemble {"A","B"}.
	 *
	 * Indication : les Optional peuvent Ãªtre transformÃ©s en Stream avec Optional.stream().
	 */

	public static Set<String> unpack(List<Optional<String>> list){
		return list.stream()
		    .filter(o -> o.isPresent())
		    .map(o -> o.orElse(""))
		    .collect(Collectors.toSet());
	}

	/**
	 * Renvoie une Map comptant le nombre d'occurences de chaque caractÃ¨re dans la chaÃ®ne.
	 * Par exemple, occurrences("ABBAAABBB") renvoie la map qui associe au caractÃ¨re 'A' la valeur
	 * 4 et au caractÃ¨re 'B' la valeur 5.
	 *
	 * Indication : vous pouvez utiliser s.chars().mapToObj( c-> (char) c) obtenir un Stream<Character> Ã  partir d'une chaÃ®ne.
	 */

	public static Map<Character,Long> occurrences(String s){
		return s.chars().mapToObj(c -> (char) c)
		    .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
	}

	public static void main(String[] args) {
		System.out.println(listIntegerToString(List.of(5,6,7,9)));
		System.out.println(sumLength(List.of("ABC","DE","","F")));
		String[] tab = {"ABC","DE","","F"};
		System.out.println(countNonEmpty(tab));
		int[] tab2 = {2,3};
		System.out.println(sum(tab2));
		System.out.println(capitalizeList(List.of("bonjour","aurevoir")));
		System.out.println(mapByFirstCharacter(List.of("AB","A","BA","C")));
		System.out.println(countByFirstCharacter(List.of("AB","A","BA","C")));
		System.out.println(unpack(List.of(Optional.empty(),Optional.of("A"),Optional.of("B"),Optional.of("A"))));
		System.out.println(withoutFirstElement(List.of("A","B","C")));
		System.out.println(withoutFirstElementBetter(List.of(1,2,4)));
		System.out.println(words("Abc def   i"));
		System.out.println(words(List.of("Abc def i","def i","Abc de")));
		System.out.println(unpack(List.of(Optional.empty(),Optional.of("A"),Optional.of("B"),Optional.of("A"))));
		System.out.println(occurrences("AABBBAABB"));

	}
}