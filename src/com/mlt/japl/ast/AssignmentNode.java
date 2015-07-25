package com.mlt.japl.ast;

import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.iface.Array;
import com.mlt.japl.iface.Func;
import com.mlt.japl.workspace.EvalContext;

public class AssignmentNode implements AstNode {

	private AstNode expr;
	private String id;

	public AssignmentNode(String id, AstNode expr) {
		this.id = id;
		this.expr = expr;
	}
	
	@Override
	public Array eval(EvalContext context) {
		if(expr instanceof NiladicCallNode) {
			NiladicCallNode n = (NiladicCallNode)expr;
			context.set(id, n.func());
			return new IntArray();
		}
		return context.set(id, expr.eval(context));
	}

	@Override
	public String print() {
		return id + " <- " + expr.print();
	}

}
