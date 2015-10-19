package com.mlt.japl.fns;

import com.mlt.japl.errors.RankError;
import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.IntArray;
import com.mlt.japl.arrays.interf.IIntArray;
import com.mlt.japl.arrays.interf.IIntScalar;
import com.mlt.japl.tools.Dimensions;

public class RhoFn extends BaseFn implements Func {

    public RhoFn(int axis) {
        super(axis);

    }

    @Override
    public IValue applyMonadic(IValue a) {
        if(a.rank()==0) {
            return IntArray.EMPTY;
        }
        int[] dims = a.dims().asArray();
        long[] ds = new long[dims.length];
        for (int i = 0; i < ds.length; i++) {
            ds[i] = (long) dims[i];
        }
        return new IntArray(new Dimensions(ds.length), ds);
    }

    @Override
    public IValue visit_first(IIntArray a, IValue b) {
        if (a.rank() != 1) throw new RankError();
        int[] newShape = new int[a.length()];
        for (int i = 0; i < newShape.length; i++) newShape[i] = (int) a.get(i);
        return b.reshape(newShape);
    }

/*
    @Override
    public IValue visit_first(IMixedArray a, IValue b, int axis) {
        if (a.rank() != 1) throw new RankError();
        int[] newShape = new int[a.length()];
        for (int i = 0; i < newShape.length; i++) {
            IValue v = a.get(i);
            if (!(v instanceof IIntScalar)) throw new DomainError();
            newShape[i] = (int) ((IIntScalar) v).get();
        }
        return b.reshape(newShape);
    }
*/
    @Override
    public IValue visit_first(IIntScalar a, IValue b) {
        return b.reshape(new int[]{ (int) a.get() });
    }

    @Override
    public String getName() {
        return "rho";
    }
}
