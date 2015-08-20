package com.mlt.japl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mlt.japl.arrays.DoubleArray;
import com.mlt.japl.arrays.IntArrayImpl;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;

public class RhoTest extends EvalTestBase {

	@Test
	public void testSimplReshape() {
		Array r = itn.eval("20 25⍴1 1 0 0 1 0 1 1 0 0 0 1");
		assertEquals(Array.BIT, r.type());
		assertEquals(2, r.rank());
		assertEquals(20*25,r.length());
		assertEquals(12,r.actualLength());
		assertEquals(1,r.depth());
		assertEquals(1, r.atI(0));
		assertEquals(1, r.atI(1));
		assertEquals(0, r.atI(2));
	}	

	@Test
	public void testZeroRho() {
		Array r = itn.eval("0⍴0");
		assertTrue(r instanceof IntArrayImpl);
		assertEquals(1, r.rank());
		assertEquals(0, r.length());
	}

	@Test
	public void testSimpleReshape2() {
		Array r = itn.eval("2 3⍴1 2.0 3 4");
		assertEquals(Array.DOUBLE, r.type());
		assertEquals(2, r.rank());
		assertEquals(6,r.length());
		assertEquals(4,r.actualLength());
		assertEquals(1,r.depth());
		assertEquals(new Dimensions(2,3), r.dims());
	}	

	@Test
	public void testMonadicRho() {
		Array r = itn.eval("⍴'foobar'");
		assertEquals(Array.INTEGER, r.type());
		assertEquals(1, r.rank());
		assertEquals(1, r.depth());
		assertEquals(6, r.atI(0));
	}	

	@Test
	public void testMonadicRhoOfReshaped() {
		Array r = itn.eval("⍴2 3⍴'fooba'");
		assertEquals(Array.INTEGER, r.type());
		assertEquals(1, r.rank());
		assertEquals(1, r.depth());
		assertEquals(2, r.length());
		assertEquals(2, r.actualLength());
		assertEquals(2, r.atI(0));
		assertEquals(3, r.atI(1));
	}	
	
	@Test
	public void testRhoScalar() {
		Array r = itn.eval("⍴2");
		assertEquals(Array.INTEGER, r.type());
		assertEquals(1, r.rank());
		assertEquals(0,r.length());
		assertEquals(0,r.actualLength());
		assertEquals(1,r.depth());
	}	
	
	@Test
	public void testDoubleRho() {
		Array r = itn.eval("⍴⍴2");
		assertEquals(Array.INTEGER, r.type());
		assertEquals(1, r.rank());
		assertEquals(1,r.length());
		assertEquals(1,r.actualLength());
		assertEquals(1,r.depth());
		assertEquals(0, r.atI(0));
	}
	
	@Test
	public void testRhoMixed() {
		Array r = itn.eval("2 3⍴(4 5) (6 7)");
		assertEquals(Array.MIXED, r.type());
		assertEquals(2, r.rank());
		assertEquals(6, r.length());
		assertEquals(new Dimensions(2,3), r.dims());
		assertEquals(new IntArrayImpl(4,5), r.atA(0,0));
		assertEquals(new IntArrayImpl(6,7), r.atA(1,0));
	}
	
	@Test
	public void testScalarRho() {
		Array r = itn.eval("5⍴10.2");
		assertTrue(r instanceof DoubleArray);
		assertEquals(5, r.length());
		assertEquals(new DoubleArray(10.2,10.2,10.2,10.2,10.2), r);
	}
}
