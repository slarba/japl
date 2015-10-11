package com.mlt.japl.ast;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.FuncValue;
import com.mlt.japl.fns.InnerProdFn;
import com.mlt.japl.workspace.EvalContext;

/**
 * Created by markolau on 07/10/15.
 */
public class AstInnerproduct extends AstFunc {
    private final AstFunc outer;
    private final AstFunc inner;

    public AstInnerproduct(AstFunc outer, AstFunc inner) {
        this.outer = outer;
        this.inner = inner;
    }

    @Override
    public String toString() {
        return "(" + outer.toString() + "." + inner.toString() + ")";
    }

    @Override
    public IValue eval(EvalContext context) {
        FuncValue l = (FuncValue)outer.eval(context);
        FuncValue r = (FuncValue)inner.eval(context);
        return new FuncValue(new InnerProdFn(l.get(), r.get()));
    }
}
