package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.IValue;

public class OuterProdFn implements Func {

	private Func fn;

	public OuterProdFn(Func fn) {
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
		return "outerprod<" + fn.getName() + ">";
	}

}
