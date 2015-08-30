package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.interf.IBitArray;

public abstract class BitReducer {
	private IBitArray array;
	private int axis;
	private long initval;
	private int mspan;
	private int[] spans;
	
	public BitReducer(long initval, IBitArray array, int axis) {
		this.array = array;
		this.axis = axis;
		this.initval = initval;
		spans = array.dims().spans();
		for(int i=0; i<spans.length; i++) {
			if(i==axis) continue;
			mspan += spans[i];
		}	
	}
	
	public long rank1case() {
		long result = initval;
		for(int i=array.length()-1; i>=0; i--) 
			result = op(array.get(i), result);
		return result;
	}

	public long get(int index) {
		long result = initval;
		for(int i=array.dims().axis(axis)-1; i>=0; i--)
			result = op(array.get(index*mspan + i*spans[axis]), result);
		return result;
	}
	
	public abstract long op(long a, long b);
};
