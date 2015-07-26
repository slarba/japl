package com.mlt.japl.ast;

import com.mlt.japl.iface.Array;
import com.mlt.japl.workspace.EvalContext;

public class IndexExprNode implements AstNode {

	private AstNode first;
	private IndexExprNode rest;

	public IndexExprNode(AstNode first, IndexExprNode rest) {
		this.first = first;
		this.rest = rest;
	}
	
	@Override
	public Array eval(EvalContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String print() {
		return (first!=null ? first.print() : "") + (rest!=null ? ";" + rest.print() : "");
	}

	@Override
	public int resultTypeFor(Array a) {
		return 0;
	}

	@Override
	public int resultTypeFor(Array a, Array b) {
		return 0;
	}

}
