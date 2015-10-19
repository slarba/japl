package com.mlt.japl.fns;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.interf.*;

public interface Func {
    public IValue applyDyadic(IValue a, IValue b);

    public IValue applyMonadic(IValue a);

    public IValue applyNiladic();

    public String getName();

    public IValue reduce(IIntArray a, int axis);

    public IValue reduce(IDoubleArray a, int axis);

    public IValue reduce(ICharArray a, int axis);

    public IValue reduce(IMixedArray a, int axis);

    public IValue reduce(IBitArray a, int axis);

    public IValue outerprod(IIntArray a, IIntArray b);

    public IValue outerprod(IIntArray a, IDoubleArray b);

    public IValue outerprod(IIntArray a, IBitArray b);

    public IValue outerprod(IIntArray a, ICharArray b);

    public IValue outerprod(IIntArray a, IMixedArray b);

    public IValue outerprod(IDoubleArray a, IIntArray b);

    public IValue outerprod(IDoubleArray a, IDoubleArray b);

    public IValue outerprod(IDoubleArray a, IBitArray b);

    public IValue outerprod(IDoubleArray a, ICharArray b);

    public IValue outerprod(IDoubleArray a, IMixedArray b);

    public IValue outerprod(IBitArray a, IIntArray b);

    public IValue outerprod(IBitArray a, IDoubleArray b);

    public IValue outerprod(IBitArray a, IBitArray b);

    public IValue outerprod(IBitArray a, ICharArray b);

    public IValue outerprod(IBitArray a, IMixedArray b);

    public IValue outerprod(ICharArray a, IIntArray b);

    public IValue outerprod(ICharArray a, IDoubleArray b);

    public IValue outerprod(ICharArray a, IBitArray b);

    public IValue outerprod(ICharArray a, IMixedArray b);

    public IValue outerprod(ICharArray a, ICharArray b);

    public IValue outerprod(IMixedArray a, IIntArray b);

    public IValue outerprod(IMixedArray a, IDoubleArray b);

    public IValue outerprod(IMixedArray a, IBitArray b);

    public IValue outerprod(IMixedArray a, ICharArray b);

    public IValue outerprod(IMixedArray a, IMixedArray b);

}
