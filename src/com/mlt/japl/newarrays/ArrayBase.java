package com.mlt.japl.newarrays;

import com.mlt.japl.newarrays.interf.IArray;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.utils.PrintConfig;

public abstract class ArrayBase implements IValue, IArray {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dims == null) ? 0 : dims.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArrayBase other = (ArrayBase) obj;
		if (dims == null) {
			if (other.dims != null)
				return false;
		} else if (!dims.equals(other.dims))
			return false;
		return true;
	}
}
