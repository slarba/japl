package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.IValue;

public class InnerProdFn implements Func {

	private Func left;
	private Func right;

	public InnerProdFn(Func left, Func right) {
		this.left = left;
		this.right = right;
		
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
		return "innerprod<" + left.getName() + "," + right.getName() + ">";
	}

}
