package com.mlt.japl.ast;

import com.mlt.japl.iface.Array;
import com.mlt.japl.workspace.EvalContext;

public interface AstNode {
	Array eval(EvalContext context);
	String print();
	int resultTypeFor(Array a);
	int resultTypeFor(Array a, Array b);
}
