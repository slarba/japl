package com.mlt.japl.ast;

import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.iface.Array;
import com.mlt.japl.scalars.IntScalar;
import com.mlt.japl.workspace.EvalContext;

public class IfNode implements AstNode {

	private AstNode elseBranch;
	private AstNode thenBranch;
	private AstNode cond;

	public IfNode(AstNode cond, AstNode thenBranch, AstNode elseBranch) {
		this.cond = cond;
		this.thenBranch = thenBranch;
		this.elseBranch = elseBranch;
		
	}
	
	@Override
	public Array eval(EvalContext context) {
		Array cond_result = cond.eval(context);
		if(cond_result.equals(new IntScalar(1))) {
			return thenBranch.eval(context);
		}
		if(elseBranch!=null)
			return elseBranch.eval(context);
		else
			return new IntArray();
	}

	@Override
	public String print() {
		String e = "";
		if(elseBranch!=null)
			e = " else {" + elseBranch.print() + " }";
		return "if(" + cond.print() + ") {" + thenBranch.print() + "}" + e;
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

}
