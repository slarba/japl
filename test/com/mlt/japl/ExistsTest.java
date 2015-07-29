package com.mlt.japl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mlt.japl.arrays.BitArray;
import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.iface.Array;
import com.mlt.japl.scalars.IntScalar;

public class ExistsTest extends EvalTestBase {

	@Test
	public void testExists() {
		Array r = itn.eval("'mrx'∈'marko'");
		assertTrue(r instanceof BitArray);
		assertEquals(3, r.length());
		assertEquals(1, r.atB(0));
		assertEquals(1, r.atB(1));
		assertEquals(0, r.atB(2));
	}

	@Test
	public void testExistsWithScalar() {
		Array r = itn.eval("'x'∈'marko'");
		assertTrue(r instanceof IntScalar);
		assertEquals(0, r.atI(0));
	}
	
	@Test
	public void testExistsWithScalarFound() {
		Array r = itn.eval("'r'∈'marko'");
		assertTrue(r instanceof IntScalar);
		assertEquals(1, r.atI());
	}

	@Test
	public void testExistsWithRightScalar() {
		Array r = itn.eval("'xr'∈'r'");
		assertTrue(r instanceof BitArray);
		assertEquals(0, r.atI(0));
		assertEquals(1, r.atI(1));
	}

	@Test
	public void testExistsWithRightScalarFound() {
		Array r = itn.eval("'r'∈'r'");
		assertTrue(r instanceof IntScalar);
		assertEquals(1, r.atI(0));
	}

	@Test
	public void testNestedArrayHashcode() {
		Array a = itn.eval("(4 5) (9 9)");
		Array b = itn.eval("(4 5) (9 9)");
		assertEquals(a,b);
		assertEquals(a.hashCode(), b.hashCode());
	}
	
	@Test
	public void testExistsWithNestedArrays() {
		Array r = itn.eval("(4 5) (9 9)∈(2 3) (4 5) (6 7)");
		assertTrue(r instanceof BitArray);
		assertEquals(1, r.atI(0));
		assertEquals(0, r.atI(1));
	}
	
}
