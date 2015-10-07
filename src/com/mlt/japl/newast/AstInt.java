package com.mlt.japl.newast;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.IntScalar;
import com.mlt.japl.workspace.EvalContext;

public class AstInt extends AstNode {

	private long value;

	public AstInt(String text) {
		value = Long.parseLong(text);
	}

	@Override
	public String toString() {
		return Long.toString(value);
	}

	@Override
	public IValue eval(EvalContext context) {
		return new IntScalar(value);
	}
}
