package com.mlt.japl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mlt.japl.arrays.BitArray;
import com.mlt.japl.iface.Array;
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

	@Test
	public void testBitArrayAccess() {
		BitArray a = new BitArray(new Dimensions(2,5), 1, 0, 1, 0, 0, 1, 1, 0, 1);
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

	@Test
	public void testBitArrayAccess2() {
		BitArray a = new BitArray(new Dimensions(2,5), 1, 0, 1, 0, 0, 1, 1, 0, 1);
		assertEquals(10, a.length());
		assertEquals(9, a.actualLength());
		assertEquals(1, a.atB(0,0));
		assertEquals(0, a.atB(0,1));
		assertEquals(1, a.atB(0,2));
		assertEquals(0, a.atB(0,3));
		assertEquals(0, a.atB(0,4));
		assertEquals(1, a.atB(1,0));
		assertEquals(1, a.atB(1,1));
		assertEquals(0, a.atB(1,2));
		assertEquals(1, a.atB(1,3));
	}

	@Test
	public void testBitArrayAnd() {
		BitArray a = new BitArray(new Dimensions(2,5), 1, 0, 1, 0, 0, 1, 1, 0, 1);
		Array b = a.and(0);
		assertTrue(b instanceof BitArray);
		assertEquals(1, b.actualLength());
		assertEquals(new Dimensions(2,5), a.dims());
		assertEquals(0, b.atB(0));
		assertEquals(0, b.atB(2));
		assertEquals(0, b.atB(8));
	}

	@Test
	public void testBitArrayOr() {
		BitArray a = new BitArray(new Dimensions(2,5), 1, 0, 1, 0, 0, 1, 1, 0, 1);
		Array b = a.or(1);
		assertTrue(b instanceof BitArray);
		assertEquals(1, b.actualLength());
		assertEquals(new Dimensions(2,5), a.dims());
		assertEquals(1, b.atB(0));
		assertEquals(1, b.atB(2));
		assertEquals(1, b.atB(8));
	}

	@Test
	public void testBitArrayAndVec() {
		BitArray a = new BitArray(new Dimensions(2,5), 1, 0, 1, 0, 0, 1, 1, 0, 0);
		BitArray x = new BitArray(new Dimensions(2,5), 1, 0, 1, 0, 0, 1, 1, 0, 1);
		Array b = a.and(x);
		assertTrue(b instanceof BitArray);
		assertEquals(9, b.actualLength());
		assertEquals(new Dimensions(2,5), a.dims());
		assertEquals(1, b.atB(0));
		assertEquals(0, b.atB(1));
		assertEquals(0, b.atB(8));
	}

	@Test
	public void testBitArrayOrVec() {
		BitArray a = new BitArray(new Dimensions(2,5), 1, 0, 1, 0, 0, 1, 1, 0, 1);
		BitArray x = new BitArray(new Dimensions(2,5), 1, 0, 1, 0, 0, 1, 1, 0, 0);
		Array b = a.or(x);
		assertTrue(b instanceof BitArray);
		assertEquals(9, b.actualLength());
		assertEquals(new Dimensions(2,5), a.dims());
		assertEquals(1, b.atB(0));
		assertEquals(0, b.atB(1));
		assertEquals(1, b.atB(8));
	}
	
	@Test
	public void testBitArrayAndRight() {
		BitArray a = new BitArray(new Dimensions(2,5), 1, 0, 1, 0, 0, 1, 1, 0, 1);
		Array b = a.andRight(0);
		assertTrue(b instanceof BitArray);
		assertEquals(1, b.actualLength());
		assertEquals(new Dimensions(2,5), a.dims());
		assertEquals(0, b.atB(0));
		assertEquals(0, b.atB(2));
		assertEquals(0, b.atB(8));
	}

	@Test
	public void testBitArrayOrRight() {
		BitArray a = new BitArray(new Dimensions(2,5), 1, 0, 1, 0, 0, 1, 1, 0, 1);
		Array b = a.orRight(1);
		assertTrue(b instanceof BitArray);
		assertEquals(1, b.actualLength());
		assertEquals(new Dimensions(2,5), a.dims());
		assertEquals(1, b.atB(0));
		assertEquals(1, b.atB(2));
		assertEquals(1, b.atB(8));
	}

	@Test
	public void testBitArrayNot() {
		BitArray a = new BitArray(new Dimensions(2,5), 1, 0, 1, 0, 0, 1, 1, 0, 1);
		Array b = a.not();
		assertTrue(b instanceof BitArray);
		assertEquals(9, b.actualLength());
		assertEquals(new Dimensions(2,5), a.dims());
		assertEquals(0, b.atB(0));
		assertEquals(1, b.atB(1));
		assertEquals(0, b.atB(8));
	}
	
}
