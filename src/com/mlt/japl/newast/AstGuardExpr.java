package com.mlt.japl.newast;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.IntScalar;
import com.mlt.japl.workspace.EvalContext;
import com.sun.org.apache.bcel.internal.generic.RETURN;

public class AstGuardExpr implements AstNode {

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
        IValue condVal = condition.eval(context);
        if(condVal.equals(IntScalar.ONE)) throw new ReturnSignal(result.eval(context));
        return null;
    }
}
