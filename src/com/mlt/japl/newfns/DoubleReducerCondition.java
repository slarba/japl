package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.interf.IDoubleArray;

public abstract class DoubleReducerCondition {
	private IDoubleArray array;
	private int axis;
	private double initval;
	private int mspan;
	private double condition;
	private int[] spans;
	
	public DoubleReducerCondition(double initval, double condition, IDoubleArray array, int axis) {
		this.array = array;
		this.axis = axis;
		this.initval = initval;
		this.condition = condition;
		spans = array.dims().spans();
		for(int i=0; i<spans.length; i++) {
			if(i==axis) continue;
			mspan += spans[i];
		}	
	}
	
	public double rank1case() {
		double result = initval;
		for(int i=array.length()-1; i>=0; i--) {
			result = op(array.get(i), result);
			if(result==condition) break;
		}
		return result;
	}

	public double get(int index) {
		double result = initval;
		for(int i=array.dims().axis(axis)-1; i>=0; i--) {
			result = op(array.get(index*mspan + i*spans[axis]), result);
			if(result==condition) break;
		}
		return result;
	}
	
	public abstract double op(double a, double b);
};
