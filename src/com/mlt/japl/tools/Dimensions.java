package com.mlt.japl.tools;

import java.util.Arrays;

public class Dimensions {
	int[] dims;
	int[] spans;
	
	private static final int[] EMPTY_DIMS = new int[] {};
	public static final Dimensions EMPTY = new Dimensions();
		
	public Dimensions() {
		dims = EMPTY_DIMS;
		spans = EMPTY_DIMS;
	}

	public Dimensions(int... dims) {
		this.dims = dims;

		spans = new int[dims.length];
		spans[dims.length-1] = 1;
		for(int i=dims.length-1; i>0; i--) {
			spans[i-1] = spans[i]*dims[i];
		}			
	}
	
	public int rank() {
		return dims.length;
	}

	public int length() {
		int[] dims = this.dims;
		int rank = dims.length;
		if(rank==0) return 0;
		int len = 1;
		for(int i=0; i<rank; i++) {
			len *= dims[i];
		}
		return len;
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
}
