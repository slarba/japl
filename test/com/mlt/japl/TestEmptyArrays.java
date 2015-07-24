package com.mlt.japl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.mlt.japl.arrays.DoubleArray;
import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.arrays.IotaArray;
import com.mlt.japl.arrays.NestedArray;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;

public class TestEmptyArrays {

	private void testEmptyProperties(Array d) {
		assertEquals(1, d.depth());
		assertEquals(1, d.rank());
		assertEquals(0, d.actualLength());
		assertEquals(0, d.length());
		assertNotNull(d.dims());
		assertEquals(d.dims(), Dimensions.EMPTY);		
	}
	
	@Test
	public void testEmptyDoubleArray() {
		testEmptyProperties(new DoubleArray());
	}

	@Test
	public void testEmptyIntArray() {
		testEmptyProperties(new IntArray());
	}

	@Test
	public void testEmptyIotaArray() {
		testEmptyProperties(new IotaArray());
	}

	@Test
	public void testEmptyMixedArray() {
		testEmptyProperties(new NestedArray());
	}
	
}
