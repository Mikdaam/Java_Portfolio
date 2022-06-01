package fr.uge.cmdLine1;

import java.util.Optional;

public enum OptionInfo {
  ALL, VERBOSE;
  
  public static Optional<OptionInfo> asOptionInfo(String optionText) {
    return switch (optionText) {
      case "-v", "--verbose" -> Optional.of(VERBOSE);
      case "-a", "-all" -> Optional.of(ALL);
      default -> Optional.empty();
    };
  }
}