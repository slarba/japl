package com.mlt.japl.newast;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.workspace.EvalContext;

public class AstAssignment extends AstNode {

	private String id;
	private AstNode expr;

	public AstAssignment(String text, AstNode expr) {
		this.id = text;
		this.expr = expr;
	}

	@Override
	public String toString() {
		return id + " <- " + expr;
	}

	@Override
	public IValue eval(EvalContext context) {
		return null;
	}
}
