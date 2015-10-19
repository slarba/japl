package com.mlt.japl.fns;

import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.IntScalar;
import com.mlt.japl.arrays.generated.LazyBitArray;
import com.mlt.japl.arrays.interf.*;

public class GtFn extends BaseFn {
    public GtFn(int axis) {
        super(axis);

    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IIntScalar b) {
        return new IntScalar(a.get() > b.get() ? 1 : 0);
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IDoubleScalar b) {
        return new IntScalar(a.get() > b.get() ? 1 : 0);
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IDoubleScalar b) {
        return new IntScalar(a.get() > b.get() ? 1 : 0);
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IIntScalar b) {
        return new IntScalar(a.get() > b.get() ? 1 : 0);
    }

    @Override
    public IValue visit_dyadic(ICharArray a, ICharArray b) {
        checkLengths(a, b);
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) > b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IBitArray b) {
        checkLengths(a, b);
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) > b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IIntArray b) {
        checkLengths(a, b);
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) > b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IBitArray b) {
        checkLengths(a, b);
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) > b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IDoubleArray b) {
        checkLengths(a, b);
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) > b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IIntArray b) {
        checkLengths(a, b);
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) > b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IDoubleArray b) {
        checkLengths(a, b);
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) > b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IIntArray b) {
        checkLengths(a, b);
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) > b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IDoubleArray b) {
        checkLengths(a, b);
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) > b.get(index) ? 1 : 0;
            }
        };
    }

    // scalar/array
    @Override
    public IValue visit_dyadic(IIntScalar a, IIntArray b) {
        return new LazyBitArray(b.dims()) {
            @Override
            public long get(int index) {
                return a.get() > b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IDoubleArray b) {
        return new LazyBitArray(b.dims()) {
            @Override
            public long get(int index) {
                return a.get() > b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IIntArray b) {
        return new LazyBitArray(b.dims()) {
            @Override
            public long get(int index) {
                return a.get() > b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IDoubleArray b) {
        return new LazyBitArray(b.dims()) {
            @Override
            public long get(int index) {
                return a.get() > b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IIntScalar b) {
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) > b.get() ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IIntScalar b) {
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) > b.get() ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IDoubleScalar b) {
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) > b.get() ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IDoubleScalar b) {
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) > b.get() ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(ICharArray a, ICharScalar b) {
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) > b.get() ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, ICharArray b) {
        return new LazyBitArray(b.dims()) {
            @Override
            public long get(int index) {
                return a.get() > b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IBitArray b) {
        return new LazyBitArray(b.dims()) {
            @Override
            public long get(int index) {
                return a.get() > b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IIntScalar b) {
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) > b.get() ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, ICharScalar b) {
        return new IntScalar(a.get() > b.get() ? 1 : 0);
    }

    @Override
    public IValue applyMonadic(IValue a) {
        throw new ValenceError();
    }

    @Override
    public String getName() {
        return ">";
    }
}
