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
		assertEquals(new Dimensions(3,4,5), d);
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
	
	@Test
	public void testDimensionReverse() {
		Dimensions d = new Dimensions(3,4,5);
		assertEquals(new Dimensions(5,4,3), d.reverse());
		Dimensions e = new Dimensions();
		assertEquals(new Dimensions(), e.reverse());
		Dimensions f = new Dimensions(2);
		assertEquals(new Dimensions(2), f.reverse());
	}
	
	@Test
	public void testDimensionsConcat() {
		Dimensions a = new Dimensions(3,4,5);
		Dimensions b = new Dimensions(2,1);
		Dimensions c = new Dimensions();
		assertEquals(new Dimensions(3,4,5,2,1), a.concat(b));
		assertEquals(a, a.concat(c));
	}
	
	@Test
	public void testOffsetting() {
		Dimensions a = new Dimensions(3,4,5);
		assertEquals(new Dimensions(3,5,7), a.offsetBy(new int[] {0,1,2}));
	}

	@Test
	public void testOffsetting2() {
		Dimensions a = new Dimensions(3,4,5);
		assertEquals(new Dimensions(3,3,3), a.offsetByMinus(new int[] {0,1,2}));
	}

	@Test
	public void testOffsetting3() {
		Dimensions a = new Dimensions(3,4,5);
		assertEquals(new Dimensions(0,0,0), a.offsetByMinus(new int[] {5,5,5}));
	}
	
}
