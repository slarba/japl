package com.mlt.japl.ast;

import java.util.List;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.workspace.EvalContext;

public class StatementListNode implements AstNode {

	private List<AstNode> statements;

	public StatementListNode(List<AstNode> statements) {
		this.statements = statements;
	}
	
	@Override
	public IValue eval(EvalContext context) {
		IValue last = null;
		for(int i=0; i<statements.size(); i++) {
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

//	@Override
//	public int resultTypeFor(Array a) {
//		return 0;
//	}
//
//	@Override
//	public int resultTypeFor(Array a, Array b) {
//		return 0;
//	}
//
//	@Override
//	public Dimensions resultDimsFor(Array a, int axis) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Dimensions resultDimsFor(Array a, Array b, int axis) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
}
