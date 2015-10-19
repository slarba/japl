package com.mlt.japl.fns;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.*;
import com.mlt.japl.arrays.interf.*;
import com.mlt.japl.tools.Dimensions;
import it.unimi.dsi.fastutil.chars.CharOpenHashSet;
import it.unimi.dsi.fastutil.chars.CharSet;
import it.unimi.dsi.fastutil.doubles.DoubleOpenHashSet;
import it.unimi.dsi.fastutil.doubles.DoubleSet;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongSet;

import java.util.HashSet;

public class UnionFn extends BaseFn {

    public UnionFn(int axis) {
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
        LongSet set = new LongOpenHashSet();
        for (int i = 0; i < a.length(); i++) set.add(a.get(i));
        long[] result = set.toLongArray();
        return new IntArray(new Dimensions(result.length), result);
    }

    @Override
    public IValue visit_monadic(IDoubleArray a) {
        DoubleSet set = new DoubleOpenHashSet();
        for (int i = 0; i < a.length(); i++) set.add(a.get(i));
        double[] result = set.toDoubleArray();
        return new DoubleArray(new Dimensions(result.length), result);
    }

    @Override
    public IValue visit_monadic(ICharArray a) {
        CharSet set = new CharOpenHashSet();
        for (int i = 0; i < a.length(); i++) set.add(a.get(i));
        char[] result = set.toCharArray();
        return new CharArray(new Dimensions(result.length), result);
    }

    @Override
    public IValue visit_monadic(IMixedArray a) {
        HashSet<IValue> set = new HashSet<>();
        for (int i = 0; i < a.length(); i++)
            set.add(a.get(i));
        IValue[] result = new IValue[set.size()];
        int i = 0;
        for (IValue l : set)
            result[i++] = l;
        return new MixedArray(new Dimensions(result.length), result);
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IIntScalar b) {
        if (a.get() != b.get()) {
            return new IntArray(new Dimensions(2), new long[]{a.get(), b.get()});
        }
        return a;
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IDoubleScalar b) {
        if (a.get() != b.get()) {
            return new DoubleArray(new Dimensions(2), new double[]{a.get(), b.get()});
        }
        return a;
    }

    @Override
    public IValue visit_dyadic(ICharScalar a, ICharScalar b) {
        if (a.get() != b.get()) {
            return new CharArray(new Dimensions(2), new char[]{a.get(), b.get()});
        }
        return a;
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IDoubleScalar b) {
        if (a.get() != b.get()) {
            return new DoubleArray(new Dimensions(2), new double[]{a.get(), b.get()});
        }
        return a;
    }

    @Override
    public IValue visit_dyadic(IDoubleScalar a, IIntScalar b) {
        if (a.get() != b.get()) {
            return new DoubleArray(new Dimensions(2), new double[]{a.get(), b.get()});
        }
        return b;
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IIntArray b) {
        LongSet set = new LongOpenHashSet();
        for (int i = 0; i < a.length(); i++)
            set.add(a.get(i));
        for (int i = 0; i < b.length(); i++)
            set.add(b.get(i));
        long[] result = set.toLongArray();
        return new IntArray(new Dimensions(result.length), result);
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IDoubleArray b) {
        DoubleSet set = new DoubleOpenHashSet();
        for (int i = 0; i < a.length(); i++)
            set.add(a.get(i));
        for (int i = 0; i < b.length(); i++)
            set.add(b.get(i));
        double[] result = set.toDoubleArray();
        return new DoubleArray(new Dimensions(result.length), result);
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IDoubleArray b) {
        DoubleSet set = new DoubleOpenHashSet();
        for (int i = 0; i < a.length(); i++)
            set.add((double) a.get(i));
        for (int i = 0; i < b.length(); i++)
            set.add(b.get(i));
        double[] result = set.toDoubleArray();
        return new DoubleArray(new Dimensions(result.length), result);
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IIntArray b) {
        DoubleSet set = new DoubleOpenHashSet();
        for (int i = 0; i < a.length(); i++)
            set.add(a.get(i));
        for (int i = 0; i < b.length(); i++)
            set.add((double) b.get(i));
        double[] result = set.toDoubleArray();
        return new DoubleArray(new Dimensions(result.length), result);
    }

    @Override
    public IValue visit_dyadic(ICharArray a, ICharArray b) {
        CharSet set = new CharOpenHashSet();
        for (int i = 0; i < a.length(); i++)
            set.add(a.get(i));
        for (int i = 0; i < b.length(); i++)
            set.add(b.get(i));
        char[] result = set.toCharArray();
        return new CharArray(new Dimensions(result.length), result);
    }

    @Override
    public IValue visit_dyadic(ICharArray a, IIntArray b) {
        HashSet<IValue> set = new HashSet<>();
        for (int i = 0; i < a.length(); i++)
            set.add(new CharScalar(a.get(i)));
        for (int i = 0; i < b.length(); i++)
            set.add(new IntScalar(b.get(i)));
        IValue[] result = new IValue[set.size()];
        result = set.toArray(result);
        return new MixedArray(new Dimensions(result.length), result);
    }

    @Override
    public String getName() {
        return "union";
    }

}
