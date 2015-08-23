package com.mlt.japl.speedtests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mlt.japl.newfns.Func;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.DoubleArray;
import com.mlt.japl.newarrays.concrete.IntArray;
import com.mlt.japl.newarrays.interf.IDoubleArray;
import com.mlt.japl.newfns.AddFn;

public class NewFnTest {

	@Test
	public void test() {
		Func fn = new AddFn();
		IValue a = new IntArray(new Dimensions(5), new long[] {4,7,6,3,4});
		IValue b = new DoubleArray(new Dimensions(5), new double[] {2,2,3,5,9});
		IValue result = fn.applyDyadic(a, b, 0);
		assertTrue(result instanceof IDoubleArray);
		IDoubleArray c = (IDoubleArray)result;
		assertTrue(6==c.get(0));
		assertTrue(9==c.get(1));
	}

}
