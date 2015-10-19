package com.mlt.japl.fns;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.IntScalar;
import com.mlt.japl.arrays.generated.LazyBitArray;
import com.mlt.japl.arrays.interf.*;
import it.unimi.dsi.fastutil.chars.CharOpenHashSet;
import it.unimi.dsi.fastutil.chars.CharSet;
import it.unimi.dsi.fastutil.doubles.DoubleOpenHashSet;
import it.unimi.dsi.fastutil.doubles.DoubleSet;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongSet;

public class ExistsFn extends BaseFn {

    public ExistsFn(int axis) {
        super(axis);

    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IIntArray b) {
        for (int i = 0; i < b.length(); i++) {
            if (b.get(i) == a.get()) return IntScalar.ONE;
        }
        return IntScalar.ZERO;
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IIntArray b) {
        for (int i = 0; i < b.length(); i++) {
            if (b.get(i) == a.get()) return IntScalar.ONE;
        }
        return IntScalar.ZERO;
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, IIntArray b) {
        return IntScalar.ZERO;
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IDoubleArray b) {
        for (int i = 0; i < b.length(); i++) {
            if (b.get(i) == a.get()) return IntScalar.ONE;
        }
        return IntScalar.ZERO;
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IDoubleArray b) {
        for (int i = 0; i < b.length(); i++) {
            if (b.get(i) == a.get()) return IntScalar.ONE;
        }
        return IntScalar.ZERO;
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, IDoubleArray b) {
        return IntScalar.ZERO;
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, IBitArray b) {
        return IntScalar.ZERO;
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, ICharArray b) {
        return IntScalar.ZERO;
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IBitArray b) {
        if (a.get() != 0 || a.get() != 1) return IntScalar.ZERO;
        for (int i = 0; i < b.length(); i++) {
            if (b.get(i) == a.get()) return IntScalar.ONE;
        }
        return IntScalar.ZERO;
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, ICharArray b) {
        return IntScalar.ZERO;
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, ICharArray b) {
        for (int i = 0; i < b.length(); i++) {
            if (b.get(i) == a.get()) return IntScalar.ONE;
        }
        return IntScalar.ZERO;
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IIntArray b) {
        LongSet set = new LongOpenHashSet();
        for (int i = 0; i < b.length(); i++) set.add(b.get(i));
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return set.contains(a.get(index)) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IDoubleArray b) {
        DoubleSet set = new DoubleOpenHashSet();
        for (int i = 0; i < b.length(); i++) set.add(b.get(i));
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return set.contains(a.get(index)) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IBitArray b) {
        LongSet set = new LongOpenHashSet();
        for (int i = 0; i < b.length(); i++) set.add(b.get(i));
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return set.contains(b.get(index)) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IIntArray b) {
        LongSet set = new LongOpenHashSet();
        for (int i = 0; i < b.length(); i++) set.add(b.get(i));
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return set.contains(b.get(index)) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IDoubleArray b) {
        DoubleSet set = new DoubleOpenHashSet();
        for (int i = 0; i < b.length(); i++) set.add(b.get(i));
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return set.contains(a.get(index)) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IBitArray b) {
        LongSet set = new LongOpenHashSet();
        for (int i = 0; i < b.length(); i++) set.add(b.get(i));
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return set.contains(b.get(index)) ? 1 : 0;
            }
        };
    }

    @Override
    public IValue visit_dyadic(ICharArray a, ICharArray b) {
        CharSet set = new CharOpenHashSet();
        for (int i = 0; i < b.length(); i++) set.add(b.get(i));
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return set.contains(b.get(index)) ? 1 : 0;
            }
        };
    }

    @Override
    public String getName() {
        return "exists";
    }

}
