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
		return new IntArray(Dimensions.EMPTY_ARRAY, new long[0]);
	}

	@Override
	public String print() {
		return fn.getName() + "()";
	}

	public Func func() {
		return fn;
	}

//	@Override
//	public int resultTypeFor(Array a) {
//		return 0;
//	}
//
//	@Override
//	public int resultTypeFor(Array a, Array b) {
//		return 0;
//	}
//
//	@Override
//	public Dimensions resultDimsFor(Array a, int axis) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Dimensions resultDimsFor(Array a, Array b, int axis) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
}
