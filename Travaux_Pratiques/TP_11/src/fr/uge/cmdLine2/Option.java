package fr.uge.cmdLine2;

import java.util.Objects;

public record Option(String string, OptionInfo info) implements Argument {
  public Option {
    Objects.requireNonNull(info, "The type info of argument can't be null.");
  }
}
