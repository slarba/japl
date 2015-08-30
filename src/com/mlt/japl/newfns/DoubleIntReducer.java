package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.interf.IDoubleArray;
import com.mlt.japl.newarrays.interf.IIntArray;

public abstract class DoubleIntReducer {
	private IIntArray array;
	private int axis;
	private double initval;
	private int mspan;
	private int[] spans;
	
	public DoubleIntReducer(double initval, IIntArray array, int axis) {
		this.array = array;
		this.axis = axis;
		this.initval = initval;
		spans = array.dims().spans();
		for(int i=0; i<spans.length; i++) {
			if(i==axis) continue;
			mspan += spans[i];
		}	
	}
	
	public double rank1case() {
		double result = initval;
		for(int i=array.length()-1; i>=0; i--) 
			result = op(array.get(i), result);
		return result;
	}

	public double get(int index) {
		double result = initval;
		for(int i=array.dims().axis(axis)-1; i>=0; i--)
			result = op(array.get(index*mspan + i*spans[axis]), result);
		return result;
	}
	
	public abstract double op(double a, double b);
};
