package com.mlt.japl.fns;

import com.mlt.japl.errors.AxisError;
import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.MixedScalar;
import com.mlt.japl.arrays.generated.LazyMixedArray;
import com.mlt.japl.arrays.interf.*;

public class ReduceFn extends BaseFn {

    private Func fn;
    private boolean firstAxis;

    public ReduceFn(int axis, Func fn, boolean b) {
        super(axis);
        this.fn = fn;
        this.firstAxis = b;
    }

    @Override
    public String getName() {
        return "reduce<" + fn.getName() + ">";
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
    public IValue visit_monadic(IBitArray a) {
        int ax = this.axis;
        int axis = ax < 0 ? (firstAxis ? 0 : a.rank() - 1) : ax;
        if (axis >= a.rank()) throw new AxisError();
        return fn.reduce(a, axis);
    }

    @Override
    public IValue visit_monadic(IIntArray a) {
        int ax = this.axis;
        int axis = ax < 0 ? (firstAxis ? 0 : a.rank() - 1) : ax;
        if (axis >= a.rank()) throw new AxisError();
        return fn.reduce(a, axis);
    }

    @Override
    public IValue visit_monadic(IDoubleArray a) {
        int ax = this.axis;
        int axis = ax < 0 ? (firstAxis ? 0 : a.rank() - 1) : ax;
        if (axis >= a.rank()) throw new AxisError();
        return fn.reduce(a, axis);
    }

    @Override
    public IValue visit_monadic(ICharArray a) {
        int ax = this.axis;
        int axis = ax < 0 ? (firstAxis ? 0 : a.rank() - 1) : ax;
        if (axis >= a.rank()) throw new AxisError();
        return fn.reduce(a, axis);
    }

    @Override
    public IValue visit_monadic(IMixedArray a) {
        int ax = this.axis;
        int axis = ax < 0 ? (firstAxis ? 0 : a.rank() - 1) : ax;
        MixedReducer reducer = new MixedReducer(a, axis) {
            @Override
            public IValue op(IValue a, IValue b) {
                return fn.applyDyadic(a, b);
            }
        };
        if (a.rank() == 1) return new MixedScalar(reducer.rank1case());
        return new LazyMixedArray(a.dims().elideAxis(axis)) {
            @Override
            public IValue get(int index) {
                return reducer.get(index);
            }
        };
    }
}
