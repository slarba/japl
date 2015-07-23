package com.mlt.japl.fns;

import com.mlt.japl.iface.Func;

public class EachFn extends SpecialBaseFn {

	private Func fn;

	public EachFn(Func fn) {
		this.fn = fn;
	}
	
	@Override
	public String getName() {
		return "each<" + fn.getName() + ">";
	}
}
