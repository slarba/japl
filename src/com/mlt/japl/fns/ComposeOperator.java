package com.mlt.japl.fns;

import com.mlt.japl.arrays.IValue;

/**
 * Created by markolau on 20/10/15.
 */
public class ComposeOperator extends BaseFn {
    private Func l;
    private Func r;

    public ComposeOperator(Func l, Func r) {
        this.l = l;
        this.r = r;
    }

    @Override
    public IValue applyMonadic(IValue a) {
        return l.applyMonadic(r.applyMonadic(a));
    }
}

