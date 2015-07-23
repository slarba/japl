package com.mlt.japl;

public class IntArray extends BaseArray {
	long[] data;
	
	private static final long[] EMPTY = new long[] {};
	
	public IntArray() {
		data = EMPTY;
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
	public long atI(int... indx) {
		return data[dims.calculateIndex(indx) % data.length];
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
	public Array morePreciseUnInitializedCopy(Array b) {
		switch(b.type()) {
		case DOUBLE: 		return new DoubleArray(dims(), new double[data.length]);
		case INTEGER:       return unInitializedCopy();
		case MIXED:         return unInitializedCopy();
		}
		throw new AplError();
		
	}

	@Override
	public Array morePreciseUnInitializedCopy() {
		return new DoubleArray(dims(), new double[data.length]);
	}

}
