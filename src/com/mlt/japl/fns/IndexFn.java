package com.mlt.japl.fns;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.interf.IMixedArray;

public class IndexFn extends BaseFn {
    @Override
    public IValue visit_first(IMixedArray a, IValue b, int axis) {
        return b.get(a);
    }
}
