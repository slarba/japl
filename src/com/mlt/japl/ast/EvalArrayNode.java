package com.mlt.japl.ast;

import java.util.List;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.MixedArray;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.workspace.EvalContext;

public class EvalArrayNode implements AstNode {

	private List<AstNode> nodes;

	public EvalArrayNode(List<AstNode> nodes) {
		this.nodes = nodes;
	}

	@Override
	public IValue eval(EvalContext context) {
		if(nodes.size()==1) {
			return nodes.get(0).eval(context);
		}
		IValue[] result = new IValue[nodes.size()];
		for(int j=nodes.size()-1; j>=0; j--) {
			result[j] = nodes.get(j).eval(context);
		}
		return new MixedArray(new Dimensions(result.length), result);
	}

	@Override
	public String print() {
		StringBuilder builder = new StringBuilder();
		int i=0;
		int length = nodes.size();
		for(AstNode a : nodes) {
			builder.append(a.print());
			i++;
			if(i!=length)
				builder.append(',');
		}
		return "evalarray[" + builder.toString() + "]";
	}
}
