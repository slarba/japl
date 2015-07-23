package com.mlt.japl.tools;

public abstract class IteratorBase implements Iterator {

	protected int[] dims;
	protected int[] spans;
	protected int[] iter;
	protected boolean finished;

	public IteratorBase() {
		super();
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

}