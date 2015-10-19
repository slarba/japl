package com.mlt.japl.fns;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.IntArray;

public class StopFn extends BaseFn {
    public StopFn(int axis) {
        super(axis);

    }

    @Override
    public IValue applyMonadic(IValue a) {
        return IntArray.EMPTY;
    }

    @Override
    public IValue applyDyadic(IValue a, IValue b) {
        return a.force();
    }

    @Override
    public String getName() {
        return "stop";
    }

}
