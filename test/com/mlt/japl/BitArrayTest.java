package com.mlt.japl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mlt.japl.arrays.BitArray;
import com.mlt.japl.tools.Dimensions;

public class BitArrayTest {

	@Test
	public void testBitArrayConstruction() {
		BitArray a = new BitArray(new Dimensions(10), 1, 0, 1, 0, 0, 1, 1, 0, 1);
		assertEquals(10, a.length());
		assertEquals(9, a.actualLength());
		assertEquals(1, a.atB(0));
		assertEquals(0, a.atB(1));
		assertEquals(1, a.atB(2));
		assertEquals(0, a.atB(3));
		assertEquals(0, a.atB(4));
		assertEquals(1, a.atB(5));
		assertEquals(1, a.atB(6));
		assertEquals(0, a.atB(7));
		assertEquals(1, a.atB(8));
	}

}
