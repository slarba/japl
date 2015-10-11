package com.mlt.japl.fns;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.IntArray;

public class ZildeFn extends BaseFn {

    @Override
    public IValue applyNiladic(int axis) {
        return IntArray.EMPTY;
    }
}
