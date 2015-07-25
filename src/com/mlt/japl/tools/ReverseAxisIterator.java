package com.mlt.japl.tools;

public class ReverseAxisIterator extends IteratorBase implements Iterator {

	public ReverseAxisIterator(int[] dims, int[] spans, int axis) {
		super(dims,spans,axis);
		iter[axis] = dims[axis]-1;
	}

	@Override
	public void step() {
		iter[axis]--;
		if(iter[axis]<0) {
			iter[axis] = dims[axis]-1;
			for(int i=iter.length-1; i>=0; i--) {
				if(i==axis) continue;
				iter[i]++;
				if(iter[i]<dims[i]) return; else iter[i] = 0;
			}
			finished = true;
		}
	}

	@Override
	public void reset() {
		super.reset();
		iter[axis] = dims[axis]-1;
	}
}
