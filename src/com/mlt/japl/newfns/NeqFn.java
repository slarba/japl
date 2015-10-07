package com.mlt.japl.newfns;

import com.mlt.japl.errors.SyntaxError;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.BitArray;
import com.mlt.japl.newarrays.concrete.IntScalar;
import com.mlt.japl.newarrays.generated.LazyBitArray;
import com.mlt.japl.newarrays.generated.LazyMixedArray;
import com.mlt.japl.newarrays.interf.*;

public class NeqFn extends BaseFn {
    @Override
    public IValue visit_dyadic(IIntScalar a, IIntScalar b, int axis) {
        return new IntScalar(a.get() != b.get() ? 1 : 0);
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IDoubleScalar b, int axis) {
        return new IntScalar(a.get() != b.get() ? 1 : 0);
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IDoubleScalar b, int axis) {
        return new IntScalar(a.get() != b.get() ? 1 : 0);
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IIntScalar b, int axis) {
        return new IntScalar(a.get() != b.get() ? 1 : 0);
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, ICharArray b, int axis) {
        return new BitArray(1, b.dims(), new long[]{1});
    }

    @Override
    public IValue visit_dyadic(ICharArray a, IIntScalar b, int axis) {
        return new BitArray(1, a.dims(), new long[]{1});
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IBitArray b, int axis) {
        checkLengths(a, b);
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) != b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IIntArray b, int axis) {
        checkLengths(a, b);
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) != b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IBitArray b, int axis) {
        checkLengths(a, b);
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) != b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IDoubleArray b, int axis) {
        checkLengths(a, b);
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) != b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IIntArray b, int axis) {
        checkLengths(a, b);
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) != b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IDoubleArray b, int axis) {
        checkLengths(a, b);
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) != b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IIntArray b, int axis) {
        checkLengths(a, b);
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) != b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IDoubleArray b, int axis) {
        checkLengths(a, b);
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) != b.get(index) ? 1 : 0;
            }
        };
    }

    // scalar/array
    @Override
    public IValue visit_dyadic(IIntScalar a, IIntArray b, int axis) {
        return new LazyBitArray(b.dims()) {
            @Override
            public long get(int index) {
                return a.get() != b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IDoubleArray b, int axis) {
        return new LazyBitArray(b.dims()) {
            @Override
            public long get(int index) {
                return a.get() != b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IIntArray b, int axis) {
        return new LazyBitArray(b.dims()) {
            @Override
            public long get(int index) {
                return a.get() != b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IDoubleArray b, int axis) {
        return new LazyBitArray(b.dims()) {
            @Override
            public long get(int index) {
                return a.get() != b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IIntScalar b, int axis) {
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) != b.get() ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IIntScalar b, int axis) {
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) != b.get() ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IDoubleScalar b, int axis) {
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) != b.get() ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IDoubleScalar b, int axis) {
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) != b.get() ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IBitArray b, int axis) {
        checkLengths(a, b);
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) != b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IIntScalar b, int axis) {
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) != b.get() ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, ICharScalar b, int axis) {
        return new IntScalar(a.get() != b.get() ? 1 : 0);
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, IIntScalar b, int axis) {
        return new IntScalar(1);
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, ICharScalar b, int axis) {
        return new IntScalar(1);
    }

    @Override
    public IValue visit_dyadic(ICharArray a, ICharScalar b, int axis) {
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) != b.get() ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(ICharArray a, IBitArray b, int axis) {
        checkLengths(a, b);
        return new BitArray(1, a.dims(), new long[]{1});
    }

    @Override
    public IValue visit_dyadic(ICharArray a, IIntArray b, int axis) {
        checkLengths(a, b);
        return new BitArray(1, a.dims(), new long[]{1});
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, ICharArray b, int axis) {
        return new LazyBitArray(b.dims()) {
            @Override
            public long get(int index) {
                return a.get() != b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, IBitArray b, int axis) {
        return new BitArray(1, b.dims(), new long[]{1});
    }

    @Override
    public IValue visit_dyadic(ICharArray a, ICharArray b, int axis) {
        return new LazyBitArray(b.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) != b.get(index) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IMixedArray b, int axis) {
        checkLengths(a, b);
        return new LazyMixedArray(a.dims()) {
            @Override
            public IValue get(int index) {
                return visit_first(new IntScalar(a.get(index)), b.get(index), axis);
            }
        };
    }

    @Override
    public IValue applyMonadic(IValue a, int axis) {
        throw new SyntaxError();
    }

    @Override
    public String getName() {
        return "!=";
    }
}
