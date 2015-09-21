package com.mlt.japl.ast;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.workspace.EvalContext;

public interface AstNode {
	IValue eval(EvalContext context);
	String print();
}
