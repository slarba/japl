package com.mlt.japl.fns;

import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.IntScalar;
import com.mlt.japl.arrays.generated.ConstBitArray;
import com.mlt.japl.arrays.generated.LazyBitArray;
import com.mlt.japl.arrays.generated.LazyIntArray;
import com.mlt.japl.arrays.interf.IBitArray;
import com.mlt.japl.arrays.interf.IIntArray;
import com.mlt.japl.arrays.interf.IIntScalar;

public class NandFn extends BaseFn {
    @Override
    public IValue visit_dyadic(IIntScalar a, IIntScalar b, int axis) {
        return new IntScalar(~(a.get() & b.get()));
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IBitArray b, int axis) {
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return (a.get(index) & b.get(index)) ^ 1;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IBitArray b, int axis) {
        checkLengths(a, b);
        return new LazyIntArray(a.dims()) {
            @Override
            public long get(int index) {
                return ~(a.get(index) & b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IIntArray b, int axis) {
        checkLengths(a, b);
        return new LazyIntArray(a.dims()) {
            @Override
            public long get(int index) {
                return ~(a.get(index) & b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IIntArray b, int axis) {
        checkLengths(a, b);
        return new LazyIntArray(a.dims()) {
            @Override
            public long get(int index) {
                return ~(a.get(index) & b.get(index));
            }
        };
    }

    // scalar/array
    @Override
    public IValue visit_dyadic(IIntScalar a, IIntArray b, int axis) {
        return new LazyIntArray(b.dims()) {
            @Override
            public long get(int index) {
                return ~(a.get() & b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IIntScalar b, int axis) {
        return new LazyIntArray(a.dims()) {
            @Override
            public long get(int index) {
                return ~(a.get(index) & b.get());
            }
        };
    }

    // scalar/array
    @Override
    public IValue visit_dyadic(IIntScalar a, IBitArray b, int axis) {
        return new LazyIntArray(b.dims()) {
            @Override
            public long get(int index) {
                return ~(a.get() & b.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IIntScalar b, int axis) {
        if (b.get() == 0) return new ConstBitArray(a.dims(), 1);
        return new LazyIntArray(a.dims()) {
            @Override
            public long get(int index) {
                return ~(a.get(index) & b.get());
            }
        };
    }

    @Override
    public IValue applyMonadic(IValue a, int axis) {
        throw new ValenceError();
    }

    @Override
    public String getName() {
        return "nand";
    }
}
