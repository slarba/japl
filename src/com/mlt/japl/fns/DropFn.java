package com.mlt.japl.fns;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.generated.LazyBitArray;
import com.mlt.japl.arrays.generated.LazyCharArray;
import com.mlt.japl.arrays.generated.LazyDoubleArray;
import com.mlt.japl.arrays.generated.LazyIntArray;
import com.mlt.japl.arrays.interf.*;
import com.mlt.japl.tools.Dimensions;

public class DropFn extends BaseFn {

    public DropFn(int axis) {
        super(axis);

    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IIntArray b) {
        long d = a.get();
        long dim = d < 0 ? b.length() + d : b.length() - d;
        return new LazyIntArray(new Dimensions((int) Math.max(0, dim))) {
            @Override
            public long get(int index) {
                if (d < 0) return b.get(index);
                return b.get(index + (int) d);
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IIntArray b) {
        int[] ds = new int[a.length()];
        for (int i = 0; i < ds.length; i++) ds[i] = (int) Math.max(0, b.dims().axis(i) - Math.abs(a.get(i)));
        return new LazyIntArray(new Dimensions(ds)) {
            @Override
            public long get(int index) {
                int[] idx = dims().reverseIndexInt(index);
                for (int i = 0; i < idx.length; i++) {
                    idx[i] += ds[i];
                }
                return b.get(b.dims().calculateIndex(idx));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IDoubleArray b) {
        long d = a.get();
        long dim = d < 0 ? b.length() + d : b.length() - d;
        return new LazyDoubleArray(new Dimensions((int) Math.max(0, dim))) {
            @Override
            public double get(int index) {
                if (d < 0) return b.get(index);
                return b.get(index + (int) d);
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IDoubleArray b) {
        int[] ds = new int[a.length()];
        for (int i = 0; i < ds.length; i++) ds[i] = (int) Math.max(0, b.dims().axis(i) - Math.abs(a.get(i)));
        return new LazyDoubleArray(new Dimensions(ds)) {
            @Override
            public double get(int index) {
                int[] idx = dims().reverseIndexInt(index);
                for (int i = 0; i < idx.length; i++) {
                    idx[i] += ds[i];
                }
                return b.get(b.dims().calculateIndex(idx));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, IBitArray b) {
        long d = a.get();
        long dim = d < 0 ? b.length() + d : b.length() - d;
        return new LazyBitArray(new Dimensions((int) Math.max(0, dim))) {
            @Override
            public long get(int index) {
                if (d < 0) return b.get(index);
                return b.get(index + (int) d);
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IBitArray b) {
        int[] ds = new int[a.length()];
        for (int i = 0; i < ds.length; i++) ds[i] = (int) Math.max(0, b.dims().axis(i) - Math.abs(a.get(i)));
        return new LazyBitArray(new Dimensions(ds)) {
            @Override
            public long get(int index) {
                int[] idx = dims().reverseIndexInt(index);
                for (int i = 0; i < idx.length; i++) {
                    idx[i] += ds[i];
                }
                return b.get(b.dims().calculateIndex(idx));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, ICharArray b) {
        int[] ds = new int[a.length()];
        for (int i = 0; i < ds.length; i++) ds[i] = (int) Math.max(0, b.dims().axis(i) - Math.abs(a.get(i)));
        return new LazyCharArray(new Dimensions(ds)) {
            @Override
            public char get(int index) {
                int[] idx = dims().reverseIndexInt(index);
                for (int i = 0; i < idx.length; i++) {
                    if (idx[i] >= b.dims().axis(i)) return ' ';
                }
                return b.get(b.dims().calculateIndex(idx));
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntScalar a, ICharArray b) {
        long d = a.get();
        long dim = d < 0 ? b.length() + d : b.length() - d;
        return new LazyCharArray(new Dimensions((int) Math.max(0, dim))) {
            @Override
            public char get(int index) {
                if (d < 0) return b.get(index);
                return b.get(index + (int) d);
            }
        };
    }

    @Override
    public String getName() {
        return "drop";
    }

}
