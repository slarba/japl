package com.mlt.japl.newast;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.workspace.EvalContext;

public class AstDyadicCall implements AstNode {

    private AstFunc fn;
    private AstNode l;
    private AstNode r;

    public AstDyadicCall(AstFunc fn, AstNode l, AstNode r) {
        this.fn = fn;
        this.l = l;
        this.r = r;
    }

    @Override
    public String toString() {
        return fn + "(" + l + "," + r + ")";
    }

    @Override
    public IValue eval(EvalContext context) {
        IValue right = r.eval(context);
        IValue left = l.eval(context);
        return fn.applyDyadic(left,right,0);
    }
}
