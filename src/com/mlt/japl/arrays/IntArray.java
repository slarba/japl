package com.mlt.japl.arrays;

import java.util.Arrays;

import com.mlt.japl.iface.Array;
import com.mlt.japl.scalars.IntScalar;
import com.mlt.japl.tools.Dimensions;

public class IntArray extends BaseArray {
	long[] data;
	
	private static final long[] EMPTY = new long[] {};
	
	public IntArray() {
		data = EMPTY;
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
	public Array reshape(int... newShape) {
		return new IntArray(new Dimensions(newShape), data);
	}

	@Override
	public Array reshape(Dimensions newShape) {
		return new IntArray(newShape, data);
	}

	@Override
	public Array unInitializedCopy() {
		return new IntArray(dims(), new long[data.length]);
	}

	@Override
	public Array unInitializedReshapedCopy(Dimensions resultDims) {
		if(resultDims.rank()==0) return new IntScalar();
		return new IntArray(resultDims, new long[resultDims.length()]);
	}	
	
	@Override
	public boolean equals(Object o) {
		if(o==this) return true;
		if(o instanceof IntArray) {
			return Arrays.equals(data, ((IntArray)o).data);
		}
		return false;
	}

}
