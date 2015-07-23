package com.mlt.japl.tools;

public class ReverseAxisIterator extends IteratorBase implements Iterator {

	private int axis;
	
	public ReverseAxisIterator(int[] dims, int[] spans, int axis) {
		this.dims = dims;
		this.spans = spans;
		this.axis = axis;
		this.iter = new int[dims.length];
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

}
