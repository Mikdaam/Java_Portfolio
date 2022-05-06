package fr.umlv.calc;

import java.util.Objects;

public record Add(Expr leftExpr, Expr rightExpr) implements BinaryOp {
	public Add {
		Objects.requireNonNull(leftExpr, "leftExpr can't be null");
		Objects.requireNonNull(rightExpr, "rightExpr can't be bull");
	}

	@Override
	public int operator(int leftValue, int rightValue) {
		return leftValue + rightValue;
	}
	
	@Override
	public StringBuilder stringify() {
		return new StringBuilder().append("(").append(leftExpr.stringify())
				.append(" + ")
				.append(rightExpr.stringify())
				.append(")");
	}
}
