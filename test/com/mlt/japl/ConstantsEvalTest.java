package com.mlt.japl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mlt.japl.iface.Array;

public class ConstantsEvalTest extends EvalTestBase {

	@Test
	public void testIntScalar() {
		Array r = eval("2");
		check(r, Array.INTEGER, 0, 1, 1, 0);
		assertEquals(2, r.atI(0));
	}

	@Test
	public void testDoubleScalar() {
		Array r = itn.eval("2.1");
		assertEquals(Array.DOUBLE, r.type());
		assertEquals(0,r.depth());
		assertEquals(1,r.length());
		assertEquals(1,r.actualLength());
		assertEquals(0,r.rank());
		assertTrue(2.1== r.atD(0));
	}
	
	@Test
	public void testCharScalar() {
		Array r = itn.eval("'c'");
		assertEquals(Array.CHARACTER, r.type());
		assertEquals(0,r.depth());
		assertEquals(1,r.length());
		assertEquals(1,r.actualLength());
		assertEquals(0,r.rank());
		assertTrue('c'== r.atC(0));
	}

	@Test
	public void testBitScalar() {
		Array r = itn.eval("1");
		assertEquals(Array.BIT, r.type());
		assertEquals(0,r.depth());
		assertEquals(1,r.length());
		assertEquals(1,r.actualLength());
		assertEquals(0,r.rank());
		assertTrue(1== r.atI(0));
	}

	@Test
	public void testIntArray() {
		Array r = itn.eval("2 3 4");
		assertEquals(Array.INTEGER, r.type());
		assertEquals(1,r.depth());
		assertEquals(3,r.length());
		assertEquals(3,r.actualLength());
		assertEquals(1,r.rank());
		assertEquals(2, r.atI(0));
	}

	@Test
	public void testDoubleArray() {
		Array r = itn.eval("2 3.14 4");
		assertEquals(Array.DOUBLE, r.type());
		assertEquals(1,r.depth());
		assertEquals(3,r.length());
		assertEquals(3,r.actualLength());
		assertEquals(1,r.rank());
		assertTrue(3.14==r.atD(1));
	}
	
	@Test
	public void testBitArray() {
		Array r = itn.eval("1 0 1 1 0 0 0 1 1 0 1");
		assertEquals(Array.BIT, r.type());
		assertEquals(1,r.depth());
		assertEquals(11,r.length());
		assertEquals(11,r.actualLength());
		assertEquals(1,r.rank());
		assertEquals(1, r.atB(0));
		assertEquals(0, r.atB(1));
		assertEquals(1, r.atB(2));
		assertEquals(1, r.atB(3));
	}

	@Test
	public void testCharArray() {
		Array r = itn.eval("'foo'");
		assertEquals(Array.CHARACTER, r.type());
		assertEquals(1,r.depth());
		assertEquals(3,r.length());
		assertEquals(3,r.actualLength());
		assertEquals(1,r.rank());
		assertEquals('f', r.atC(0));
		assertEquals('o', r.atC(1));
		assertEquals('o', r.atC(2));
	}
	
	@Test
	public void testMixedArray() {
		Array r = eval("2 'f' 3.14");
		assertEquals(Array.MIXED, r.type());
		assertEquals(1, r.depth());
		assertEquals(2, r.atA(0).atI(0));
		assertEquals('f', r.atA(1).atC(0));
		assertTrue(3.14 == r.atA(2).atD(0));
	}
	
	@Test
	public void testNestedArray() {
		Array r = eval("2 ('f' 4) 3.14");		
		assertEquals(Array.MIXED, r.type());
		assertEquals(2, r.depth());
		assertEquals(2, r.atA(0).atI(0));
		assertEquals('f', r.atA(1).atA(0).atC(0));
		assertEquals(4, r.atA(1).atA(1).atI(0));
		assertTrue(3.14 == r.atA(2).atD(0));
	}
}
