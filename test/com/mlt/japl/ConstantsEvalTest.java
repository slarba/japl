package com.mlt.japl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mlt.japl.newarrays.interf.IBitArray;
import com.mlt.japl.newarrays.interf.ICharArray;
import com.mlt.japl.newarrays.interf.ICharScalar;
import com.mlt.japl.newarrays.interf.IDoubleArray;
import com.mlt.japl.newarrays.interf.IDoubleScalar;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IIntScalar;
import com.mlt.japl.newarrays.interf.IMixedArray;

public class ConstantsEvalTest extends EvalTestBase {

	@Test
	public void testIntScalar() {
		IIntScalar r = (IIntScalar)eval("2");
		assertEquals(2, r.get());
	}

	@Test
	public void testDoubleScalar() {
		IDoubleScalar r = (IDoubleScalar)itn.eval("2.1");
		assertEquals(0,r.depth());
		assertEquals(0,r.length());
		assertEquals(0,r.rank());
		assertTrue(2.1== r.get());
	}
	
	@Test
	public void testCharScalar() {
		ICharScalar r = (ICharScalar)itn.eval("'c'");
		assertEquals(0,r.depth());
		assertEquals(0,r.length());
		assertEquals(0,r.rank());
		assertTrue('c'== r.get());
	}

	@Test
	public void testBitScalar() {
		IIntScalar r = (IIntScalar)itn.eval("1");
		assertEquals(0,r.depth());
		assertEquals(0,r.length());
		assertEquals(0,r.rank());
		assertTrue(1== r.get());
	}

	@Test
	public void testIntArray() {
		IIntArray r = (IIntArray)itn.eval("2 3 4");
		assertEquals(1,r.depth());
		assertEquals(3,r.length());
		assertEquals(1,r.rank());
		assertEquals(2, r.get(0));
	}

	@Test
	public void testDoubleArray() {
		IDoubleArray r = (IDoubleArray)itn.eval("2 3.14 4");
		assertEquals(1,r.depth());
		assertEquals(3,r.length());
		assertEquals(1,r.rank());
		assertTrue(3.14==r.get(1));
	}
	
	@Test
	public void testBitArray() {
		IBitArray r = (IBitArray)itn.eval("1 0 1 1 0 0 0 1 1 0 1");
		assertEquals(1,r.depth());
		assertEquals(11,r.length());
		assertEquals(1,r.rank());
		assertEquals(1, r.get(0));
		assertEquals(0, r.get(1));
		assertEquals(1, r.get(2));
		assertEquals(1, r.get(3));
	}

	@Test
	public void testCharArray() {
		ICharArray r = (ICharArray)itn.eval("'foo'");
		assertEquals(1,r.depth());
		assertEquals(3,r.length());
		assertEquals(1,r.rank());
		assertEquals('f', r.get(0));
		assertEquals('o', r.get(1));
		assertEquals('o', r.get(2));
	}
	
	@Test
	public void testMixedArray() {
		IMixedArray r = (IMixedArray)eval("2 'f' 3.14");
		assertEquals(1, r.depth());
		assertEquals(2, ((IIntScalar)r.get(0)).get());
		assertEquals('f', ((ICharScalar)r.get(1)).get());
		assertTrue(3.14 == ((IDoubleScalar)r.get(2)).get());
	}
	
	@Test
	public void testNestedArray() {
		IMixedArray r = (IMixedArray)eval("2 ('f' 4) 3.14");		
		assertEquals(2, r.depth());
		assertEquals(2, ((IIntScalar)r.get(0)).get());
		assertEquals('f', ((ICharScalar)((IMixedArray)r.get(1)).get(0)).get());
		//assertEquals(4, r.atA(1).atA(1).atI(0));
		assertTrue(3.14 == ((IDoubleScalar)r.get(2)).get());
	}
}
