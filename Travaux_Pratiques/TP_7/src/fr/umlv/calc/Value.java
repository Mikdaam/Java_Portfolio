package fr.umlv.calc;

public record Value(int value) implements Expr {

	@Override
	public int eval() {
		return value;
	}

	@Override
	public StringBuilder stringify() {
		return new StringBuilder().append(value);
	}
}
