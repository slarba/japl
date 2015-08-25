package com.mlt.japl.ast;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.IntArray;
import com.mlt.japl.newarrays.concrete.IntScalar;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.workspace.EvalContext;

public class WhileNode implements AstNode {

	private AstNode cond;
	private AstNode body;

	public WhileNode(AstNode cond, AstNode body) {
		this.cond = cond;
		this.body = body;
	}
	
	@Override
	public IValue eval(EvalContext context) {
		IValue trueVal = new IntScalar(1);
		while(cond.eval(context).equals(trueVal)) {
			body.eval(context);
		}
		return new IntArray(Dimensions.EMPTY_ARRAY, new long[0]);
	}

	@Override
	public String print() {
		return "while(" + cond.print() + ") { " + body.print() + " }";
	}
}
