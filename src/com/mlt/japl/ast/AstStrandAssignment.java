package com.mlt.japl.ast;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.workspace.EvalContext;

import java.util.Arrays;

public class AstStrandAssignment implements AstNode {

    private String[] tids;
    private AstNode expr;

    public AstStrandAssignment(String[] tids, AstNode expr) {
        this.tids = tids;
        this.expr = expr;
    }

    @Override
    public String toString() {
        return Arrays.toString(tids) + " <- " + expr;
    }

    @Override
    public IValue eval(EvalContext context) {
        IValue right = expr.eval(context);
        for(int i=0; i<tids.length; i++) {
            context.set(tids[i], right.getGeneric(i));
        }
        return right;
    }
}
