package com.mlt.japl.ast;

import com.mlt.japl.iface.Array;
import com.mlt.japl.workspace.EvalContext;

public interface AstNode {
	Array eval(EvalContext context);
	String print();
}
