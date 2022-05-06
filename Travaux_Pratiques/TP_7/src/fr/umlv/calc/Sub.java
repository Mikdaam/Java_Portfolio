package fr.umlv.calc;

import java.util.Objects;

public record Sub(Expr leftExpr, Expr rightExpr) implements BinaryOp {
	public Sub {
		Objects.requireNonNull(leftExpr, "leftExpr can't be null");
		Objects.requireNonNull(rightExpr, "rightExpr can't be bull");
	}

	@Override
	public int operator(int leftValue, int rightValue) {
		return leftValue - rightValue;
	}

	@Override
	public StringBuilder stringify(StringBuilder buffer) {
		return buffer.append("(").append(leftExpr.stringify(buffer))
				.append("-")
				.append(rightExpr.stringify(buffer))
				.append(")");
	}
}