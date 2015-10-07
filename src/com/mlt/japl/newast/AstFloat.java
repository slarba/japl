package com.mlt.japl.newast;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.DoubleScalar;
import com.mlt.japl.workspace.EvalContext;

public class AstFloat extends AstNode {

	private double value;

	public AstFloat(String text) {
		value = Double.parseDouble(text);
	}

	public String toString() {
		return Double.toString(value);
	}

	@Override
	public IValue eval(EvalContext context) {
		return new DoubleScalar(value);
	}
}
