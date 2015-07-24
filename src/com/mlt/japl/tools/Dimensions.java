package com.mlt.japl.tools;

import java.util.Arrays;

public class Dimensions {
	int[] dims;
	int[] spans;
	int length;
	
	private static final int[] EMPTY_DIMS = new int[] {0};
	public static final Dimensions EMPTY = new Dimensions();

	public Dimensions() {
		dims = EMPTY_DIMS;
		spans = EMPTY_DIMS;
		length = 0;
	}

	public Dimensions(int... dims) {
		this.dims = dims;

		spans = new int[dims.length];
		if(dims.length==0) return;
		
		spans[dims.length-1] = 1;
		int len = 1;
		for(int i=dims.length-1; i>0; i--) {
			len *= dims[i];
			spans[i-1] = spans[i]*dims[i];
		}			
		length = len*dims[0];
	}
	
	public Dimensions reverse() {
		int[] nds = new int[dims.length];
		int j = 0;
		for(int i=nds.length-1; i>=0; i--) {
			nds[j++] = dims[i];
		}
		return new Dimensions(nds);
	}

	public Dimensions concat(Dimensions o) {
		int[] nds = new int[dims.length + o.dims.length];
		for(int i=0; i<dims.length; i++) {
			nds[i] = dims[i];
		}
		for(int i=dims.length; i<o.dims.length; i++) {
			nds[i] = o.dims[i];
		}
		return new Dimensions(nds);
	}
	
	public Dimensions elideAxis(int axis) {
		int[] nds = new int[dims.length-1];
		int j=0;
		for(int i=0; i<dims.length; i++) {
			if(i==axis) continue;
			nds[j++] = dims[i];
		}
		return new Dimensions(nds);		
	}

	public Dimensions permute(int[] permutations) {
		int[] nds = new int[dims.length];
		for(int i=0; i<nds.length; i++) {
			nds[i] = dims[permutations[i]];
		}
		return new Dimensions(nds);		
	}
	
	public int axis(int i) {
		return dims[i];
	}
	
	public Dimensions offsetBy(int[] offsets) {
		int[] nds = new int[dims.length];
		for(int i=0; i<nds.length; i++) {
			nds[i] = Math.max(0, dims[i]+offsets[i]);
		}
		return new Dimensions(nds);		
	}

	public Dimensions offsetAxisBy(int axis, int offset) {
		int[] nds = new int[dims.length];
		for(int i=0; i<nds.length; i++) {
			if(axis==i) nds[i] = Math.max(0, dims[i]+offset);
			else nds[i] = dims[i];
		}
		return new Dimensions(nds);		
	}
	
	public int rank() {
		return dims.length;
	}

	public int length() {
		return length;
	}

	public Iterator iteratorAlongAxis(int axis) {
		return new AxisIterator(dims, spans, axis);
	}
	
	public int calculateIndex(int... indx) {
		int i;
		int result = 0;
		int[] spans = this.spans;
		for(i=0; i<indx.length; i++) {
			result += spans[i] * indx[i];
		}
		return result;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o==this) return true;
		if(!(o instanceof Dimensions)) return false;
		Dimensions d = (Dimensions)o;
		return Arrays.equals(dims, d.dims);
	}

	public int[] asArray() {
		return dims;
	}

	public int lastDim() {
		if(dims.length==0) return 0;
		return dims[dims.length-1];
	}

	public Iterator iteratorAlongLastAxis() {
		return iteratorAlongAxis(dims.length-1);
	}

	public Iterator linearIterator() {
		return new LinearIterator(length());
	}
}
