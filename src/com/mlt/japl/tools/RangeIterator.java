package com.mlt.japl.tools;

import java.util.Arrays;

public class RangeIterator implements Iterator {

	int[] mins;
	int[] maxes;
	private int[] iter;
	private boolean finished;

	public RangeIterator(int[] mins, int[] maxes) {
		this.mins = mins;
		this.maxes = maxes;
		this.iter = Arrays.copyOf(mins, mins.length);
		this.finished = false;
	}
	
	@Override
	public boolean isFinished() {
		return finished;
	}

	@Override
	public int step() {
		for(int i=iter.length-1; i>=0; i--) {
			iter[i]++;
			if(iter[i]<maxes[i]) return 0;
			iter[i] = mins[i];
		}
		finished = true;
		return 0;
	}

	@Override
	public int index() {
		return 0;
	}

	@Override
	public int axis(int axis) {
		return iter[axis];
	}

	@Override
	public void reset() {
		finished = false;
		iter = Arrays.copyOf(mins, mins.length);
	}

	@Override
	public int[] iter() {
		return iter;
	}

}
