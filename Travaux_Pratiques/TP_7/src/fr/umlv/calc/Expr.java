package fr.umlv.calc;

import java.util.Iterator;

public sealed interface Expr permits BinaryOp, Value {
	public int eval();
	
	public StringBuilder stringify();
		
	static Expr parse(Iterator<String> tokens) {
		var token = tokens.next();
		return switch (token) {
			case "+" -> new Add(parse(tokens), parse(tokens));
			case "-" -> new Sub(parse(tokens), parse(tokens));
			case "*" -> new Mul(parse(tokens), parse(tokens));
			default -> new Value(Integer.parseInt(token));
		};	
	}
}
