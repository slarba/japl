package com.mlt.japl;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.mlt.japl.arrays.CharArray;
import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.arrays.NestedArray;
import com.mlt.japl.errors.IndexError;
import com.mlt.japl.errors.LengthError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;

public class RavelTest extends EvalTestBase {
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testSimpleArrayRavel() {
		Array r = itn.eval(",2 3⍴1 2 3 4 5 6");
		assertTrue(r instanceof IntArray);
		assertEquals(new Dimensions(6), r.dims());
		assertEquals(new IntArray(1,2,3,4,5,6), r);
	}

	@Test
	public void testSimpleArrayLaminate() {
		Array r = itn.eval("1 2 3,4 5 6");
		assertTrue(r instanceof IntArray);
		assertEquals(new Dimensions(6), r.dims());
		assertEquals(new IntArray(1,2,3,4,5,6), r);
	}
	
	@Test
	public void testSimpleCharArrayLaminate() {
		Array r = itn.eval("'mar','ko'");
		assertTrue(r instanceof CharArray);
		assertEquals(new Dimensions(5), r.dims());
		assertEquals(new CharArray("marko"), r);
	}

	@Test
	public void testChainedArrayLaminate() {
		Array r = itn.eval("1 2, 3 4, 5 6");
		assertTrue(r instanceof IntArray);
		assertEquals(new Dimensions(6), r.dims());
		assertEquals(new IntArray(1,2,3,4,5,6), r);
	}

	@Test
	public void testLaminateMultidim() {
		Array r = itn.eval("(2 3⍴1 2 3 4 5 6),(2 2⍴1 2 3 4 5 6)");
		assertTrue(r instanceof IntArray);
		assertEquals(new Dimensions(2,5), r.dims());
		assertEquals(new IntArray(new Dimensions(2,5), 
				1,2,3,1,2,
				4,5,6,3,4), r);
	}

	@Test
	public void testLaminateMultidimWithAxis() {
		Array r = itn.eval("(2 3⍴1 2 3 4 5 6),[1](2 3⍴1 2 3 4 5 6)");
		assertTrue(r instanceof IntArray);
		assertEquals(new Dimensions(4,3), r.dims());
		assertEquals(new IntArray(new Dimensions(4,3), 
				1,2,3,
				4,5,6,
				1,2,3,
				4,5,6), r);
	}

	@Test
	public void testLaminateErrorWithIncompatibleAxes() {
		thrown.expect(IndexError.class);
		itn.eval("(2 4⍴1 2 3 4 5 6),[1](2 3⍴1 2 3 4 5 6)");
	}
	
	@Test
	public void testLaminateScalars() {
		Array r = itn.eval("2,3");
		assertTrue(r instanceof IntArray);
		assertEquals(new Dimensions(2), r.dims());
	}

	@Test
	public void testLaminateScalarsLeft() {
		Array r = itn.eval("2,3 4");
		assertTrue(r instanceof IntArray);
		assertEquals(new Dimensions(3), r.dims());
	}

	@Test
	public void testLaminateScalarsRight() {
		Array r = itn.eval("2 3, 4");
		assertTrue(r instanceof IntArray);
		assertEquals(new Dimensions(3), r.dims());
	}

	@Test
	public void testLaminateNested() {
		Array r = itn.eval("(2 3) (4 5),(6 4) (7 8)");
		assertTrue(r instanceof NestedArray);
		assertEquals(new Dimensions(4), r.dims());
		assertEquals(new IntArray(4,5), r.atA(1));
		assertEquals(new IntArray(6,4), r.atA(2));
	}
	
}
