package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.workspace.EvalContext;

/**
 * Created by markolau on 11/10/15.
 */
public class BoundFunc extends BaseFn {

    private final IValue left;
    private final Func func;

    public BoundFunc(IValue left, Func func) {
        this.left = left;
        this.func = func;
    }

    @Override
    public IValue applyMonadic(IValue right, int axis) {
        return func.applyDyadic(left, right, axis);
    }

}
