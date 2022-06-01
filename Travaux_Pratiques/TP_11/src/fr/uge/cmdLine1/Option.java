package fr.uge.cmdLine1;

import java.util.Objects;

public final class Option extends Argument {
  private final OptionInfo info;
  public Option(String text, OptionInfo info) {
    super(text);
    this.info = Objects.requireNonNull(info, "The type info of argument can't be null.");
  }
  
  public boolean isOption() {
    return true;
  }
  
  @Override
  public String toString() {
    return "Option{ text:'"+ text+"', info: "+info+" }";
  }

  @Override
  public boolean equals(Object obj) {    
    return obj instanceof Option option && super.equals(obj) && info.equals(option.info);
  }
  
}
