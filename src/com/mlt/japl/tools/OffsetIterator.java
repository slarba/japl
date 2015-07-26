package com.mlt.japl.tools;

import java.util.Arrays;

public class OffsetIterator implements Iterator {

	protected int[] dims;
	protected int[] spans;
	protected int[] iter;
	protected boolean finished;
	protected int[] offsets;
	protected int[] limits;
	
	public OffsetIterator(int[] dims, int[] spans, int[] offsets, int[] limits) {
		this.dims = dims;
		this.spans = spans;
		this.offsets = offsets;
		this.iter = Arrays.copyOf(offsets, offsets.length);
		this.limits = limits;
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
	public void step() {
		for(int i=iter.length-1; i>=0; i--) {
			iter[i]++;
			if(iter[i]<(dims[i]-limits[i])) return; else iter[i] = offsets[i];
		}
		finished = true;
	}

	@Override
	public void reset() {
		this.iter = Arrays.copyOf(offsets, offsets.length);
	}

}
