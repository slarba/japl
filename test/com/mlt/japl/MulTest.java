package com.mlt.japl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mlt.japl.arrays.DoubleArray;
import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.arrays.IotaArray;
import com.mlt.japl.fns.MulFn;
import com.mlt.japl.iface.Array;
import com.mlt.japl.iface.Func;
import com.mlt.japl.tools.Dimensions;

public class MulTest {

	Dimensions d = new Dimensions(2,3);
	Array ai = new IntArray(d, 1, -2, 3, 4, 5);
	Array ad = new DoubleArray(d, 1, -2, 3, 4, 5);
	Array aiota = new IotaArray(d, 5);
	Array bi = new IntArray(d, 2, 3, 4, 5, 6);
	Array bd = new DoubleArray(d, 2, 3, 4, 5, 6);
	Func f = new MulFn();

	private void checkd(Array b) {
		assertTrue(b instanceof DoubleArray);
		assertEquals(6, b.length());
		assertEquals(5, b.actualLength());
		assertTrue(5*6 == b.atD(1,1));		
	}

	private void checki(Array orig, Array b) {
		assertTrue(b instanceof IntArray);
		assertEquals(6, b.length());
		assertEquals(5, b.actualLength());
		assertFalse(orig==b);
		assertEquals(-1, b.atI(1));		
	}
	
	private void check(Array b) {
		assertTrue(b instanceof IntArray);
		assertEquals(6, b.length());
		assertEquals(5, b.actualLength());
		assertTrue(5*6 == b.atI(1,1));		
	}
	
	@Test
	public void testDiv() {
		checki(ai,f.monadic(ai, 0));
		checki(ad,f.monadic(ad, 0));
		check(f.dyadic(ai, bi, 0));
		checkd(f.dyadic(ai, bd, 0));
		checkd(f.dyadic(ad, bi, 0));
		checkd(f.dyadic(ad, bd, 0));
	}
}
