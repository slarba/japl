package com.mlt.japl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mlt.japl.arrays.BitArray;

public class BitArrayTest {

	@Test
	public void testBitArrayConstruction() {
		BitArray a = new BitArray(1, 0, 1, 0, 0, 1, 1, 0, 1);
		assertEquals(9, a.length());
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
