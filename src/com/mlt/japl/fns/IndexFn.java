package com.mlt.japl.fns;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.interf.IMixedArray;

public class IndexFn extends BaseFn {
    public IndexFn(int axis) {
        super(axis);

    }

    @Override
    public IValue visit_first(IMixedArray a, IValue b) {
        return b.get(a);
    }
}
