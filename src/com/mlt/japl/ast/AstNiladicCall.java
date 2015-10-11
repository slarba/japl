package com.mlt.japl.ast;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.FuncValue;
import com.mlt.japl.workspace.EvalContext;

/**
 * Created by markolau on 11/10/15.
 */
public class AstNiladicCall implements AstNode {
    private AstFunc func;

    public AstNiladicCall(AstFunc func) {
        this.func = func;
    }

    @Override
    public IValue eval(EvalContext context) {
        FuncValue val = (FuncValue)func.eval(context);
        return val.get().applyNiladic(0);
    }
}
