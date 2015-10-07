package com.mlt.japl.ast;

import com.mlt.japl.errors.DomainError;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.IntArray;
import com.mlt.japl.newarrays.interf.IIntScalar;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.workspace.EvalContext;

public class RepeatNode implements AstNode {

	private AstNode count;
	private AstNode body;

	public RepeatNode(AstNode count, AstNode body) {
		this.count = count;
		this.body = body;
	}
	
	@Override
	public IValue eval(EvalContext context) {
		IIntScalar c = (IIntScalar)count.eval(context);
		for(long i=0; i<c.get(); i++) {
			body.eval(context);
		}
		return new IntArray(Dimensions.EMPTY_ARRAY, new long[0]);
	}

	@Override
	public String print() {
		return "repeat(" + count.print() + ") { " + body.print() + " }";
	}

}
