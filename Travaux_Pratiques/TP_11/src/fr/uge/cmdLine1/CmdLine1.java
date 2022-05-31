package fr.uge.cmdLine1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CmdLine1 {
  public static void main(String[] args) {
    // 1
    var argument1 = new Argument("foo.txt");
    var argument2 = new Argument("bar.png");
    System.out.println(argument1);  // Argument{ text:'foo.txt' }
    System.out.println(argument2);  // Argument{ text:'bar.png' }
    
    // 2
    List<Argument> arguments1 = parseCmdLine("foo.txt", "bar.png");
    System.out.println(arguments1);  // [Argument{ text:'foo.txt' }, Argument{ text:'bar.png' }]
    
    // 3
    var option1 = new Option("--verbose", OptionInfo.VERBOSE);
    var option2 = new Option("-v", OptionInfo.VERBOSE);
    System.out.println(option1);  // Option{ text: '--verbose', info: VERBOSE }
    System.out.println(option2);  // Option{ text: '-v', info: VERBOSE }
    
    // 4 & 5
    var arguments2 = parseCmdLine("-v", "bar.png");
    System.out.println(arguments2);  // [Option{ text: '-v', info: VERBOSE }, Argument{ text:'bar.png' }]
    
    // 6
    var arguments3 = parseCmdLine("-v", "bar.png", "--verbose");
    //checkCmdLine(arguments3);  // java.lang.IllegalArgumentException: duplicate argument Option{ text: '--verbose', info: VERBOSE }
    
    // 7
    var argument3 = new Argument("-v");
    var option3 = new Option("-v", OptionInfo.VERBOSE);
    System.out.println(argument3.equals(argument3));  // true
    System.out.println(argument3.equals(option3));    // false
    System.out.println(option3.equals(option3));      // true
    System.out.println(option3.equals(argument3));    // false
   
    // 8
    var arguments4 = parseCmdLine("-v", "bar.png", "bar.png");
    checkCmdLine(arguments4);  // ok ! 
  }

  private static List<Argument> parseCmdLine(String ...argumentsText) {
    var argumentList = new ArrayList<Argument>();
    for (var argumentText : argumentsText) {
      /* A revoir et comprendre */
      var argument = OptionInfo.asOptionInfo(argumentText).<Argument>map(info -> new Option(argumentText, info)).orElseGet(() -> new Argument(argumentText));
      /*if (info != null) {
        argumentList.add(new Option(argumentText, info));
      } else {
        argumentList.add(new Argument(argumentText));        
      }*/
      argumentList.add(argument);
    }
    
    return argumentList;
  }
  
  private static boolean isOption(Argument argument) {
    return switch (argument) {
      case Argument a -> false;
    
    
    
      default -> throw new IllegalArgumentException("Unexpected value: " + argument);
    };
  }
  
  private static void checkCmdLine(List<Argument> arguments) {
    var checkArgument = new HashSet<Argument>(); 
    for (var argument : arguments) {
      if (argument.isOption() && !checkArgument.add(argument)) {
        throw new IllegalArgumentException("duplicate argument " + argument);
      }
    }
    System.out.println("ok !");
  }
}
