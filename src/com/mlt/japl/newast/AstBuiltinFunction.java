package com.mlt.japl.newast;

public class AstBuiltinFunction extends AstFunc {

	private String fn;

	public AstBuiltinFunction(String text) {
		fn = text;
	}

	@Override
	public String toString() {
		return fn;
	}
}
