package com.mlt.japl.arrays;

import com.mlt.japl.errors.DomainError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.scalars.CharScalar;
import com.mlt.japl.scalars.IntScalar;
import com.mlt.japl.tools.Dimensions;

public class CharArray extends BaseArray {
	char[] data;

	public CharArray() {
		super();
	}

	public CharArray(String data) {
		super(new Dimensions(data.length()));
		this.data = data.toCharArray();
	}
	
	public CharArray(Dimensions dims, boolean allocateEmpty, int actualLength) {
		super(dims);
		data = new char[actualLength];
	}
	
	public CharArray(char... data) {
		super(new Dimensions(data.length));
		this.data = data;
	}
	
	public CharArray(Dimensions shape, char... data) {
		super(shape);
		this.data = data;
	}

	public CharArray(Dimensions shape, String data) {
		super(shape);
		this.data = data.toCharArray();
	}
	
	@Override
	public int type() {
		return CHARACTER;
	}

	@Override
	public int actualLength() {
		return data.length;
	}

	@Override
	public Array reshape(Dimensions newShape) {
		return new CharArray(newShape, data);
	}

	@Override
	public Array unInitializedCopy() {
		return new CharArray(dims(), new char[data.length]);
	}

	@Override
	public Array atA(int idx) {
		return new CharScalar(atC(idx));
	}

	@Override
	public char atC(int idx) {
		return data[idx % data.length];		
	}

	@Override
	public void setC(int idx, char val) {
		data[idx] = val;
	}

	@Override
	public Array unInitializedReshapedCopy(Dimensions resultDims) {
		if(resultDims.rank()==0) return new CharScalar();
		return new CharArray(resultDims, new char[resultDims.length()]);
	}

}
