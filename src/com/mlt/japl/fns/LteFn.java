package com.mlt.japl.fns;

import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.iface.Array;

public class LteFn extends PrimitiveBaseFn {

	@Override
	public long I_CC(char a, char b) {
		return a<=b ? 1 : 0;
	}

	@Override
	public long I_DD(double a, double b) {
		return a<=b ? 1 : 0;
	}

	@Override
	public long I_DI(double a, long b) {
		return a<=b ? 1 : 0;
	}

	@Override
	public long I_ID(long a, double b) {
		return a<=b ? 1 : 0;
	}

	@Override
	public long I_II(long a, long b) {
		return a<=b ? 1 : 0;
	}

	@Override
	public String getName() {
		return "<=";
	}

	@Override
	public Array monadic(Array a, int axis) {
		throw new ValenceError();
	}

	@Override
	public int resultTypeFor(Array a, Array b) {
		if(a.isScalar() && b.isScalar()) return Array.INTEGER;
		return Array.BIT;
	}

}
