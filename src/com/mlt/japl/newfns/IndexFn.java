package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.IntArray;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IMixedArray;

public class IndexFn extends BaseFn {
	@Override
	public IValue visit_first(IMixedArray a, IValue b, int axis) {
		return b.get(a);
	}
}
