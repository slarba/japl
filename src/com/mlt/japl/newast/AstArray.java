package com.mlt.japl.newast;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.MixedArray;
import com.mlt.japl.newarrays.interf.IMixedArray;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.workspace.EvalContext;

public class AstArray extends AstNode {

	private AstNode[] items;

	public AstArray(AstNode[] result) {
		items = result;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[[");
		for(int i=0; i<items.length; i++) {
			builder.append(items[i].toString());
			if(i<items.length-1) builder.append(',');
		}
		builder.append("]]");
		return builder.toString();
	}

	@Override
	public IValue eval(EvalContext context) {
		IValue[] vals = new IValue[items.length];
		for(int i=0; i<vals.length; i++) {
			vals[i] = items[i].eval(context);
		}
		return new MixedArray(new Dimensions(vals.length), vals).force();
	}
}
