package com.mlt.japl.ast;

import com.mlt.japl.errors.AxisError;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.interf.IIntScalar;
import com.mlt.japl.newfns.Func;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.workspace.EvalContext;

public class MonadicCallNode implements AstNode {
	private AstNode right;
	private Func fn;
	private AstNode axisExpr;
	
	public MonadicCallNode(Func fn, AstNode right, AstNode axisExpr) {
		this.right = right;
		this.fn = fn;
		this.axisExpr = axisExpr;
	}
	
	@Override
	public IValue eval(EvalContext context) {
		int axis = -1;
		if(axisExpr!=null) {
			IValue ax = axisExpr.eval(context);
			if(ax.rank()>0) throw new AxisError();
			axis = (int)((IIntScalar)ax).get()-1;
			if(axis<0) throw new AxisError();
		}
		return fn.applyMonadic(right.eval(context), axis);
	}

	@Override
	public String print() {
		String axis = "";
		if(axisExpr!=null) {
			axis = "[" + axisExpr.print() + "]";
		}
		return fn.getName() + axis + "(" + right.print() + ")";
	}

	public AstNode getRight() {
		return right;
	}

//	@Override
//	public int resultTypeFor(Array a) {
//		return fn.resultTypeFor(a);
//	}
//
//	@Override
//	public int resultTypeFor(Array a, Array b) {
//		return fn.resultTypeFor(a, b);
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
