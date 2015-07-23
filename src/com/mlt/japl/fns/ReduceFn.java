package com.mlt.japl.fns;

import com.mlt.japl.iface.Func;

public class ReduceFn extends SpecialBaseFn {

	private Func fn;

	public ReduceFn(Func fn) {
		this.fn = fn;
	}
	
	@Override
	public String getName() {
		return "reduce<" + fn.getName() + ">";
	}

}
