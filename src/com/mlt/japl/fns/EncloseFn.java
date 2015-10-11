package com.mlt.japl.fns;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.MixedScalar;
import com.mlt.japl.arrays.interf.*;

public class EncloseFn extends BaseFn {

    @Override
    public IValue visit_monadic(IIntScalar a, int axis) {
        return a;
    }

    @Override
    public IValue visit_monadic(IDoubleScalar a, int axis) {
        return a;
    }

    @Override
    public IValue visit_monadic(ICharScalar a, int axis) {
        return a;
    }

    @Override
    public IValue visit_monadic(IMixedScalar a, int axis) {
        return a;
    }

    @Override
    public IValue visit_monadic(IIntArray a, int axis) {
        return new MixedScalar(a);
    }

    @Override
    public IValue visit_monadic(IDoubleArray a, int axis) {
        return new MixedScalar(a);
    }

    @Override
    public IValue visit_monadic(ICharArray a, int axis) {
        return new MixedScalar(a);
    }

    @Override
    public IValue visit_monadic(IMixedArray a, int axis) {
        return new MixedScalar(a);
    }

    @Override
    public IValue visit_monadic(IBitArray a, int axis) {
        return new MixedScalar(a);
    }

    @Override
    public String getName() {
        return "enclose";
    }

}
