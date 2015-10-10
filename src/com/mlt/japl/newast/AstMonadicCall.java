package com.mlt.japl.newast;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.FuncValue;
import com.mlt.japl.workspace.EvalContext;

public class AstMonadicCall implements AstNode {

    private AstFunc func;
    private AstNode right;

    public AstMonadicCall(AstFunc func, AstNode right) {
        this.func = func;
        this.right = right;
    }

    @Override
    public String toString() {
        return func + "(" + right + ")";
    }

    @Override
    public IValue eval(EvalContext context) {
        FuncValue fn = (FuncValue)func.eval(context);
        return fn.get().applyMonadic(right.eval(context), 0);
    }
}
