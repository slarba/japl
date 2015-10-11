package com.mlt.japl.fns;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.DoubleScalar;
import com.mlt.japl.arrays.generated.LazyDoubleArray;
import com.mlt.japl.arrays.interf.*;

public class LogFn extends BaseFn {

    @Override
    public IValue visit_monadic(IIntScalar a, int axis) {
        return new DoubleScalar(Math.log(a.get()));
    }

    @Override
    public IValue visit_monadic(IDoubleScalar a, int axis) {
        return new DoubleScalar(Math.log(a.get()));
    }

    @Override
    public IValue visit_monadic(IIntArray a, int axis) {
        return new LazyDoubleArray(a.dims()) {
            @Override
            public double get(int index) {
                return Math.log(a.get(index));
            }
        };
    }

    @Override
    public IValue visit_monadic(IDoubleArray a, int axis) {
        return new LazyDoubleArray(a.dims()) {
            @Override
            public double get(int index) {
                return Math.log(a.get(index));
            }
        };
    }

    @Override
    public IValue visit_monadic(IBitArray a, int axis) {
        return new LazyDoubleArray(a.dims()) {
            @Override
            public double get(int index) {
                return Math.log(a.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IIntArray b, int axis) {
        return new LazyDoubleArray(b.dims()) {
            @Override
            public double get(int index) {
                return Math.log(b.get(index)) / Math.log(a.get());
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IDoubleArray b, int axis) {
        return new LazyDoubleArray(b.dims()) {
            @Override
            public double get(int index) {
                return Math.log(b.get(index)) / Math.log(a.get());
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IBitArray b, int axis) {
        return new LazyDoubleArray(b.dims()) {
            @Override
            public double get(int index) {
                return Math.log(b.get(index)) / Math.log(a.get());
            }
        };
    }

    // ---
    @Override
    public IValue visit_dyadic(IDoubleScalar a, IIntArray b, int axis) {
        return new LazyDoubleArray(b.dims()) {
            @Override
            public double get(int index) {
                return Math.log(b.get(index)) / Math.log(a.get());
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IDoubleArray b, int axis) {
        return new LazyDoubleArray(b.dims()) {
            @Override
            public double get(int index) {
                return Math.log(b.get(index)) / Math.log(a.get());
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IBitArray b, int axis) {
        return new LazyDoubleArray(b.dims()) {
            @Override
            public double get(int index) {
                return Math.log(b.get(index)) / Math.log(a.get());
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IDoubleArray b, int axis) {
        return new LazyDoubleArray(b.dims()) {
            @Override
            public double get(int index) {
                return Math.log(b.get(index)) / Math.log(a.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IIntArray b, int axis) {
        return new LazyDoubleArray(b.dims()) {
            @Override
            public double get(int index) {
                return Math.log(b.get(index)) / Math.log(a.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IBitArray b, int axis) {
        return new LazyDoubleArray(b.dims()) {
            @Override
            public double get(int index) {
                return Math.log(b.get(index)) / Math.log(a.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IDoubleArray b, int axis) {
        return new LazyDoubleArray(b.dims()) {
            @Override
            public double get(int index) {
                return Math.log(b.get(index)) / Math.log(a.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IIntArray b, int axis) {
        return new LazyDoubleArray(b.dims()) {
            @Override
            public double get(int index) {
                return Math.log(b.get(index)) / Math.log(a.get(index));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IBitArray b, int axis) {
        return new LazyDoubleArray(b.dims()) {
            @Override
            public double get(int index) {
                return Math.log(b.get(index)) / Math.log(a.get(index));
            }
        };
    }

    @Override
    public String getName() {
        return "log";
    }

}