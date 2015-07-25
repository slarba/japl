package com.mlt.japl.fns;

import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.iface.Array;
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

	@Override
	public int resultTypeFor(Array a) {
		throw new ValenceError();
	}

	@Override
	public int resultTypeFor(Array a, Array b) {
		return fn.resultTypeFor(a, b);
	}

}
