package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.generated.LazyCharArray;
import com.mlt.japl.newarrays.generated.LazyIntArray;
import com.mlt.japl.newarrays.interf.ICharArray;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IIntScalar;
import com.mlt.japl.tools.Dimensions;

public class DropFn extends BaseFn {

    @Override
    public IValue visit_dyadic(IIntScalar a, IIntArray b, int axis) {
        long d = a.get();
        long dim = d < 0 ? b.length() + d : b.length() - d;
        return new LazyIntArray(new Dimensions((int) Math.max(0, dim))) {
            @Override
            public long get(int index) {
                if (d < 0) return b.get(b.length() - (int) d + index);
                return b.get(index + (int) d);
            }
        };
    }

    @Override
    public IValue visit_dyadic(IIntArray a, IIntArray b, int axis) {
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
    public IValue visit_dyadic(IIntArray a, ICharArray b, int axis) {
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
    public String getName() {
        return "drop";
    }

}
