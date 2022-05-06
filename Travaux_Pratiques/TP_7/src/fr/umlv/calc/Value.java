package fr.umlv.calc;

public record Value(int value) implements Expr {

	@Override
	public int eval() {
		return value;
	}

	@Override
	public StringBuilder stringify(StringBuilder buffer) {
		return buffer.append(value);
	}
}
