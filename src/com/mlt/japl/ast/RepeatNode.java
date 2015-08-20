package com.mlt.japl.ast;

import com.mlt.japl.arrays.IntArrayImpl;
import com.mlt.japl.errors.DomainError;
import com.mlt.japl.iface.Array;
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
	public Array eval(EvalContext context) {
		Array c = count.eval(context);
		if(!c.isScalar() || !c.isIntegral()) {
			throw new DomainError();
		}
		for(long i=0; i<c.atI(0); i++) {
			body.eval(context);
		}
		return new IntArrayImpl();
	}

	@Override
	public String print() {
		return "repeat(" + count.print() + ") { " + body.print() + " }";
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

	@Override
	public Dimensions resultDimsFor(Array a, int axis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimensions resultDimsFor(Array a, Array b, int axis) {
		// TODO Auto-generated method stub
		return null;
	}

}
