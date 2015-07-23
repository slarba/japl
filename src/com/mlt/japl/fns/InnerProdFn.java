package com.mlt.japl.fns;

import com.mlt.japl.iface.Func;

public class InnerProdFn extends SpecialBaseFn {

	private Func leftFn;
	private Func rightFn;

	public InnerProdFn(Func leftFn, Func rightFn) {
		this.leftFn = leftFn;
		this.rightFn = rightFn;
		
	}

	@Override
	public String getName() {
		return "innerprod<" + leftFn.getName() + "," + rightFn.getName() + ">";
	}

}
