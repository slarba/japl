package com.mlt.japl.ast;

import java.io.PrintWriter;
import java.io.Writer;

import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.iface.Array;
import com.mlt.japl.iface.Func;
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
	public Array eval(EvalContext context) {
		if(id.equals("\u2395")) {
			Array result = expr.eval(context);
			PrintWriter w = new PrintWriter(context.getOutputStream());
			w.println(result.asString(context.printConfig()));
			w.flush();
			return result;
		}
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
