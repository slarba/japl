package com.mlt.japl.ast;

import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.iface.Array;
import com.mlt.japl.scalars.IntScalar;
import com.mlt.japl.workspace.EvalContext;

public class WhileNode implements AstNode {

	private AstNode cond;
	private AstNode body;

	public WhileNode(AstNode cond, AstNode body) {
		this.cond = cond;
		this.body = body;
	}
	
	@Override
	public Array eval(EvalContext context) {
		Array trueVal = new IntScalar(1);
		while(cond.eval(context).equals(trueVal)) {
			body.eval(context);
		}
		return new IntArray();
	}

	@Override
	public String print() {
		return "while(" + cond.print() + ") { " + body.print() + " }";
	}

	@Override
	public int resultTypeFor(Array a) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int resultTypeFor(Array a, Array b) {
		// TODO Auto-generated method stub
		return 0;
	}

}