package com.mlt.japl.ast;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.workspace.EvalContext;

public class AstAssignment implements AstNode {

    private String id;
    private AstNode expr;

    public AstAssignment(String text, AstNode expr) {
        this.id = text;
        this.expr = expr;
    }

    @Override
    public String toString() {
        return id + " <- " + expr;
    }

    @Override
    public IValue eval(EvalContext context) {
        return context.set(id, expr.eval(context)).get();
    }
}