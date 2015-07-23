package com.mlt.japl.ast;

import com.mlt.japl.errors.AxisError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.iface.Func;
import com.mlt.japl.workspace.EvalContext;


public class DyadicCallNode implements AstNode {

	private AstNode left;
	private AstNode right;
	private Func fn;
	private AstNode axisExpr;

	public DyadicCallNode(Func fn, AstNode left, AstNode right, AstNode axisExpr) {
		this.left = left;
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
		return fn.dyadic(left.eval(context), right.eval(context), axis);  // TODO: axis expr eval
	}

	@Override
	public String print() {
		String axis = "";
		if(axisExpr!=null) {
			axis = "[" + axisExpr.print() + "]";
		}
		return fn.getName() + axis + "(" + left.print() + ","  + right.print() + ")";
	}

	public AstNode getLeft() {
		return left;
	}

	public AstNode getRight() {
		return right;
	}
}
