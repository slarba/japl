package com.mlt.japl.newarrays;

import com.mlt.japl.tools.Dimensions;

public abstract class ScalarBase implements IValue {

	@Override
	public Dimensions dims() {
		return Dimensions.EMPTY;
	}

	@Override
	public int rank() {
		return 0;
	}

	@Override
	public int depth() {
		return 0;
	}

	@Override
	public int length() {
		return 0;
	}

	@Override
	public IValue force() {
		return this;
	}
}
