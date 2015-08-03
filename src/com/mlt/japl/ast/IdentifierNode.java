package com.mlt.japl.ast;

import com.mlt.japl.errors.ValueError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;
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

	@Override
	public int resultTypeFor(Array a) {
		if(id.equals("\u03c9")) {
			return a.type();
		}
		return Array.MIXED;
	}

	@Override
	public int resultTypeFor(Array a, Array b) {
		if(id.equals("\u03b1")) {
			return a.type();
		}
		if(id.equals("\u03c9")) {
			return b.type();
		}
		return Array.MIXED;
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
