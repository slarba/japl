package com.mlt.japl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mlt.japl.arrays.DoubleArray;
import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.arrays.IotaArray;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;

public class ReshapeTest {
	Dimensions d = new Dimensions(2,3);
	Dimensions newShape = new Dimensions(4,5);

	private void check(Array b) {
		assertEquals(5, b.actualLength());
		assertEquals(4*5, b.length());
		assertEquals(2, b.rank());
		assertEquals(1, b.depth());
		assertEquals(new Dimensions(4,5), b.dims());		
	}
	
	@Test
	public void testDoubleArrayReshape() {
		Array a = new DoubleArray(d, 1, 2, 3, 4, 5);
		Array b = a.reshape(newShape);
		check(b);
		assertTrue(b.atD(1,1)==2);
	}

	@Test
	public void testIntArrayReshape() {
		Array a = new IntArray(d, 1, 2, 3, 4, 5);
		Array b = a.reshape(newShape);
		check(b);
		assertTrue(b.atI(1,1)==2);
	}

	@Test
	public void testIotaArrayReshape() {
		Array a = new IotaArray(d, 5);
		Array b = a.reshape(newShape);
		check(b);
		assertTrue(b.atI(1,1)==2);
	}
	
}
