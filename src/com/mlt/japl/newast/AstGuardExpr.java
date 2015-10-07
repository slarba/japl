package com.mlt.japl.newast;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.workspace.EvalContext;

public class AstGuardExpr extends AstNode {

    private AstNode condition;
    private AstNode result;

    public AstGuardExpr(AstNode condition, AstNode result) {
        this.condition = condition;
        this.result = result;
    }

    @Override
    public String toString() {
        return "guard: " + condition + " => " + result;
    }

    @Override
    public IValue eval(EvalContext context) {
        return null;
    }
}
