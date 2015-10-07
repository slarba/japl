package com.mlt.japl.newast;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.CharArray;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.workspace.EvalContext;

public class AstString extends AstNode {

	private String text;

	public AstString(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}

	@Override
	public IValue eval(EvalContext context) {
		String t = text.substring(1, text.length()-1);
		return new CharArray(t);
	}
}
