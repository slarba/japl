package com.mlt.japl;

import org.junit.Test;

import com.mlt.japl.fns.AddFn;
import com.mlt.japl.fns.SubFn;
import com.mlt.japl.iface.Func;
import com.mlt.japl.scalars.DoubleScalar;
import com.mlt.japl.scalars.IntScalar;

public class TestPrimitiveFnResultTypeMechanism {

	@Test
	public void test() {
		Func fn = new AddFn();
		fn.resultTypeFor(new IntScalar(), new IntScalar());
	}

	@Test
	public void test2() {
		Func fn = new SubFn();
		fn.resultTypeFor(new DoubleScalar());
	}
	
}
