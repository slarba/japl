package com.mlt.japl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mlt.japl.arrays.DoubleArray;
import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.arrays.IotaArray;
import com.mlt.japl.arrays.MultidimIotaArray;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;

public class TestNonEmptyArrays {

	Dimensions d = new Dimensions(2,3);

	private void testNonEmptyProperties(Array a) {
		assertEquals(5, a.actualLength());
		assertEquals(6, a.length());
		assertEquals(2, a.rank());
		assertEquals(1, a.depth());		
		assertEquals(false, a.isScalar());
	}

	private void testNonEmptyProperties2(Array a) {
		assertEquals(5, a.actualLength());
		assertEquals(5, a.length());
		assertEquals(1, a.rank());
		assertEquals(1, a.depth());		
		assertEquals(false, a.isScalar());
	}
	
	@Test
	public void testIntArray() {
		testNonEmptyProperties(new IntArray(d, 1, 2, 3, 4, 5));
	}

	@Test
	public void testDoubleArray() {
		testNonEmptyProperties(new DoubleArray(d, 1, 2, 3, 4, 5));
	}

	@Test
	public void testIntArray2() {
		testNonEmptyProperties2(new IntArray(1, 2, 3, 4, 5));
	}

	@Test
	public void testDoubleArray2() {
		testNonEmptyProperties2(new DoubleArray(1, 2, 3, 4, 5));
	}

	@Test
	public void testIotaArray2() {
		testNonEmptyProperties2(new IotaArray(5));
	}

	@Test
	public void testIotaArray() {
		testNonEmptyProperties(new IotaArray(d, 5));
	}
	
}
