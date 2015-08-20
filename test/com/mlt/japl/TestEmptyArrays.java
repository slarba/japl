package com.mlt.japl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.mlt.japl.arrays.CharArray;
import com.mlt.japl.arrays.DoubleArray;
import com.mlt.japl.arrays.IntArrayImpl;
import com.mlt.japl.arrays.IotaArray;
import com.mlt.japl.arrays.MultidimIotaArray;
import com.mlt.japl.arrays.NestedArrayImpl;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;

public class TestEmptyArrays {

	private void testEmptyProperties(Array d) {
		assertEquals(1, d.depth());
		assertEquals(1, d.rank());
		assertEquals(0, d.actualLength());
		assertEquals(0, d.length());
		assertEquals(false, d.isScalar());
		assertNotNull(d.dims());
		assertEquals(d.dims(), Dimensions.EMPTY_ARRAY);		
	}
	
	@Test
	public void testEmptyDoubleArray() {
		testEmptyProperties(new DoubleArray());
	}

	@Test
	public void testEmptyIntArray() {
		testEmptyProperties(new IntArrayImpl());
	}

	@Test
	public void testEmptyCharArray() {
		testEmptyProperties(new CharArray());
	}
	
	@Test
	public void testEmptyIotaArray() {
		testEmptyProperties(new IotaArray());
	}

	@Test
	public void testEmptyMultidimIotaArray() {
		testEmptyProperties(new MultidimIotaArray());
	}
	
	@Test
	public void testEmptyMixedArray() {
		testEmptyProperties(new NestedArrayImpl());
	}
	
}
