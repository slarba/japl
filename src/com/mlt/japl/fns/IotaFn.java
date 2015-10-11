package com.mlt.japl.fns;

import com.mlt.japl.errors.DomainError;
import com.mlt.japl.errors.RankError;
import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.IntArray;
import com.mlt.japl.arrays.concrete.IntScalar;
import com.mlt.japl.arrays.generated.IotaArray;
import com.mlt.japl.arrays.generated.LazyIntArray;
import com.mlt.japl.arrays.generated.MultidimIotaArray;
import com.mlt.japl.arrays.interf.*;
import com.mlt.japl.tools.Dimensions;

public class IotaFn extends BaseFn {

    @Override
    public IValue visit_monadic(IIntScalar a, int axis) {
        return new IotaArray(new Dimensions((int) a.get()), a.get());
    }

    @Override
    public IValue visit_monadic(IIntArray a, int axis) {
        if (a.rank() > 1) throw new RankError();
        int[] shape = new int[a.length()];
        for (int i = 0; i < shape.length; i++) shape[i] = (int) a.get(i);
        return new MultidimIotaArray(new Dimensions(shape), a);
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IIntScalar b, int axis) {
        if (a.rank() > 1) throw new RankError();
        for (int i = 0; i < a.length(); i++) {
            if (a.get(i) == b.get()) return new IntScalar(i + 1);
        }
        return new IntScalar(a.length() + 1);
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IDoubleScalar b, int axis) {
        if (a.rank() > 1) throw new RankError();
        for (int i = 0; i < a.length(); i++) {
            if (a.get(i) == b.get()) return new IntScalar(i + 1);
        }
        return new IntScalar(a.length() + 1);
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IIntArray b, int axis) {
        if (a.rank() > 1) throw new RankError();
        return new LazyIntArray(b.dims()) {
            @Override
            public long get(int index) {
                for (int i = 0; i < b.length(); i++) {
                    if (a.get() == b.get(index)) return 1;
                }
                return 2;
            }
        };
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, ICharArray b, int axis) {
        if (a.rank() > 1) throw new RankError();
        return new LazyIntArray(b.dims()) {
            @Override
            public long get(int index) {
                for (int i = 0; i < b.length(); i++) {
                    if (a.get() == b.get(index)) return 1;
                }
                return 2;
            }
        };
    }

    @Override
    public IValue visit_dyadic(ICharArray a, ICharScalar b, int axis) {
        if (a.rank() > 1) throw new RankError();
        for (int i = 0; i < a.length(); i++) {
            if (a.get(i) == b.get()) return new IntScalar(i + 1);
        }
        return new IntScalar(a.length() + 1);
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IIntArray b, int axis) {
        if (a.rank() > 1) throw new RankError();
        if (b.rank() > 1) throw new RankError();
        return new LazyIntArray(b.dims()) {
            @Override
            public long get(int index) {
                for (int i = 0; i < a.length(); i++) {
                    if (a.get(i) == b.get(index)) return i + 1;
                }
                return a.length() + 1;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IDoubleArray b, int axis) {
        if (a.rank() > 1) throw new RankError();
        if (b.rank() > 1) throw new RankError();
        return new LazyIntArray(b.dims()) {
            @Override
            public long get(int index) {
                for (int i = 0; i < a.length(); i++) {
                    if (a.get(i) == b.get(index)) return i + 1;
                }
                return a.length() + 1;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, ICharScalar b, int axis) {
        if (a.rank() > 1) throw new RankError();
        return new IntScalar(a.length() + 1);
    }

    @Override
    public IValue visit_dyadic(IBitArray a, ICharScalar b, int axis) {
        if (a.rank() > 1) throw new RankError();
        return new IntScalar(a.length() + 1);
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IIntScalar b, int axis) {
        if (a.rank() > 1) throw new RankError();
        for (int i = 0; i < a.length(); i++) {
            if (a.get(i) == b.get()) return new IntScalar(i + 1);
        }
        return new IntScalar(a.length() + 1);

    }

    @Override
    public IValue visit_dyadic(IBitArray a, ICharArray b, int axis) {
        if (a.rank() > 1) throw new RankError();
        if (b.rank() > 1) throw new RankError();
        return new IntArray(b.dims(), new long[]{a.length() + 1});
    }

    @Override
    public IValue visit_dyadic(ICharArray a, IBitArray b, int axis) {
        if (a.rank() > 1) throw new RankError();
        if (b.rank() > 1) throw new RankError();
        return new IntArray(b.dims(), new long[]{a.length() + 1});
    }

    @Override
    public IValue visit_dyadic(IIntArray a, ICharArray b, int axis) {
        if (a.rank() > 1) throw new RankError();
        if (b.rank() > 1) throw new RankError();
        return new IntArray(b.dims(), new long[]{a.length() + 1});
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IBitArray b, int axis) {
        if (a.rank() > 1) throw new RankError();
        if (b.rank() > 1) throw new RankError();
        return new LazyIntArray(b.dims()) {
            @Override
            public long get(int index) {
                for (int i = 0; i < a.length(); i++) {
                    if (a.get(i) == b.get(index)) return i + 1;
                }
                return a.length() + 1;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IDoubleArray b, int axis) {
        if (a.rank() > 1) throw new RankError();
        if (b.rank() > 1) throw new RankError();
        return new LazyIntArray(b.dims()) {
            @Override
            public long get(int index) {
                for (int i = 0; i < a.length(); i++) {
                    if (a.get(i) == b.get(index)) return i + 1;
                }
                return a.length() + 1;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IBitArray b, int axis) {
        if (a.rank() > 1) throw new RankError();
        if (b.rank() > 1) throw new RankError();
        return new LazyIntArray(b.dims()) {
            @Override
            public long get(int index) {
                for (int i = 0; i < a.length(); i++) {
                    if (a.get(i) == b.get(index)) return i + 1;
                }
                return a.length() + 1;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, ICharArray b, int axis) {
        if (a.rank() > 1) throw new RankError();
        if (b.rank() > 1) throw new RankError();
        return new IntArray(b.dims(), new long[]{a.length() + 1});
    }

    @Override
    public IValue visit_dyadic(ICharArray a, IDoubleArray b, int axis) {
        if (a.rank() > 1) throw new RankError();
        if (b.rank() > 1) throw new RankError();
        return new IntArray(b.dims(), new long[]{a.length() + 1});
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IIntArray b, int axis) {
        if (a.rank() > 1) throw new RankError();
        if (b.rank() > 1) throw new RankError();
        return new LazyIntArray(b.dims()) {
            @Override
            public long get(int index) {
                for (int i = 0; i < a.length(); i++) {
                    if (a.get(i) == b.get(index)) return i + 1;
                }
                return a.length() + 1;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IDoubleArray b, int axis) {
        if (a.rank() > 1) throw new RankError();
        if (b.rank() > 1) throw new RankError();
        return new LazyIntArray(b.dims()) {
            @Override
            public long get(int index) {
                for (int i = 0; i < a.length(); i++) {
                    if (a.get(i) == b.get(index)) return i + 1;
                }
                return a.length() + 1;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IIntScalar b, int axis) {
        if (a.rank() > 1) throw new RankError();
        for (int i = 0; i < a.length(); i++) {
            if (a.get(i) == b.get()) return new IntScalar(i + 1);
        }
        return new IntScalar(a.length() + 1);
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IBitArray b, int axis) {
        if (a.rank() > 1) throw new RankError();
        if (b.rank() > 1) throw new RankError();
        return new LazyIntArray(b.dims()) {
            @Override
            public long get(int index) {
                for (int i = 0; i < a.length(); i++) {
                    if (a.get(i) == b.get(index)) return i + 1;
                }
                return a.length() + 1;
            }
        };
    }

    @Override
    public IValue visit_dyadic(ICharArray a, ICharArray b, int axis) {
        if (a.rank() > 1) throw new RankError();
        if (b.rank() > 1) throw new RankError();
        return new LazyIntArray(b.dims()) {
            @Override
            public long get(int index) {
                for (int i = 0; i < a.length(); i++) {
                    if (a.get(i) == b.get(index)) return i + 1;
                }
                return a.length() + 1;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IMixedArray a, IIntScalar b, int axis) {
        return new IntScalar(a.length() + 1);
    }

    @Override
    public IValue visit_dyadic(IMixedArray a, ICharScalar b, int axis) {
        return new IntScalar(a.length() + 1);
    }

    @Override
    public IValue visit_dyadic(IMixedArray a, IDoubleScalar b, int axis) {
        return new IntScalar(a.length() + 1);
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IIntScalar b, int axis) {
        if (a.get() == b.get()) return new IntScalar(1);
        else return new IntScalar(2);
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IDoubleScalar b, int axis) {
        if (a.get() == b.get()) return new IntScalar(1);
        else return new IntScalar(2);
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, ICharScalar b, int axis) {
        if (a.get() == b.get()) return new IntScalar(1);
        else return new IntScalar(2);
    }

    @Override
    public IValue visit_monadic(IMixedArray a, int axis) {
        throw new DomainError();
    }

    @Override
    public String getName() {
        return "iota";
    }

}
