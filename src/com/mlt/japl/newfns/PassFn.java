package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.IValue;

public class PassFn extends BaseFn {
	@Override
	public IValue applyMonadic(IValue a, int axis) {
		return a.force();
	}

	@Override
	public IValue applyDyadic(IValue a, IValue b, int axis) {
		return b.force();
	}
	
	@Override
	public String getName() {
		return "pass";
	}

}
