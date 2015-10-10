package com.mlt.japl.newast;

import com.mlt.japl.newarrays.IValue;

/**
 * Created by markolau on 11/10/15.
 */
public class ReturnSignal extends AplSignal {
    private final IValue val;

    public ReturnSignal(IValue val) {
        this.val = val;
    }

    public IValue getVal() {
        return val;
    }
}
