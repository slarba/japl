package com.mlt.japl.ast;

import com.mlt.japl.iface.Array;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.workspace.EvalContext;

public interface AstNode {
	IValue eval(EvalContext context);
	String print();
//
//	int resultTypeFor(Array a);
//	int resultTypeFor(Array a, Array b);
//	Dimensions resultDimsFor(Array a, int axis);
//	Dimensions resultDimsFor(Array a, Array b, int axis);
}
