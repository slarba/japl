package com.mlt.japl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mlt.japl.arrays.DoubleArray;
import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.arrays.NestedArray;
import com.mlt.japl.fns.DivFn;
import com.mlt.japl.fns.MulFn;
import com.mlt.japl.iface.Array;
import com.mlt.japl.iface.Func;
import com.mlt.japl.scalars.DoubleScalar;
import com.mlt.japl.scalars.IntScalar;
import com.mlt.japl.tools.Dimensions;

public class NestedTest {

	@Test
	public void testNestedArray() {
		Array a = new IntScalar(42);
		Array b = new IntArray(new Dimensions(2,3), 4, 5, 6);
		Array c = new NestedArray(new Dimensions(2,3), a, b);
		assertEquals(Array.MIXED, c.type());
		assertEquals(2, c.depth());
		
		Func f = new DivFn();
		Array r = f.monadic(c, 0);
		assertTrue(r instanceof NestedArray);
		assertEquals(2, r.depth());
		assertEquals(6, r.length());
		assertEquals(2, r.actualLength());
		assertTrue(r.atA(0) instanceof DoubleScalar);
		assertTrue(r.atA(1) instanceof DoubleArray);
		assertTrue(1.0/42 == r.atA(0).atD(0));
		assertTrue(1.0/4 == r.atA(1).atD(0));
		assertTrue(1.0/5 == r.atA(1).atD(1));
	}

	@Test
	public void testNestedArrayDyadic() {
		Array a = new NestedArray(new Dimensions(2,3), 
				new IntScalar(42), 
				new IntArray(new Dimensions(2,3), 4, 5, 6));
		Array b = new NestedArray(new Dimensions(2,3), 
				new DoubleScalar(2), 
				new IntArray(new Dimensions(2,3), 5, 6, 7));
		
		Func f = new DivFn();
		Array r = f.dyadic(a, b, 0);
		assertTrue(r instanceof NestedArray);
		assertEquals(2, r.depth());
		assertEquals(2, r.rank());
		assertEquals(6, r.length());
		assertEquals(2, r.actualLength());
		assertTrue(r.atA(0) instanceof DoubleScalar);
		assertTrue(r.atA(1) instanceof DoubleArray);
		assertTrue(21.0==r.atA(0).atD(0));
		assertTrue(4.0/5 == r.atA(1).atD(0));
		assertTrue(5.0/6 == r.atA(1).atD(1));
	}
}
