package com.mlt.japl.ast;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.interf.IMixedArray;
import com.mlt.japl.workspace.EvalContext;

public class ArrayIndexerNode implements AstNode {

	private AstNode arrayNode;
	private AstNode indexNode;

	public ArrayIndexerNode(AstNode arrayNode, AstNode indexNode) {
		this.arrayNode = arrayNode;
		this.indexNode = indexNode;
	}
	
	@Override
	public IValue eval(EvalContext context) {
		IMixedArray index = (IMixedArray)indexNode.eval(context);
		IValue val = arrayNode.eval(context);
		return val.get(index);
	}

	@Override
	public String print() {
		return "(" + arrayNode.print() + ")[" + indexNode.print() + "]";
	}

}
