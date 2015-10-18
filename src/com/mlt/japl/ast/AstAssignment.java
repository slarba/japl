package com.mlt.japl.ast;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.workspace.EvalContext;

public class AstAssignment implements AstNode {

    private String id;
    private AstNode expr;

    public AstAssignment(String id, AstNode expr) {
        this.id = id;
        this.expr = expr;
    }

    @Override
    public String toString() {
        return id + " <- " + expr;
    }

    @Override
    public IValue eval(EvalContext context) {
        IValue v = expr.eval(context);
        return context.set(id, v.force()).get();
    }
}
