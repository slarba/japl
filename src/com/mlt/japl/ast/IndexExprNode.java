package com.mlt.japl.ast;

import com.mlt.japl.iface.Array;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.workspace.EvalContext;

public class IndexExprNode implements AstNode {

	private AstNode first;
	private IndexExprNode rest;

	public IndexExprNode(AstNode first, IndexExprNode rest) {
		this.first = first;
		this.rest = rest;
	}
	
	@Override
	public IValue eval(EvalContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String print() {
		return (first!=null ? first.print() : "") + (rest!=null ? ";" + rest.print() : "");
	}
}
