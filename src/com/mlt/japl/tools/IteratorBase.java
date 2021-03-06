package com.mlt.japl.tools;

import java.util.Arrays;

public abstract class IteratorBase implements Iterator {

	protected int[] dims;
	protected int[] spans;
	protected int[] iter;
	protected boolean finished;
	protected int axis;
	
	public IteratorBase(int[] dims, int[] spans, int axis) {
		this.dims = dims;
		this.spans = spans;
		this.axis = axis;
		this.iter = new int[dims.length];
	}

	@Override
	public boolean isFinished() {
		return finished;
	}

	@Override
	public int index() {
		int i;
		int result = 0;
		int[] spans = this.spans;
		for(i=0; i<iter.length; i++) {
			result += spans[i] * iter[i];
		}
		return result;
	}

	@Override
	public int axis(int axis) {
		return iter[axis];
	}

	@Override
	public void reset() {
		Arrays.fill(iter, 0);
	}
}