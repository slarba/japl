package com.mlt.japl.ast;

import java.util.List;

import com.mlt.japl.iface.Array;
import com.mlt.japl.workspace.EvalContext;

public class StatementListNode implements AstNode {

	private List<AstNode> statements;

	public StatementListNode(List<AstNode> statements) {
		this.statements = statements;
	}
	
	@Override
	public Array eval(EvalContext context) {
		Array last = null;
		for(int i=statements.size()-1; i>=0; i--) {
			last = statements.get(i).eval(context);
		}
		return last;
	}

	@Override
	public String print() {
		StringBuilder stmts = new StringBuilder();
		boolean first = true;
		for(AstNode n : statements) {
			if(!first) stmts.append(';');
			stmts.append(n.print());
			first = false;
		}
		return "statementlist[" +stmts.toString() + "]";
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
