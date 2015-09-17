package com.mlt.japl.ast;

import com.mlt.japl.arrays.IntArrayImpl;
import com.mlt.japl.errors.SyntaxError;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.IntArray;
import com.mlt.japl.newfns.Func;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.workspace.EvalContext;

public class NiladicCallNode implements AstNode {

	private Func fn;

	public NiladicCallNode(Func fn) {
		this.fn = fn;
		if(!(fn instanceof UserFnNode)) throw new SyntaxError();
	}
	
	@Override
	public IValue eval(EvalContext context) {
		return fn.applyNiladic(0);
	}

	@Override
	public String print() {
		return fn.getName() + "(<niladic>)";
	}

	public Func func() {
		return fn;
	}
}
