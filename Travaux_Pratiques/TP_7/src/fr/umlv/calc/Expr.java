package fr.umlv.calc;

import java.util.Iterator;
import java.util.Scanner;

public sealed interface Expr permits BinaryOp, Value {
	public int eval();
	
	public StringBuilder stringify();
	
	// 4. sealed the interface to solve the issue
	
	static Expr parse(Iterator<String> tokens) {
		
		/*if (!tokens.hasNext()) {
			return 
		}*/
		
		var token = tokens.next();
		return switch (token) {
			case "+" -> new Add(parse(tokens), parse(tokens));
			case "-" -> new Sub(parse(tokens), parse(tokens));
			case "*" -> new Mul(parse(tokens), parse(tokens));
			default -> new Value(Integer.parseInt(token));
		};	
	}
	
}
