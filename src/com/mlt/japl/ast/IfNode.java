package com.mlt.japl.ast;

import java.util.List;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.IntArray;
import com.mlt.japl.newarrays.concrete.IntScalar;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.workspace.EvalContext;

public class IfNode implements AstNode {

	private AstNode elseBranch;
	private AstNode thenBranch;
	private AstNode cond;
	private List<AstNode> elseIfs;
	private List<AstNode> thenBranches;

	public IfNode(AstNode cond, AstNode thenBranch, AstNode elseBranch, List<AstNode> elseIfs, List<AstNode> thenBranches) {
		this.cond = cond;
		this.thenBranch = thenBranch;
		this.elseBranch = elseBranch;
		this.elseIfs = elseIfs;
		this.thenBranches = thenBranches;
		
	}
	
	@Override
	public IValue eval(EvalContext context) {
		IValue cond_result = cond.eval(context);
		if(cond_result.equals(new IntScalar(1))) {
			return thenBranch.eval(context);
		} else {
			for(int i=0; i<elseIfs.size(); i++) {
				cond_result = elseIfs.get(i).eval(context);
				if(cond_result.equals(new IntScalar(1))) {
					return thenBranches.get(i).eval(context);
				}
			}
			if(elseBranch!=null)
				return elseBranch.eval(context);
			else
				return new IntArray(Dimensions.EMPTY_ARRAY, new long[0]);			
		}
	}

	@Override
	public String print() {
		String e = "";
		if(elseBranch!=null)
			e = " else {" + elseBranch.print() + " }";
		return "if(" + cond.print() + ") {" + thenBranch.print() + "}" + e;
	}
}
