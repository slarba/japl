package com.mlt.japl.newarrays;

import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.utils.PrintConfig;

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
	
	@Override
	public IValue force() {
		return this;
	}
	
	@Override
	public String asString(PrintConfig config) {
		return "array";
	}
}
