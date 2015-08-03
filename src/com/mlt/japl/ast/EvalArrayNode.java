package com.mlt.japl.ast;

import java.util.List;

import com.mlt.japl.arrays.NestedArray;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.workspace.EvalContext;

public class EvalArrayNode implements AstNode {

	private List<AstNode> nodes;

	public EvalArrayNode(List<AstNode> nodes) {
		this.nodes = nodes;
	}

	@Override
	public Array eval(EvalContext context) {
		if(nodes.size()==1) {
			return nodes.get(0).eval(context);
		}
		Array[] result = new Array[nodes.size()];
		for(int j=nodes.size()-1; j>=0; j--) {
			result[j] = nodes.get(j).eval(context);
		}
		return new NestedArray(result);
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

	@Override
	public int resultTypeFor(Array a) {
		return Array.MIXED;
	}

	@Override
	public int resultTypeFor(Array a, Array b) {
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
