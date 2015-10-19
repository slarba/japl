package com.mlt.japl.fns;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.IntArray;

public class ZildeFn extends BaseFn {

    public ZildeFn(int axis) {
        super(axis);

    }

    @Override
    public IValue applyNiladic() {
        return IntArray.EMPTY;
    }
}
