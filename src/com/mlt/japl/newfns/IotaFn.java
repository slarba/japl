package com.mlt.japl.newfns;

import com.mlt.japl.errors.DomainError;
import com.mlt.japl.errors.RankError;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.generated.IotaArray;
import com.mlt.japl.newarrays.generated.MultidimIotaArray;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IIntScalar;
import com.mlt.japl.newarrays.interf.IMixedArray;
import com.mlt.japl.tools.Dimensions;

public class IotaFn extends BaseFn {

	@Override
	public IValue visit_monadic(IIntScalar a, int axis) {
		return new IotaArray(new Dimensions((int)a.get()), a.get());
	}

	@Override
	public IValue visit_monadic(IIntArray a, int axis) {
		if(a.rank()>1) throw new RankError();
		int[] shape = new int[a.length()];
		for(int i=0; i<shape.length; i++) shape[i] = (int)a.get(i);
		return new MultidimIotaArray(new Dimensions(shape), a);
	}

	@Override
	public IValue visit_monadic(IMixedArray a, int axis) {
		throw new DomainError();
	}
	
	@Override
	public String getName() {
		return "iota";
	}

}
