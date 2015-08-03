package com.mlt.japl.arrays;

import java.util.Arrays;

import com.mlt.japl.errors.DomainError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.scalars.IntScalar;
import com.mlt.japl.tools.Dimensions;

public class IntArray extends BaseArray {
	long[] data;
	
	private static final long[] EMPTYDATA = new long[] {};

	public static final IntArray ZILDE = new IntArray();
	
	public IntArray() {
		super();
		data = EMPTYDATA;
	}
	
	public IntArray(Dimensions dims, boolean allocateEmpty, int actualLength) {
		super(dims);
		data = new long[actualLength];
	}
	
	public IntArray(long... data) {
		super(new Dimensions(data.length));
		this.data = data;
	}
	
	public IntArray(Dimensions dims, long... data) {
		super(dims);
		this.data = data;
	}
	
	@Override
	public int type() {
		return INTEGER;
	}

	@Override
	public int actualLength() {
		return data.length;
	}

	@Override
	public Array atA(int idx) {
		return new IntScalar(atI(idx));
	}
	
	@Override
	public long atI(int idx) {
		return data[idx % data.length];		
	}

	@Override
	public void setI(int idx, long val) {
		data[idx] = val;
	}
	
	@Override
	public void setA(int idx, Array val) {
		setI(idx, val.atI(idx));
	}
	
	@Override
	public double atD(int idx) {
		return data[idx % data.length];
	}

	@Override
	public void setD(int idx, double val) {
		if(val==(long)val) data[idx] = (long)val;
		else throw new DomainError();
	}
	
	@Override
	public Array reshape(int... newShape) {
		return new IntArray(new Dimensions(newShape), data);
	}

	@Override
	public Array reshape(Dimensions newShape) {
		if(newShape.length()<length()) {
			return new IntArray(newShape, Arrays.copyOf(data, newShape.length()));
		}
		long[] newData = new long[length()];
		for(int i=0; i<newData.length; i++)
			newData[i] = atI(i);
		return new IntArray(newShape, newData);
	}

	@Override
	public Array unInitializedCopy() {
		return new IntArray(dims(), new long[dims.length()]);
	}

	@Override
	public Array unInitializedReshapedCopy(Dimensions resultDims) {
		if(resultDims.rank()==0) return new IntScalar();
		return new IntArray(resultDims, new long[resultDims.length()]);
	}	

	@Override
	public int[] asIntArray() {
		int[] r = new int[length()];
		for(int i=0; i<r.length; i++)
			r[i] = (int)atI(i);
		return r;
	}

	@Override
	public Array prototype() {
		return new IntScalar(0);
	}

	@Override
	public int hashCode() {
		return 37*super.hashCode() + 17*Arrays.hashCode(data);
	}

//	@Override
//	public boolean equals(Object o) {
//		if(o==this) return true;
//		if(o instanceof Array) {
//			Array a = (Array)o;
//			if(!a.isIntegral()) return false;
//			if(!a.dims().equals(dims)) return false;
//			for(int i=0; i<a.length(); i++) {
//				if(a.atI(i) != atI(i)) return false;
//			}
//			return true;
//		}
//		return false;
//	}

}
