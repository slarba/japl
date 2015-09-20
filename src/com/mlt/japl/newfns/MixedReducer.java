package com.mlt.japl.newfns;


import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.interf.IMixedArray;

public abstract class MixedReducer {
	private IMixedArray array;
	private int axis;
	private IValue initval;
	private int mspan;
	private int[] spans;
	
	public MixedReducer(IValue initval, IMixedArray array, int axis) {
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
		for(int i=array.length()-1; i>=0; i--) 
			result = op(array.get(i), result);
		return result;
	}

	public IValue get(int index) {
		int i = array.dims().axis(axis)-1;
		IValue result = array.get(index*mspan + i*spans[axis]);
		for(i=array.dims().axis(axis)-2; i>=0; i--)
			result = op(array.get(index*mspan + i*spans[axis]), result);
		return result;
	}
	
	public abstract IValue op(IValue a, IValue b);
};
