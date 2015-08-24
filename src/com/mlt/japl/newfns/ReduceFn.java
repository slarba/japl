package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.IValue;

public class ReduceFn implements Func {

	private Func fn;

	public ReduceFn(Func fn, boolean b) {
		this.fn = fn;
	}

	@Override
	public IValue applyDyadic(IValue a, IValue b, int axis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValue applyMonadic(IValue a, int axis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValue applyNiladic(int axis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		return "reduce<" + fn.getName() + ">";
	}

}
