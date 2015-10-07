package com.mlt.japl.newast;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.workspace.EvalContext;

public class AstIndex implements AstNode {

    private AstNode expr;
    private AstNode indexexpr;

    public AstIndex(AstNode str, AstNode visit) {
        this.expr = str;
        this.indexexpr = visit;
    }

    @Override
    public String toString() {
        return expr + "[" + indexexpr + "]";
    }

    @Override
    public IValue eval(EvalContext context) {
        return null;
    }
}
