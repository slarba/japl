package com.mlt.japl.tools;

import com.mlt.japl.iface.Array;

public class TakeArrayAdapter {
	private Array array;
	private Array prototype;
	private int[] dims;
	
	public TakeArrayAdapter(Array a, Array prototype) {
		this.array = a;
		this.dims = a.dims().asArray();
		this.prototype = prototype;
	}

	// handles access "outside" the array, returning prototype as a filler
	public Array atA(int... idx) {
		for(int i=0; i<dims.length; i++) {
			if(idx[i]<0) return prototype;
			if(idx[i]>=dims[i]) return prototype;
		}
		return array.atA(idx);
	}
}
