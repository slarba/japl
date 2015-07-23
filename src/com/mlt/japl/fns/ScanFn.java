package com.mlt.japl.fns;

import com.mlt.japl.iface.Func;

public class ScanFn extends SpecialBaseFn {

	private Func fn;

	public ScanFn(Func fn) {
		this.fn = fn;
	}
	
	@Override
	public String getName() {
		return "scan<" + fn.getName() + ">";
	}

}
