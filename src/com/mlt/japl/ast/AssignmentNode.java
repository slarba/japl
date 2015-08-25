package com.mlt.japl.ast;

import java.io.PrintWriter;

import com.mlt.japl.arrays.IntArrayImpl;
import com.mlt.japl.iface.Array;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.IntArray;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.workspace.EvalContext;

public class AssignmentNode implements AstNode {

	private AstNode expr;
	private String id;

	public AssignmentNode(String id, AstNode expr) {
		this.id = id;
		this.expr = expr;
	}
	
	@Override
	public IValue eval(EvalContext context) {
		if(id.equals("\u2395")) {
			IValue result = expr.eval(context);
			PrintWriter w = new PrintWriter(context.getOutputStream());
			w.println(result.asString(context.printConfig()));
			w.flush();
			return result;
		}
		if(expr instanceof NiladicCallNode) {
			NiladicCallNode n = (NiladicCallNode)expr;
			context.set(id, n.func());
			return new IntArray(Dimensions.EMPTY_ARRAY, new long[0]);
		}
		return context.set(id, expr.eval(context));
	}

	@Override
	public String print() {
		return id + " <- " + expr.print();
	}
}
