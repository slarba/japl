package com.mlt.japl.fns;

import com.mlt.japl.iface.Func;

public class OuterProdFn extends SpecialBaseFn {

	private Func fn;

	public OuterProdFn(Func fn) {
		this.fn = fn;
	}
	
	@Override
	public String getName() {
		return "outerprod<" + fn.getName() + ">";
	}

}
