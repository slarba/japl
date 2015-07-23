package com.mlt.japl.tools;

public class AxisIterator extends IteratorBase {

	private int axis;
	
	public AxisIterator(int[] dims, int[] spans, int axis) {
		this.dims = dims;
		this.spans = spans;
		this.axis = axis;
		this.iter = new int[dims.length];
	}

	@Override
	public void step() {
		iter[axis]++;
		if(iter[axis]>=dims[axis]) {
			iter[axis] = 0;
			for(int i=iter.length-1; i>=0; i--) {
				if(i==axis) continue;
				iter[i]++;
				if(iter[i]<dims[i]) return; else iter[i] = 0;
			}
			finished = true;
		}
	}
}