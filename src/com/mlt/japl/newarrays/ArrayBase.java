package com.mlt.japl.newarrays;

import com.mlt.japl.errors.DomainError;
import com.mlt.japl.errors.IndexError;
import com.mlt.japl.newarrays.interf.IArray;
import com.mlt.japl.newarrays.interf.IIntScalar;
import com.mlt.japl.newarrays.interf.IMixedArray;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.utils.PrintConfig;

public abstract class ArrayBase implements IValue, IArray {
	Dimensions dims;
	
	protected ArrayBase(Dimensions dims) {
		this.dims = dims;
	}
	
	@Override
	public IValue get(IMixedArray index) {
		throw new IndexError();
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

	public int[] dimsForIndexed(IMixedArray i) {
		if(i.length()!=rank()) throw new IndexError();
		int x=0;
		int[] resultDims = new int[rank()];
		for(int j=0; j<i.length(); j++) {
			IValue idx = i.get(j);
			if(idx instanceof IIntScalar) {
				//resultDims[x++] = 1;
				continue;
			} else if(idx.length()==0) {
				resultDims[x++] = dims().axis(j);
			} else {
				resultDims[x++] = idx.length();
			}
		}
		int[] finalDims = new int[x];
		for(int j=0; j<x; j++) finalDims[j] = resultDims[j];
		return finalDims;
	}

	public int indexForSingle(IValue i) {
		if(i instanceof IIntScalar) {
			long idx = ((IIntScalar)i).get();
			if(idx < 1 || idx>length()) throw new IndexError();
			return (int)(idx-1);
		}
		throw new DomainError();
	}
}
