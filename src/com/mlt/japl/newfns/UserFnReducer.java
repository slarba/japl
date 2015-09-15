package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.IntScalar;
import com.mlt.japl.newarrays.interf.IDoubleArray;
import com.mlt.japl.newarrays.interf.IIntArray;

public abstract class UserFnReducer {
	private IIntArray array;
	private int axis;
	private IValue initval;
	private int mspan;
	private int[] spans;
	
	public UserFnReducer(IValue initval, IIntArray array, int axis) {
		this.array = array;
		this.axis = axis;
		this.initval = initval;
		spans = array.dims().spans();
		for(int i=0; i<spans.length; i++) {
			if(i==axis) continue;
			mspan += spans[i];
		}	
	}
	
	public IValue rank1case() {
		IValue result = initval;
		for(int i=array.length()-1; i>=1; i--) 
			result = op(new IntScalar(array.get(i)), result);
		return result;
	}

	public IValue get(int index) {
		IValue result = initval;
		for(int i=array.dims().axis(axis)-1; i>=1; i--)
			result = op(new IntScalar(array.get(index*mspan + i*spans[axis])), result);
		return result;
	}
	
	public abstract IValue op(IValue a, IValue b);
};
