package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.IValue;

public interface Func {
	public IValue applyDyadic(IValue a, IValue b, int axis);
	public IValue applyMonadic(IValue a, int axis);
	public IValue applyNiladic(int axis);
}
