package com.mlt.japl.ast;

import com.mlt.japl.errors.ValueError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.workspace.EvalContext;

public class IdentifierNode implements AstNode {

	private AstNode expr;
	private String id;

	public IdentifierNode(String id, AstNode indexExpr) {
		this.expr = indexExpr;
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	@Override
	public Array eval(EvalContext context) {
		if(context==null) {
			throw new ValueError();
		}
		return context.get(id);
	}

	@Override
	public String print() {
		return (id!=null ? id : "<?>") + (expr!=null ? ("[" + expr.print() + "]") : "");
	}

	public AstNode getIndexExpr() {
		return expr;
	}

}
