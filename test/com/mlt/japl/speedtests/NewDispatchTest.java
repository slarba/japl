package com.mlt.japl.speedtests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mlt.japl.arrays.CharArray;
import com.mlt.japl.arrays.DoubleArray;
import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.fns.NewDispatchFn;

public class NewDispatchTest {

	@Test
	public void test() {
		NewDispatchFn dfn = new NewDispatchFn();
		dfn.dyadic(new IntArray(), new DoubleArray());
		dfn.dyadic(new DoubleArray(), new CharArray());
	}

}
