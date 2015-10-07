package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.IntScalar;

public class DepthFn extends BaseFn {
    @Override
    public IValue applyMonadic(IValue a, int axis) {
        return new IntScalar(a.depth());
    }

    @Override
    public IValue applyDyadic(IValue a, IValue b, int axis) {
        return new IntScalar(a.equals(b) ? 1 : 0);
    }

    @Override
    public String getName() {
        return "depth";
    }
}
