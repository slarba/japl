package com.mlt.japl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.mlt.japl.tools.Dimensions;

public class DimensionTest {

	@Test
	public void testEmptyDimensions() {
		Dimensions d = new Dimensions();
		assertEquals(0, d.length());
		assertEquals(0, d.rank());
	}

	@Test
	public void testZeroDimensions() {
		Dimensions d = new Dimensions(0);
		assertEquals(0, d.length());
		assertEquals(1, d.rank());
	}
	
	@Test
	public void testNonemptyDimensions() {
		Dimensions d = new Dimensions(3,4,5);
		assertEquals(3*4*5, d.length());
		assertEquals(3, d.rank());
		assertEquals(1*(4*5) + 2*5 + 3, d.calculateIndex(1, 2, 3));
	}

	@Test
	public void testDimensionEquality() {
		Dimensions d = new Dimensions(3,4,5);
		assertEquals(d, d);
		assertNotEquals(d, new Dimensions());
		assertEquals(d, new Dimensions(3,4,5));
		assertNotEquals(d, new Dimensions(3,2,5));
		assertNotEquals(d, new Object());
	}
	
	@Test
	public void testElideRankReduction() {
		Dimensions d = new Dimensions(3,4,5);
		assertEquals(3, d.axis(0));
		assertEquals(4, d.axis(1));
		assertEquals(5, d.axis(2));
		assertEquals(3, d.rank());
		Dimensions e = d.elideAxis(0);
		assertEquals(4, e.axis(0));
		assertEquals(5, e.axis(1));
		assertEquals(2, e.rank());
		Dimensions f = e.elideAxis(1).elideAxis(0);
		assertEquals(0, f.rank());
	}
}
