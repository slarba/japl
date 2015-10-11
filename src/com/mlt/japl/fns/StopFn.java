package com.mlt.japl.fns;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.IntArray;

public class StopFn extends BaseFn {
    @Override
    public IValue applyMonadic(IValue a, int axis) {
        return IntArray.EMPTY;
    }

    @Override
    public IValue applyDyadic(IValue a, IValue b, int axis) {
        return a.force();
    }

    @Override
    public String getName() {
        return "stop";
    }

}
