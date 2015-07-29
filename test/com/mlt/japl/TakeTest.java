package com.mlt.japl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mlt.japl.arrays.CharArray;
import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.iface.Array;
import com.mlt.japl.scalars.IntScalar;
import com.mlt.japl.tools.Dimensions;

public class TakeTest extends EvalTestBase {

	@Test
	public void testSimpleTake() {
		Array r = itn.eval("2↑4 5 6 7 8");
		assertEquals(new IntArray(4,5), r);
	}

	@Test
	public void testTakeScalar() {
		Array r = itn.eval("3↑2");
		assertEquals(new IntArray(2,0,0), r);
	}
	
	@Test
	public void testFirst() {
		Array r = itn.eval("↑2");
		assertTrue(r instanceof IntScalar);
	}
	
	@Test
	public void testFirst2() {
		Array r = itn.eval("↑2 3 4");
		assertTrue(r instanceof IntScalar);
		assertEquals(2, r.atI(0));
	}

	@Test
	public void testMultiDimLarger() {
		Array r = itn.eval("4 4↑2 2⍴1 2 3 4");
		assertEquals(r.dims(), new Dimensions(4,4));
		assertEquals(r.actualLength(), 16);
		assertEquals(r, new IntArray(new Dimensions(4,4), 
				1, 2, 0, 0,
				3, 4, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0));
	}

	@Test
	public void testMultiDimChar() {
		Array r = itn.eval("3 ¯3↑5 5⍴'abcdefghijkl'");
		assertEquals(r, new CharArray(new Dimensions(3,3), "cdehijabc"));
	}

	@Test
	public void testMultiDimCharPadding() {
		Array r = itn.eval("5 5↑3 3⍴'abcdefghijkl'");
		assertEquals(r, new CharArray(new Dimensions(5,5), "abc  def  ghi            "));
	}
	
	@Test
	public void testMultiDimSmaller() {
		Array r = itn.eval("2 ¯2↑4 4⍴1 2 3 4 5");
		assertEquals(r.dims(), new Dimensions(2,2));
		assertEquals(r.actualLength(), 4);
		assertEquals(r, new IntArray(new Dimensions(2,2), 
				3, 4,
				2, 3));
	}
}
