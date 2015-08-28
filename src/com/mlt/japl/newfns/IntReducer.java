package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.interf.IIntArray;

public abstract class IntReducer {
	private IIntArray array;
	private int axis;
	private long initval;
	private int mspan;
	private int[] spans;
	
	public IntReducer(long initval, IIntArray array, int axis) {
		this.array = array;
		this.axis = axis;
		this.initval = initval;
		spans = array.dims().spans();
		for(int i=0; i<spans.length; i++) {
			if(i==axis) continue;
			mspan += spans[i];
		}	
	}
	
	public long get(int index) {
		long result = initval;
		for(int i=0; i<array.dims().axis(axis); i++)
			result = op(result, array.get(index*mspan + i*spans[axis]));
		return result;
	}
	
	public abstract long op(long a, long b);
};
