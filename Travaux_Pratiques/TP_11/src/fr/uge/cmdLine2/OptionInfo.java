package fr.uge.cmdLine2;

import java.util.Optional;

public enum OptionInfo {
  ALL, VERBOSE;
  
  public static Optional<OptionInfo> asOptionInfo(String optionText) {
    return switch (optionText) {
      case "-v" -> Optional.ofNullable(VERBOSE);
      case "--verbose" -> Optional.ofNullable(VERBOSE);
      case "-a" -> Optional.ofNullable(ALL);
      case "-all" -> Optional.ofNullable(ALL);
      default -> Optional.empty();
    };
  }
}
