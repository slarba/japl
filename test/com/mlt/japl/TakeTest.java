package com.mlt.japl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.mlt.japl.arrays.CharArray;
import com.mlt.japl.arrays.IntArrayImpl;
import com.mlt.japl.errors.RankError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.scalars.IntScalar;
import com.mlt.japl.tools.Dimensions;

public class TakeTest extends EvalTestBase {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testSimpleTake() {
		Array r = itn.eval("2↑4 5 6 7 8");
		assertEquals(new IntArrayImpl(4,5), r);
	}

	@Test
	public void testTakeScalar() {
		Array r = itn.eval("3↑2");
		assertEquals(new IntArrayImpl(2,0,0), r);
	}

	@Test
	public void testTakeScalarChar() {
		Array r = itn.eval("3↑'f'");
		assertEquals(new CharArray("f  "), r);
	}
	
	@Test
	public void testFirst() {
		Array r = itn.eval("↑2");
		assertTrue(r instanceof IntScalar);
		assertEquals(r, new IntScalar(2));
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
		assertEquals(r, new IntArrayImpl(new Dimensions(4,4), 
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
	public void testRankError() {
		thrown.expect(RankError.class);
		itn.eval("5↑3 3⍴'abcdefghijkl'");
	}
	
	@Test
	public void testMultiDimSmaller() {
		Array r = itn.eval("2 ¯2↑4 4⍴1 2 3 4 5");
		assertEquals(r.dims(), new Dimensions(2,2));
		assertEquals(r.actualLength(), 4);
		assertEquals(r, new IntArrayImpl(new Dimensions(2,2), 
				3, 4,
				2, 3));
	}
}
