package fr.umlv.calc;

public sealed interface BinaryOp extends Expr permits Add, Sub, Mul {
	Expr leftExpr();
	Expr rightExpr();
	
	int operator(int leftValue, int rightValue);
	
	default int eval() {
		int leftValue = leftExpr().eval();
		int rightValue = rightExpr().eval();
		return operator(leftValue, rightValue);
	}
}
