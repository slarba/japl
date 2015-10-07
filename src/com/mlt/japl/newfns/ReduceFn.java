package com.mlt.japl.newfns;

import com.mlt.japl.errors.AxisError;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.MixedScalar;
import com.mlt.japl.newarrays.generated.LazyMixedArray;
import com.mlt.japl.newarrays.interf.*;

public class ReduceFn extends BaseFn {

    private Func fn;
    private boolean firstAxis;

    public ReduceFn(Func fn, boolean b) {
        this.fn = fn;
        this.firstAxis = b;
    }

    @Override
    public String getName() {
        return "reduce<" + fn.getName() + ">";
    }

    @Override
    public IValue visit_monadic(IIntScalar a, int axis) {
        return a;
    }

    @Override
    public IValue visit_monadic(IDoubleScalar a, int axis) {
        return a;
    }

    @Override
    public IValue visit_monadic(ICharScalar a, int axis) {
        return a;
    }

    @Override
    public IValue visit_monadic(IMixedScalar a, int axis) {
        return a;
    }

    @Override
    public IValue visit_monadic(IBitArray a, int ax) {
        int axis = ax < 0 ? (firstAxis ? 0 : a.rank() - 1) : ax;
        if (axis >= a.rank()) throw new AxisError();
        return fn.reduce(a, axis);
    }

    @Override
    public IValue visit_monadic(IIntArray a, int ax) {
        int axis = ax < 0 ? (firstAxis ? 0 : a.rank() - 1) : ax;
        if (axis >= a.rank()) throw new AxisError();
        return fn.reduce(a, axis < 0 ? (firstAxis ? 0 : a.rank() - 1) : axis);
    }

    @Override
    public IValue visit_monadic(IDoubleArray a, int ax) {
        int axis = ax < 0 ? (firstAxis ? 0 : a.rank() - 1) : ax;
        if (axis >= a.rank()) throw new AxisError();
        return fn.reduce(a, axis < 0 ? (firstAxis ? 0 : a.rank() - 1) : axis);
    }

    @Override
    public IValue visit_monadic(ICharArray a, int ax) {
        int axis = ax < 0 ? (firstAxis ? 0 : a.rank() - 1) : ax;
        if (axis >= a.rank()) throw new AxisError();
        return fn.reduce(a, axis < 0 ? (firstAxis ? 0 : a.rank() - 1) : axis);
    }

    @Override
    public IValue visit_monadic(IMixedArray a, int ax) {
        int axis = ax < 0 ? (firstAxis ? 0 : a.rank() - 1) : ax;
        MixedReducer reducer = new MixedReducer(a, axis) {
            @Override
            public IValue op(IValue a, IValue b) {
                return fn.applyDyadic(a, b, ax);
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
