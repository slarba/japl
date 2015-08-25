package com.mlt.japl.newfns;

import com.mlt.japl.errors.RankError;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.IntArray;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IIntScalar;
import com.mlt.japl.tools.Dimensions;

public class RhoFn extends BaseFn implements Func {

	@Override
	public IValue applyMonadic(IValue a, int axis) {
		int[] dims = a.dims().asArray();
		long[] ds = new long[dims.length];
		for(int i=0; i<ds.length; i++) {
			ds[i] = (long)dims[i];
		}
		return new IntArray(new Dimensions(ds.length), ds);
	}

	@Override
	public IValue visit_first(IIntArray a, IValue b, int axis) {
		if(a.rank()!=1) throw new RankError();
		int[] newShape = new int[a.length()];
		for(int i=0; i<newShape.length; i++) newShape[i] = (int)a.get(i);
		return b.reshape(newShape);
	}

	@Override
	public IValue visit_first(IIntScalar a, IValue b, int axis) {
		return b.reshape(new int[] { (int)a.get() });
	}

	@Override
	public String getName() {
		return "rho";
	}
}
