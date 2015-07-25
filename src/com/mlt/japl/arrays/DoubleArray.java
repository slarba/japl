package com.mlt.japl.arrays;

import com.mlt.japl.iface.Array;
import com.mlt.japl.scalars.DoubleScalar;
import com.mlt.japl.scalars.IntScalar;
import com.mlt.japl.tools.Dimensions;

public class DoubleArray extends BaseArray {
	double[] data;

	private static final double[] EMPTY = new double[] {};
	
	public DoubleArray() {
		super();
		data = EMPTY;
	}
	
	public DoubleArray(double... data) {
		super(new Dimensions(data.length));
		this.data = data;
	}

	public DoubleArray(Dimensions dims, boolean allocateEmpty, int actualLength) {
		super(dims);
		data = new double[actualLength];
	}
	
	public DoubleArray(Dimensions dimensions, double... data) {
		super(dimensions);
		this.data = data;
	}
		
	@Override
	public int type() {
		return DOUBLE;
	}

	@Override
	public int actualLength() {
		return data.length;
	}

	@Override
	public Array atA(int idx) {
		return new DoubleScalar(atD(idx));
	}
	
	@Override
	public double atD(int idx) {
		return data[idx % data.length];		
	}

	@Override
	public void setD(int idx, double val) {
		data[idx] = val;
	}
	
	@Override
	public Array reshape(Dimensions newShape) {
		return new DoubleArray(newShape, data);
	}
	
	public static Array similarTo(Array a) {
		return new DoubleArray(a.dims(), new double[a.actualLength()]);
	}

	@Override
	public Array unInitializedCopy() {
		return new DoubleArray(dims(), new double[data.length]);
	}
	
	@Override
	public Array unInitializedReshapedCopy(Dimensions resultDims) {
		if(resultDims.rank()==0) return new DoubleScalar();
		return new DoubleArray(resultDims, new double[resultDims.length()]);
	}
}
