package fr.uge.cmdLine2;

import java.util.Objects;

public record Plain(String text) implements Argument {
  public Plain {
    Objects.requireNonNull(text, "The argument text can't be null!");
  }
}
