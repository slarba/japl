package com.mlt.japl.fns;

import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.iface.Array;
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

	@Override
	public int resultTypeFor(Array a) {
		return fn.resultTypeFor(a);
	}
	
	@Override
	public int resultTypeFor(Array a, Array b) {
		throw new ValenceError();
	}

}
