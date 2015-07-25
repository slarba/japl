package com.mlt.japl.fns;

import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.iface.Func;

public class InnerProdFn extends SpecialBaseFn {

	private Func leftFn;
	private Func rightFn;

	public InnerProdFn(Func leftFn, Func rightFn) {
		this.leftFn = leftFn;
		this.rightFn = rightFn;
		
	}

	@Override
	public int resultTypeFor(Array a, Array b) {
		return leftFn.resultTypeFor(a, b);
	}
	
	@Override
	public int resultTypeFor(Array a) {
		throw new ValenceError();
	}

	@Override
	public String getName() {
		return "innerprod<" + leftFn.getName() + "," + rightFn.getName() + ">";
	}

}
