package com.mlt.japl.arrays;

import java.util.Arrays;

import com.mlt.japl.iface.Array;
import com.mlt.japl.scalars.DoubleScalar;
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
	public void setA(int idx, Array val) {
		setD(idx, val.atD(idx));
	}
	
	@Override
	public Array reshape(Dimensions newShape) {
		if(newShape.length()<length()) {
			return new DoubleArray(newShape, Arrays.copyOf(data, newShape.length()));
		}
		double[] newData = new double[length()];
		for(int i=0; i<newData.length; i++)
			newData[i] = atD(i);
		return new DoubleArray(newShape, newData);
	}

	public static Array similarTo(Array a) {
		return new DoubleArray(a.dims(), new double[a.length()]);
	}

	@Override
	public Array unInitializedCopy() {
		return new DoubleArray(dims(), new double[dims().length()]);
	}
	
	@Override
	public Array unInitializedReshapedCopy(Dimensions resultDims) {
		if(resultDims.rank()==0) return new DoubleScalar();
		return new DoubleArray(resultDims, new double[resultDims.length()]);
	}
	
//	@Override
//	public boolean equals(Object o) {
//		if(o==this) return true;
//		if(o instanceof DoubleArray) {
//			DoubleArray a = (DoubleArray)o;
//			if(!a.dims().equals(dims)) return false;
//			for(int i=0; i<a.length(); i++) {
//				if(a.atD(i) != atD(i)) return false;
//			}
//			return true;
//		}
//		return false;
//	}

}
