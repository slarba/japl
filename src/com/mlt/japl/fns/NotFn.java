package com.mlt.japl.fns;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.CharArray;
import com.mlt.japl.arrays.concrete.DoubleArray;
import com.mlt.japl.arrays.concrete.IntArray;
import com.mlt.japl.arrays.generated.LazyBitArray;
import com.mlt.japl.arrays.generated.LazyIntArray;
import com.mlt.japl.arrays.interf.*;
import com.mlt.japl.tools.Dimensions;
import it.unimi.dsi.fastutil.chars.CharArrayList;
import it.unimi.dsi.fastutil.chars.CharOpenHashSet;
import it.unimi.dsi.fastutil.chars.CharSet;
import it.unimi.dsi.fastutil.doubles.DoubleArrayList;
import it.unimi.dsi.fastutil.doubles.DoubleOpenHashSet;
import it.unimi.dsi.fastutil.doubles.DoubleSet;
import it.unimi.dsi.fastutil.longs.LongArrayList;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongSet;

public class NotFn extends BaseFn {
    public NotFn(int axis) {
        super(axis);

    }

    @Override
    public IValue visit_monadic(IIntArray a) {
        return new LazyIntArray(a.dims()) {
            @Override
            public long get(int index) {
                return ~a.get(index);
            }
        };
    }

    @Override
    public IValue visit_monadic(IBitArray a) {
        return new LazyBitArray(a.dims()) {
            @Override
            public long get(int index) {
                return a.get(index) ^ 1;
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IIntScalar b) {
        if (a.get() != b.get()) return b;
        else return IntArray.EMPTY;
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IDoubleScalar b) {
        if (a.get() != b.get()) return b;
        else return IntArray.EMPTY;
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, ICharScalar b) {
        if (a.get() != b.get()) return b;
        else return IntArray.EMPTY;
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IIntArray b) {
        LongSet s = new LongOpenHashSet();
        for (int i = 0; i < a.length(); i++) s.add(a.get(i));
        LongArrayList l = new LongArrayList();
        for (int i = 0; i < b.length(); i++) {
            long val = b.get(i);
            if (!s.contains(val)) l.add(val);
        }
        return new IntArray(new Dimensions(l.size()),
                l.toLongArray());
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IDoubleArray b) {
        LongSet s = new LongOpenHashSet();
        for (int i = 0; i < a.length(); i++) s.add(a.get(i));
        DoubleArrayList l = new DoubleArrayList();
        for (int i = 0; i < b.length(); i++) {
            double val = b.get(i);
            if (!s.contains(val)) l.add(val);
        }
        return new DoubleArray(new Dimensions(l.size()),
                l.toDoubleArray());
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IIntArray b) {
        DoubleSet s = new DoubleOpenHashSet();
        for (int i = 0; i < a.length(); i++) s.add(a.get(i));
        DoubleArrayList l = new DoubleArrayList();
        for (int i = 0; i < b.length(); i++) {
            double val = b.get(i);
            if (!s.contains(val)) l.add(val);
        }
        return new DoubleArray(new Dimensions(l.size()),
                l.toDoubleArray());
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IIntArray b) {
        LongArrayList l = new LongArrayList();
        for (int i = 0; i < b.length(); i++) {
            long val = b.get(i);
            if (val != a.get()) l.add(val);
        }
        return new IntArray(new Dimensions(l.size()),
                l.toLongArray());
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, ICharArray b) {
        CharArrayList l = new CharArrayList();
        for (int i = 0; i < b.length(); i++) {
            char val = b.get(i);
            if (val != a.get()) l.add(val);
        }
        return new CharArray(new Dimensions(l.size()),
                l.toCharArray());
    }

    @Override
    public IValue visit_dyadic(ICharArray a, ICharArray b) {
        CharSet s = new CharOpenHashSet();
        for (int i = 0; i < a.length(); i++) s.add(a.get(i));
        CharArrayList l = new CharArrayList();
        for (int i = 0; i < b.length(); i++) {
            char val = b.get(i);
            if (!s.contains(val)) l.add(val);
        }
        return new CharArray(new Dimensions(l.size()), l.toCharArray());
    }

    @Override
    public String getName() {
        return "not";
    }

}
