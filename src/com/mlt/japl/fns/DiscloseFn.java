package com.mlt.japl.fns;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.CharScalar;
import com.mlt.japl.arrays.concrete.DoubleScalar;
import com.mlt.japl.arrays.concrete.IntScalar;
import com.mlt.japl.arrays.interf.*;

public class DiscloseFn extends BaseFn {
    public DiscloseFn(int axis) {
        super(axis);

    }

    @Override
    public IValue visit_monadic(IMixedScalar a) {
        return a.get();
    }

    @Override
    public IValue visit_monadic(IIntArray a) {
        if (a.length() == 0) return a;
        return new IntScalar(a.get(0));
    }

    @Override
    public IValue visit_monadic(IDoubleArray a) {
        if (a.length() == 0) return a;
        return new DoubleScalar(a.get(0));
    }

    @Override
    public IValue visit_monadic(ICharArray a) {
        if (a.length() == 0) return a;
        return new CharScalar(a.get(0));
    }

    @Override
    public IValue visit_monadic(IBitArray a) {
        if (a.length() == 0) return a;
        return new IntScalar(a.get(0));
    }

    @Override
    public IValue visit_monadic(IMixedArray a) {
        if (a.length() == 0) return a;
        return a.get(0);
    }

    @Override
    public String getName() {
        return "disclose";
    }

}
