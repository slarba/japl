package com.mlt.japl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mlt.japl.arrays.IntArrayImpl;
import com.mlt.japl.arrays.IotaArray;
import com.mlt.japl.arrays.MultidimIotaArray;
import com.mlt.japl.iface.Array;

public class IotaTest extends EvalTestBase {
//
//	@Test
//	public void testSimpleIota() {
//		Array r = itn.eval("⍳5");
//		assertTrue(r instanceof IotaArray);
//		assertEquals(5, r.length());
//		assertEquals(5, r.actualLength());
//		assertEquals(1, r.rank());
//		assertEquals(1, r.depth());
//	}
//
//	@Test
//	public void testEmptyIota() {
//		Array r = itn.eval("⍳0");
//		assertTrue(r instanceof IntArrayImpl);
//		assertEquals(0, r.length());
//		assertEquals(0, r.actualLength());
//		assertEquals(1, r.rank());
//		assertEquals(1, r.depth());
//	}
//
//	@Test
//	public void testMultidimIota() {
//		Array r = itn.eval("⍳3 4");
//		assertTrue(r instanceof MultidimIotaArray);
//		assertEquals(3*4, r.length());
//		assertEquals(12, r.actualLength());
//		assertEquals(2, r.rank());
//		assertEquals(2, r.depth());
//		assertEquals(new IntArrayImpl(2,2), r.atA(1,1));
//	}
//
//	@Test
//	public void testDyadicIota() {
//		Array r = itn.eval("'marko'⍳'mkx'");
//		assertTrue(r instanceof IntArrayImpl);
//		assertEquals(3, r.length());
//		assertEquals(3, r.actualLength());
//		assertEquals(1, r.atI(0));
//		assertEquals(4, r.atI(1));
//		assertEquals(6, r.atI(2));
//	}
//
//	@Test
//	public void testDyadicIotaWithScalar() {
//		Array r = itn.eval("'marko'⍳'r'");
//		assertTrue(r instanceof IntArrayImpl);
//		assertEquals(1, r.length());
//		assertEquals(1, r.actualLength());
//		assertEquals(3, r.atI(0));
//	}
//
//	@Test
//	public void testDyadicIotaWithNumbers() {
//		Array r = itn.eval("1 3 2 4 5⍳2 7");
//		assertTrue(r instanceof IntArrayImpl);
//		assertEquals(2, r.length());
//		assertEquals(2, r.actualLength());
//		assertEquals(3, r.atI(0));
//		assertEquals(6, r.atI(1));
//	}
	
}
