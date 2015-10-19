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

    public IotaFn(int axis) {
        super(axis);

    }

    @Override
    public IValue visit_monadic(IIntScalar a) {
        return new IotaArray(new Dimensions((int) a.get()), a.get());
    }

    @Override
    public IValue visit_monadic(IIntArray a) {
        if (a.rank() > 1) throw new RankError();
        int[] shape = new int[a.length()];
        for (int i = 0; i < shape.length; i++) shape[i] = (int) a.get(i);
        return new MultidimIotaArray(new Dimensions(shape), a);
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IIntScalar b) {
        if (a.rank() > 1) throw new RankError();
        for (int i = 0; i < a.length(); i++) {
            if (a.get(i) == b.get()) return new IntScalar(i + 1);
        }
        return new IntScalar(a.length() + 1);
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IDoubleScalar b) {
        if (a.rank() > 1) throw new RankError();
        for (int i = 0; i < a.length(); i++) {
            if (a.get(i) == b.get()) return new IntScalar(i + 1);
        }
        return new IntScalar(a.length() + 1);
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IDoubleScalar b) {
        if (a.rank() > 1) throw new RankError();
        for (int i = 0; i < a.length(); i++) {
            if (a.get(i) == b.get()) return new IntScalar(i + 1);
        }
        return new IntScalar(a.length() + 1);
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IIntArray b) {
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
    public IValue visit_dyadic(IDoubleScalar a, IDoubleArray b) {
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
    public IValue visit_dyadic(IDoubleScalar a, IIntArray b) {
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
    public IValue visit_dyadic(IIntScalar a, IDoubleArray b) {
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
    public IValue visit_dyadic(ICharScalar a, ICharArray b) {
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
    public IValue visit_dyadic(ICharArray a, ICharScalar b) {
        if (a.rank() > 1) throw new RankError();
        for (int i = 0; i < a.length(); i++) {
            if (a.get(i) == b.get()) return new IntScalar(i + 1);
        }
        return new IntScalar(a.length() + 1);
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IIntArray b) {
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
    public IValue visit_dyadic(IIntArray a, IDoubleArray b) {
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
    public IValue visit_dyadic(IIntArray a, ICharScalar b) {
        if (a.rank() > 1) throw new RankError();
        return new IntScalar(a.length() + 1);
    }

    @Override
    public IValue visit_dyadic(IBitArray a, ICharScalar b) {
        if (a.rank() > 1) throw new RankError();
        return new IntScalar(a.length() + 1);
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IIntScalar b) {
        if (a.rank() > 1) throw new RankError();
        for (int i = 0; i < a.length(); i++) {
            if (a.get(i) == b.get()) return new IntScalar(i + 1);
        }
        return new IntScalar(a.length() + 1);

    }

    @Override
    public IValue visit_dyadic(IBitArray a, ICharArray b) {
        if (a.rank() > 1) throw new RankError();
        if (b.rank() > 1) throw new RankError();
        return new IntArray(b.dims(), new long[]{a.length() + 1});
    }

    @Override
    public IValue visit_dyadic(ICharArray a, IBitArray b) {
        if (a.rank() > 1) throw new RankError();
        if (b.rank() > 1) throw new RankError();
        return new IntArray(b.dims(), new long[]{a.length() + 1});
    }

    @Override
    public IValue visit_dyadic(IIntArray a, ICharArray b) {
        if (a.rank() > 1) throw new RankError();
        if (b.rank() > 1) throw new RankError();
        return new IntArray(b.dims(), new long[]{a.length() + 1});
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IBitArray b) {
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
    public IValue visit_dyadic(IBitArray a, IDoubleArray b) {
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
    public IValue visit_dyadic(IDoubleArray a, IBitArray b) {
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
    public IValue visit_dyadic(IDoubleArray a, ICharArray b) {
        if (a.rank() > 1) throw new RankError();
        if (b.rank() > 1) throw new RankError();
        return new IntArray(b.dims(), new long[]{a.length() + 1});
    }

    @Override
    public IValue visit_dyadic(ICharArray a, IDoubleArray b) {
        if (a.rank() > 1) throw new RankError();
        if (b.rank() > 1) throw new RankError();
        return new IntArray(b.dims(), new long[]{a.length() + 1});
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IIntArray b) {
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
    public IValue visit_dyadic(IDoubleArray a, IDoubleArray b) {
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
    public IValue visit_dyadic(IDoubleArray a, IIntScalar b) {
        if (a.rank() > 1) throw new RankError();
        for (int i = 0; i < a.length(); i++) {
            if (a.get(i) == b.get()) return new IntScalar(i + 1);
        }
        return new IntScalar(a.length() + 1);
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IBitArray b) {
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
    public IValue visit_dyadic(ICharArray a, ICharArray b) {
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
    public IValue visit_dyadic(IMixedArray a, IIntScalar b) {
        return new IntScalar(a.length() + 1);
    }

    @Override
    public IValue visit_dyadic(IMixedArray a, ICharScalar b) {
        return new IntScalar(a.length() + 1);
    }

    @Override
    public IValue visit_dyadic(IMixedArray a, IDoubleScalar b) {
        return new IntScalar(a.length() + 1);
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IIntScalar b) {
        if (a.get() == b.get()) return new IntScalar(1);
        else return new IntScalar(2);
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IDoubleScalar b) {
        if (a.get() == b.get()) return new IntScalar(1);
        else return new IntScalar(2);
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, IIntScalar b) {
        return new IntScalar(2);
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, ICharScalar b) {
        return new IntScalar(2);
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, IDoubleScalar b) {
        return new IntScalar(2);
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, ICharScalar b) {
        return new IntScalar(2);
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IIntScalar b) {
        if (a.get() == b.get()) return new IntScalar(1);
        else return new IntScalar(2);
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IDoubleScalar b) {
        if (a.get() == b.get()) return new IntScalar(1);
        else return new IntScalar(2);
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, ICharScalar b) {
        if (a.get() == b.get()) return new IntScalar(1);
        else return new IntScalar(2);
    }

    @Override
    public IValue visit_monadic(IMixedArray a) {
        throw new DomainError();
    }

    @Override
    public IValue visit_dyadic(IMixedScalar a, IMixedArray b) {
        if (a.rank() > 1) throw new RankError();
        return new LazyIntArray(b.dims()) {
            @Override
            public long get(int index) {
                for (int i = 0; i < b.length(); i++) {
                    if (a.get().equals(b.get(index))) return 1;
                }
                return 2;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IMixedArray a, IMixedScalar b) {
        if (a.rank() > 1) throw new RankError();
        for (int i = 0; i < a.length(); i++) {
            if (a.get(i).equals(b.get())) return new IntScalar(i + 1);
        }
        return new IntScalar(a.length() + 1);
    }

    @Override
    public String getName() {
        return "iota";
    }

}
