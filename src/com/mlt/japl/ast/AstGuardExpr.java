package com.mlt.japl.ast;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.IntScalar;
import com.mlt.japl.workspace.EvalContext;

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
