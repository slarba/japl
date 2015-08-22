package com.mlt.japl.newarrays;

import com.mlt.japl.tools.Dimensions;

public abstract class ArrayBase implements IValue {
	Dimensions dims;
	
	protected ArrayBase(Dimensions dims) {
		this.dims = dims;
	}
	
	@Override
	public Dimensions dims() {
		return dims;
	}

	@Override
	public int rank() {
		return dims.rank();
	}

	@Override
	public int depth() {
		return 1;
	}

	@Override
	public int length() {
		return dims.length();
	}
}
