package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.IntArray;

public class ZildeFn extends BaseFn {

    @Override
    public IValue applyNiladic(int axis) {
        return IntArray.EMPTY;
    }
}
