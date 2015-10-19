package com.mlt.japl.fns;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.generated.*;
import com.mlt.japl.arrays.interf.*;

public class ReverseFn extends BaseFn {

    public ReverseFn(int axis) {
        super(axis);

    }

    @Override
    public IValue visit_monadic(IIntArray a) {
        return new LazyIntArray(a.dims().reverse()) {
            @Override
            public long get(int index) {
                int[] ri = dims().reverseIndexInt(index);
                int[] ri2 = new int[ri.length];
                for (int i = 0; i < ri.length; i++) ri2[ri.length - 1 - i] = ri[i];
                return a.get(a.dims().calculateIndex(ri2));
            }
        };
    }

    @Override
    public IValue visit_monadic(IDoubleArray a) {
        return new LazyDoubleArray(a.dims().reverse()) {
            @Override
            public double get(int index) {
                int[] ri = dims().reverseIndexInt(index);
                int[] ri2 = new int[ri.length];
                for (int i = 0; i < ri.length; i++) ri2[ri.length - 1 - i] = ri[i];
                return a.get(a.dims().calculateIndex(ri2));
            }
        };
    }

    @Override
    public IValue visit_monadic(ICharArray a) {
        return new LazyCharArray(a.dims().reverse()) {
            @Override
            public char get(int index) {
                int[] ri = dims().reverseIndexInt(index);
                int[] ri2 = new int[ri.length];
                for (int i = 0; i < ri.length; i++) ri2[ri.length - 1 - i] = ri[i];
                return a.get(a.dims().calculateIndex(ri2));
            }
        };
    }

    @Override
    public IValue visit_monadic(IBitArray a) {
        return new LazyBitArray(a.dims().reverse()) {
            @Override
            public long get(int index) {
                int[] ri = dims().reverseIndexInt(index);
                int[] ri2 = new int[ri.length];
                for (int i = 0; i < ri.length; i++) ri2[ri.length - 1 - i] = ri[i];
                return a.get(a.dims().calculateIndex(ri2));
            }
        };
    }

    @Override
    public IValue visit_monadic(IMixedArray a) {
        return new LazyMixedArray(a.dims().reverse()) {
            @Override
            public IValue get(int index) {
                int[] ri = dims().reverseIndexInt(index);
                int[] ri2 = new int[ri.length];
                for (int i = 0; i < ri.length; i++) ri2[ri.length - 1 - i] = ri[i];
                return a.get(a.dims().calculateIndex(ri2));
            }
        };
    }

    @Override
    public String getName() {
        return "reverse";
    }

}
