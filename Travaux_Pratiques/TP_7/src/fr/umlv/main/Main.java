/**
 * 
 * @author Mick Cool
 */

package fr.umlv.main;

import java.util.Scanner;
import fr.umlv.calc.Expr;

public class Main {
	public static void main(String[] args) {
		//Expr expression = new Add(new Value(2), new Value(3));
		//Expr expression2 = new Sub(new Mul(new Value(2), new Value(3)), new Value(4));
		System.out.println("Welcome in calculation with tree\n");
		var input = new Scanner(System.in);
		var mainExpr = Expr.parse(input);
		
		var buffer = new StringBuilder();
		System.out.println(mainExpr.stringify(buffer).toString() + " = " + mainExpr.eval());
	}
}
