package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.DoubleScalar;
import com.mlt.japl.newarrays.concrete.IntScalar;
import com.mlt.japl.newarrays.generated.LazyDoubleArray;
import com.mlt.japl.newarrays.generated.LazyIntArray;
import com.mlt.japl.newarrays.interf.IDoubleArray;
import com.mlt.japl.newarrays.interf.IDoubleScalar;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IIntScalar;

public class ExpFn extends BaseFn {
    @Override
    public IValue visit_monadic(IIntScalar a, int axis) {
        return new DoubleScalar(Math.exp(a.get()));
    }

    @Override
    public IValue visit_monadic(IDoubleScalar a, int axis) {
        return new DoubleScalar(Math.exp(a.get()));
    }

    @Override
    public IValue visit_monadic(IIntArray a, int axis) {
        return new LazyDoubleArray(a.dims()) {
            @Override
            public double get(int index) {
                return Math.exp(a.get(index));
            }
        };
    }

    @Override
    public IValue visit_monadic(IDoubleArray a, int axis) {
        return new LazyDoubleArray(a.dims()) {
            @Override
            public double get(int index) {
                return Math.exp(a.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IDoubleArray b, int axis) {
        return new LazyDoubleArray(a.dims()) {
            @Override
            public double get(int index) {
                return Math.pow(a.get(index), b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IIntArray b, int axis) {
        return new LazyIntArray(a.dims()) {
            @Override
            public long get(int index) {
                return (long) Math.pow(a.get(index), b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IDoubleArray b, int axis) {
        return new LazyDoubleArray(a.dims()) {
            @Override
            public double get(int index) {
                return Math.pow(a.get(index), b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IIntArray b, int axis) {
        return new LazyDoubleArray(a.dims()) {
            @Override
            public double get(int index) {
                return Math.pow(a.get(index), b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IIntScalar b, int axis) {
        return new IntScalar((long) Math.pow(a.get(), b.get()));
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IDoubleScalar b, int axis) {
        return new DoubleScalar(Math.pow(a.get(), b.get()));
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IDoubleScalar b, int axis) {
        return new DoubleScalar(Math.pow(a.get(), b.get()));
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IIntScalar b, int axis) {
        return new DoubleScalar(Math.pow(a.get(), b.get()));
    }

    @Override
    public String getName() {
        return "exp";
    }

}
