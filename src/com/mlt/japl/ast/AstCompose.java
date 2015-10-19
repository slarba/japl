package com.mlt.japl.ast;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.FuncValue;
import com.mlt.japl.fns.ComposeOperator;
import com.mlt.japl.workspace.EvalContext;

/**
 * Created by markolau on 20/10/15.
 */
public class AstCompose extends AstFunc {
    private AstFunc l;
    private AstFunc r;

    public AstCompose(AstFunc l, AstFunc r) {

        this.l = l;
        this.r = r;
    }

    @Override
    public IValue eval(EvalContext context) {
        FuncValue left = (FuncValue)l.eval(context);
        FuncValue right = (FuncValue)r.eval(context);
        return new FuncValue(new ComposeOperator(left.get(), right.get()));
    }
}
