package com.mlt.japl.newast;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.workspace.EvalContext;

public abstract class AstNode {
	protected String indent(String prefix, String s) {
		String[] parts = s.split("\n");
		StringBuilder builder = new StringBuilder();
		for(String p : parts) {
			builder.append(prefix + p + "\n");
		}
		return builder.toString();
	}

	public abstract IValue eval(EvalContext context);
}
