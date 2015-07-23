package com.mlt.japl.fns;

import com.mlt.japl.iface.Func;

public class FirstAxisReduceFn extends SpecialBaseFn {

	private Func fn;

	public FirstAxisReduceFn(Func fn) {
		this.fn = fn;
	}
	
	@Override
	public String getName() {
		return "reducefirstaxis<" + fn.getName() + ">";
	}

}
