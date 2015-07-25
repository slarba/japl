package com.mlt.japl.fns;

import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.iface.Func;

public class FirstAxisScanFn extends SpecialBaseFn {

	private Func fn;

	public FirstAxisScanFn(Func fn) {
		this.fn = fn;
	}

	@Override
	public int resultTypeFor(Array a) {
		return fn.resultTypeFor(a);
	}
	
	@Override
	public int resultTypeFor(Array a, Array b) {
		throw new ValenceError();
	}
	
	@Override
	public String getName() {
		return "scanfirstaxis<" + fn.getName() + ">";
	}
}
