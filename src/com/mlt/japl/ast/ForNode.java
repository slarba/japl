package com.mlt.japl.ast;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.IntArray;
import com.mlt.japl.workspace.EvalContext;

public class ForNode implements AstNode {

	private String var;
	private AstNode expr;
	private AstNode body;

	public ForNode(String var, AstNode expr, AstNode body) {
		this.var = var;
		this.expr = expr;
		this.body = body;
	}
	
	@Override
	public IValue eval(EvalContext context) {
		IValue result = expr.eval(context);
		EvalContext derived = context.newFrame();

		IValue last = IntArray.EMPTY;
		for(int i=0; i<result.length(); i++) {
			derived.set(var, result.getGeneric(i));
			last = body.eval(derived);
		}
		return last;
	}

	@Override
	public String print() {
		return "for(" + var + " in " + expr.print() + ") {" + body.print() + "}";
	}

}
