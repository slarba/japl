package com.mlt.japl.newast;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.workspace.EvalContext;

import java.util.Arrays;

public class AstStrandAssignment extends AstNode {

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
        return null;
    }
}
