package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.interf.IBitArray;
import com.mlt.japl.newarrays.interf.ICharArray;
import com.mlt.japl.newarrays.interf.IDoubleArray;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IMixedArray;

public interface Func {
	public IValue applyDyadic(IValue a, IValue b, int axis);
	public IValue applyMonadic(IValue a, int axis);
	public IValue applyNiladic(int axis);
	public String getName();
	
	public IValue reduce(IIntArray a, int axis);
	public IValue reduce(IDoubleArray a, int axis);
	public IValue reduce(ICharArray a, int axis);
	public IValue reduce(IMixedArray a, int axis);
	public IValue reduce(IBitArray a, int axis);
	
	public IValue outerprod(IIntArray a, IIntArray b, int axis);
	public IValue outerprod(IIntArray a, IDoubleArray b, int axis);
	public IValue outerprod(IIntArray a, IBitArray b, int axis);
	public IValue outerprod(IIntArray a, ICharArray b, int axis);
	public IValue outerprod(IIntArray a, IMixedArray b, int axis);
	
	public IValue outerprod(IDoubleArray a, IIntArray b, int axis);
	public IValue outerprod(IDoubleArray a, IDoubleArray b, int axis);
	public IValue outerprod(IDoubleArray a, IBitArray b, int axis);
	public IValue outerprod(IDoubleArray a, ICharArray b, int axis);
	public IValue outerprod(IDoubleArray a, IMixedArray b, int axis);
	
	public IValue outerprod(IBitArray a, IIntArray b, int axis);
	public IValue outerprod(IBitArray a, IDoubleArray b, int axis);
	public IValue outerprod(IBitArray a, IBitArray b, int axis);
	public IValue outerprod(IBitArray a, ICharArray b, int axis);
	public IValue outerprod(IBitArray a, IMixedArray b, int axis);

	public IValue outerprod(ICharArray a, IIntArray b, int axis);
	public IValue outerprod(ICharArray a, IDoubleArray b, int axis);
	public IValue outerprod(ICharArray a, IBitArray b, int axis);
	public IValue outerprod(ICharArray a, IMixedArray b, int axis);
	public IValue outerprod(ICharArray a, ICharArray b, int axis);

	public IValue outerprod(IMixedArray a, IIntArray b, int axis);
	public IValue outerprod(IMixedArray a, IDoubleArray b, int axis);
	public IValue outerprod(IMixedArray a, IBitArray b, int axis);
	public IValue outerprod(IMixedArray a, ICharArray b, int axis);
	public IValue outerprod(IMixedArray a, IMixedArray b, int axis);
	
}
