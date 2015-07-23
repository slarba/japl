package com.mlt.japl.fns;

import com.mlt.japl.iface.Func;

public class FirstAxisScanFn extends SpecialBaseFn {

	private Func fn;

	public FirstAxisScanFn(Func fn) {
		this.fn = fn;
	}
	
	@Override
	public String getName() {
		return "scanfirstaxis<" + fn.getName() + ">";
	}
}
