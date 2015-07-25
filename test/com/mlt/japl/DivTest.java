package com.mlt.japl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mlt.japl.arrays.DoubleArray;
import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.arrays.IotaArray;
import com.mlt.japl.fns.DivFn;
import com.mlt.japl.iface.Array;
import com.mlt.japl.iface.Func;
import com.mlt.japl.scalars.DoubleScalar;
import com.mlt.japl.scalars.IntScalar;
import com.mlt.japl.tools.Dimensions;

public class DivTest {

	Dimensions d = new Dimensions(2,3);
	Array si = new IntScalar(5);
	Array sd = new DoubleScalar(5);
	Array ai = new IntArray(d, 1, 2, 3, 4, 5);
	Array ad = new DoubleArray(d, 1, 2, 3, 4, 5);
	Array aiota = new IotaArray(d, 5);
	Array bi = new IntArray(d, 2, 3, 4, 5, 6);
	Array bd = new DoubleArray(d, 2, 3, 4, 5, 6);
	Func f = new DivFn();
	
	private void checkScalar(Array b) {
		assertTrue(b instanceof DoubleScalar);
		assertTrue(1.0/5.0 == b.atD(0));
	}
	
	private void check(Array orig, Array b) {
		assertTrue(b instanceof DoubleArray);
		assertEquals(6, b.length());
		assertEquals(5, b.actualLength());
		assertFalse(orig==b);
		assertTrue(1.0/5.0 == b.atD(1,1));		
	}

	private void check2(Array b) {
		assertTrue(b instanceof DoubleArray);
		assertEquals(6, b.length());
		assertEquals(5, b.actualLength());
		assertTrue(5.0/6.0 == b.atD(1,1));		
	}
	
	@Test
	public void testDiv() {
		checkScalar(f.monadic(si,0));
		checkScalar(f.monadic(sd,0));
		check(ai,f.monadic(ai, 0));
		check(ad,f.monadic(ad, 0));
		check2(f.dyadic(ai, bi, 0));
		check2(f.dyadic(ai, bd, 0));
		check2(f.dyadic(ad, bi, 0));
		check2(f.dyadic(ad, bd, 0));
	}
}
