package com.mlt.japl.ast;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.FuncValue;
import com.mlt.japl.fns.BoundFunc;
import com.mlt.japl.workspace.EvalContext;

/**
 * Created by markolau on 11/10/15.
 */
public class AstBoundFunc extends AstFunc {
    private AstNode left;
    private final AstFunc func;

    public AstBoundFunc(AstNode left, AstFunc func) {
        this.left = left;
        this.func = func;
    }

    @Override
    public IValue eval(EvalContext context) {
        IValue l = left.eval(context);
        FuncValue f = (FuncValue) func.eval(context);
        return new FuncValue(new BoundFunc(l, f.get()));
    }

    @Override
    public String toString() {
        return "" + left + " bound " + func;
    }
}
