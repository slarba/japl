package com.mlt.japl.ast;

import com.mlt.japl.errors.AxisError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.iface.Func;
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
	public Array eval(EvalContext context) {
		int axis = -1;
		if(axisExpr!=null) {
			Array ax = axisExpr.eval(context);
			if(ax.rank()>0) throw new AxisError();
			axis = (int)ax.atI(0)-1;
			if(axis<0) throw new AxisError();
		}
		return fn.monadic(right.eval(context), axis);
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

}
