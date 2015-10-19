package com.mlt.japl.fns;

import com.mlt.japl.arrays.IValue;

public class PassFn extends BaseFn {
    public PassFn(int axis) {
        super(axis);

    }

    @Override
    public IValue applyMonadic(IValue a) {
        return a.force();
    }

    @Override
    public IValue applyDyadic(IValue a, IValue b) {
        return b.force();
    }

    @Override
    public String getName() {
        return "pass";
    }

}
