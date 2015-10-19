package com.mlt.japl.fns;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.BitArray;
import com.mlt.japl.arrays.concrete.CharArray;
import com.mlt.japl.arrays.concrete.DoubleArray;
import com.mlt.japl.arrays.concrete.IntArray;
import com.mlt.japl.arrays.interf.IBitArray;
import com.mlt.japl.arrays.interf.ICharArray;
import com.mlt.japl.arrays.interf.IDoubleArray;
import com.mlt.japl.arrays.interf.IIntArray;
import com.mlt.japl.tools.Dimensions;
import it.unimi.dsi.fastutil.chars.CharOpenHashSet;
import it.unimi.dsi.fastutil.chars.CharSet;
import it.unimi.dsi.fastutil.doubles.DoubleOpenHashSet;
import it.unimi.dsi.fastutil.doubles.DoubleSet;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongSet;

public class IntersectionFn extends BaseFn {
    public IntersectionFn(int axis) {
        super(axis);

    }

    @Override
    public IValue visit_dyadic(IIntArray a, IIntArray b) {
        LongSet seta = new LongOpenHashSet();
        LongSet setb = new LongOpenHashSet();
        for (int i = 0; i < a.length(); i++) seta.add(a.get(i));
        for (int i = 0; i < b.length(); i++) setb.add(b.get(i));

        seta.retainAll(setb);
        long[] result = seta.toLongArray();

        return new IntArray(new Dimensions(result.length), result);
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IDoubleArray b) {
        DoubleSet seta = new DoubleOpenHashSet();
        DoubleSet setb = new DoubleOpenHashSet();
        for (int i = 0; i < a.length(); i++) seta.add(a.get(i));
        for (int i = 0; i < b.length(); i++) setb.add(b.get(i));

        seta.retainAll(setb);
        double[] result = seta.toDoubleArray();

        return new DoubleArray(new Dimensions(result.length), result);
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IIntArray b) {
        DoubleSet seta = new DoubleOpenHashSet();
        DoubleSet setb = new DoubleOpenHashSet();
        for (int i = 0; i < a.length(); i++) seta.add(a.get(i));
        for (int i = 0; i < b.length(); i++) setb.add(b.get(i));

        seta.retainAll(setb);
        double[] result = seta.toDoubleArray();

        return new DoubleArray(new Dimensions(result.length), result);
    }

    @Override
    public IValue visit_dyadic(IDoubleArray a, IDoubleArray b) {
        DoubleSet seta = new DoubleOpenHashSet();
        DoubleSet setb = new DoubleOpenHashSet();
        for (int i = 0; i < a.length(); i++) seta.add(a.get(i));
        for (int i = 0; i < b.length(); i++) setb.add(b.get(i));

        seta.retainAll(setb);
        double[] result = seta.toDoubleArray();

        return new DoubleArray(new Dimensions(result.length), result);
    }

    @Override
    public IValue visit_dyadic(ICharArray a, ICharArray b) {
        CharSet seta = new CharOpenHashSet();
        CharSet setb = new CharOpenHashSet();
        for (int i = 0; i < a.length(); i++) seta.add(a.get(i));
        for (int i = 0; i < b.length(); i++) setb.add(b.get(i));

        seta.retainAll(setb);
        char[] result = seta.toCharArray();

        return new CharArray(new Dimensions(result.length), result);
    }

    @Override
    public IValue visit_dyadic(IBitArray a, IBitArray b) {
        LongSet seta = new LongOpenHashSet();
        LongSet setb = new LongOpenHashSet();
        for (int i = 0; i < a.length(); i++) seta.add(a.get(i));
        for (int i = 0; i < b.length(); i++) setb.add(b.get(i));

        seta.retainAll(setb);
        long[] result = seta.toLongArray();

        BitArray res = new BitArray(new Dimensions(result.length));
        for (int i = 0; i < result.length; i++) res.setBit(i, result[i]);
        return res;
    }

}
