package com.mlt.japl.ast;

import com.mlt.japl.errors.IndexError;
import com.mlt.japl.errors.ValueError;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.interf.IMixedArray;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.workspace.EvalContext;
import com.mlt.japl.workspace.Var;

public class IdentifierNode implements AstNode {

	private AstNode expr;
	private String id;
	private Var var;
	
	public IdentifierNode(String id, AstNode indexExpr) {
		this.expr = indexExpr;
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	@Override
	public IValue eval(EvalContext context) {
		if(context==null) {
			throw new ValueError();
		}
		IValue val;
		if(var!=null) {
			val = var.get();
		} else {
			var = context.get(id);
			val = var.get();
		}
		if(expr!=null) {
			IMixedArray i = (IMixedArray)expr.eval(context);
			return val.get(i);
		}
		return val;
	}

	@Override
	public String print() {
		return (id!=null ? id : "<?>") + (expr!=null ? ("[" + expr.print() + "]") : "");
	}

	public AstNode getIndexExpr() {
		return expr;
	}
}
