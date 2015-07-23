package com.mlt.japl;

public class DoubleArray extends BaseArray {
	double[] data;

	private static final double[] EMPTY = new double[] {};
	
	public DoubleArray() {
		super();
		data = EMPTY;
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
	public double atD(int... indx) {
		return data[dims.calculateIndex(indx) % data.length];
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
	public Array morePreciseUnInitializedCopy(Array b) {
		return unInitializedCopy();  // no more precise than that
	}

	@Override
	public Array morePreciseUnInitializedCopy() {
		return unInitializedCopy();  // no more precise than that
	}

}
