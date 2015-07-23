package com.mlt.japl.fns;

import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.ResultArrayUtil;

public abstract class PrecisionMaintainingFn extends PrimitiveBaseFn {

	@Override
	public Array createResultArrayFor(Array a, int axis) {
		return a.morePreciseUnInitializedCopy(a);
	}

	@Override
	public Array createResultArrayFor(Array a, Array b, int axis) {
		return ResultArrayUtil.precisionMaintainingFn(a, b, axis);
	}

}
