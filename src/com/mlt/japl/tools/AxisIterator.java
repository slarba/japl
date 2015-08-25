package com.mlt.japl.tools;

public class AxisIterator extends IteratorBase {

	public AxisIterator(int[] dims, int[] spans, int axis) {
		super(dims,spans,axis);
	}

	@Override
	public int step() {
		iter[axis]++;
		if(iter[axis]>=dims[axis]) {
			iter[axis] = 0;
			for(int i=iter.length-1; i>=0; i--) {
				if(i==axis) continue;
				iter[i]++;
				if(iter[i]<dims[i]) return iter.length-i; else iter[i] = 0;
			}
			finished = true;
		}
		return 0;
	}

	@Override
	public int[] iter() {
		return iter;
	}
}
