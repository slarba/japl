package com.mlt.japl.tools;

public class LinearIterator implements Iterator {

	int iter = 0;
	private int upto;

	public LinearIterator(int upTo) {
		this.upto = upTo;
	}
	
	@Override
	public boolean isFinished() {
		return iter>=upto;
	}

	@Override
	public void step() {
		iter++;
	}

	@Override
	public int index() {
		return iter;
	}

	@Override
	public int axis(int axis) {
		return 0;
	}

	@Override
	public void reset() {
		iter = 0;
	}

	@Override
	public int[] iter() {
		return null;
	}

}
