package com.mlt.japl.fns;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.MixedScalar;
import com.mlt.japl.arrays.interf.*;

public class EncloseFn extends BaseFn {

    public EncloseFn(int axis) {
        super(axis);

    }

    @Override
    public IValue visit_monadic(IIntScalar a) {
        return a;
    }

    @Override
    public IValue visit_monadic(IDoubleScalar a) {
        return a;
    }

    @Override
    public IValue visit_monadic(ICharScalar a) {
        return a;
    }

    @Override
    public IValue visit_monadic(IMixedScalar a) {
        return a;
    }

    @Override
    public IValue visit_monadic(IIntArray a) {
        return new MixedScalar(a);
    }

    @Override
    public IValue visit_monadic(IDoubleArray a) {
        return new MixedScalar(a);
    }

    @Override
    public IValue visit_monadic(ICharArray a) {
        return new MixedScalar(a);
    }

    @Override
    public IValue visit_monadic(IMixedArray a) {
        return new MixedScalar(a);
    }

    @Override
    public IValue visit_monadic(IBitArray a) {
        return new MixedScalar(a);
    }

    @Override
    public String getName() {
        return "enclose";
    }

}
