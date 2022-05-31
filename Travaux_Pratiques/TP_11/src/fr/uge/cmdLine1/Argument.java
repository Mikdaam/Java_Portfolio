package fr.uge.cmdLine1;

import java.util.Objects;

public class Argument {
  final String text;
  
  public Argument(String text) {
    this.text = Objects.requireNonNull(text, "The argument text can't be null!");
  }
  
  public boolean isOption() {
    return false;
  }
  
  @Override
  public String toString() {
    return "Argument{ text:'"+ text+"' }";
  }

  @Override
  public boolean equals(Object obj) {    
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    var other = (Argument) obj;
    return Objects.equals(text, other.text);
  }  
  
}
