package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.IntArray;

public class StopFn extends BaseFn {
	@Override
	public IValue applyMonadic(IValue a, int axis) {
		return IntArray.EMPTY;
	}

}
