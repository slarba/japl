package com.mlt.japl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.arrays.NestedArray;
import com.mlt.japl.iface.Array;
import com.mlt.japl.scalars.ArrayScalar;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.workspace.Interpreter;

public class EvalTest {

	Interpreter itn = new Interpreter();

	@Test
	public void testSimplEvalScalar() {
		Array r = itn.eval("2");
		assertEquals(Array.INTEGER, r.type());
		assertEquals(0,r.depth());
		assertEquals(0,r.length());
		assertEquals(1,r.actualLength());
		assertEquals(0,r.rank());
		assertEquals(2, r.atI(0));
	}

	@Test
	public void testSimplEvalArray() {
		Array r = itn.eval("2 3 4");
		assertEquals(Array.INTEGER, r.type());
		assertEquals(1,r.depth());
		assertEquals(3,r.length());
		assertEquals(3,r.actualLength());
		assertEquals(1,r.rank());
		assertEquals(2, r.atI(0));
	}

	@Test
	public void testSimplEvalBitArray() {
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
	public void testSimplEval() {
		Array r = itn.eval("1+2");
		assertEquals(Array.INTEGER, r.type());
		assertEquals(0,r.depth());
		assertEquals(0,r.length());
		assertEquals(0,r.rank());
		assertEquals(3, r.atI(0));
	}

	@Test
	public void testSimplEval2() {
		Array r = itn.eval("1+2 3.2 4");
		assertEquals(Array.DOUBLE, r.type());
		assertEquals(1,r.depth());
		assertEquals(1,r.rank());
		assertEquals(3,r.length());
		assertTrue(3==r.atD(0));
		assertTrue(4.2==r.atD(1));
		assertTrue(5==r.atD(2));
	}

	@Test
	public void testSimplEval3() {
		Array r = itn.eval("1 + (2 3) 4.2");
		assertEquals(Array.MIXED, r.type());
		assertEquals(2,r.depth());
		assertEquals(2,r.length());
		assertTrue(3==r.atA(0).atI(0));
		assertTrue(4==r.atA(0).atI(1));
		assertTrue(5.2==r.atA(1).atD(0));
	}

	@Test
	public void testSimplEval4() {
		Array r = itn.eval("1 + ((2 3) (4 5)) 4.2");
		assertEquals(Array.MIXED, r.type());
		assertEquals(1,r.rank());
		assertEquals(2,r.length());
		assertEquals(3,r.depth());
		assertTrue(3==r.atA(0).atA(0).atI(0));
		assertTrue(4==r.atA(0).atA(0).atI(1));
		assertTrue(5==r.atA(0).atA(1).atI(0));
		assertTrue(6==r.atA(0).atA(1).atI(1));
		assertTrue(5.2==r.atA(1).atD(0));
	}	

	@Test
	public void testSimplEval5() {
		Array r = itn.eval("1 2 + ((2 3) (4 5)) 4.2");
		assertEquals(Array.MIXED, r.type());
		assertEquals(1,r.rank());
		assertEquals(2,r.length());
		assertEquals(2,r.actualLength());
		assertEquals(3,r.depth());
		assertTrue(3==r.atA(0).atA(0).atI(0));
		assertTrue(4==r.atA(0).atA(0).atI(1));
		assertTrue(5==r.atA(0).atA(1).atI(0));
		assertTrue(6==r.atA(0).atA(1).atI(1));
		assertTrue(6.2==r.atA(1).atD(0));
	}	

	// gol ← { ⊃∨/1 ω ∧ 3 4 = +/ +⌿ 1 0 ¯1 ∘.⊖ 1 0 ¯1 ⌽¨ ⊂ω }
	
	@Test
	public void testSimplEval6() {
		Array r = itn.eval("2 3⍴1 2.0 3 4");
		assertEquals(Array.DOUBLE, r.type());
		assertEquals(2, r.rank());
		assertEquals(6,r.length());
		assertEquals(4,r.actualLength());
		assertEquals(1,r.depth());
		assertEquals(new Dimensions(2,3), r.dims());
	}	

	@Test
	public void testSimplEval7() {
		Array r = itn.eval("⍴'foobar'");
		assertEquals(Array.INTEGER, r.type());
		assertEquals(1, r.rank());
		assertEquals(1, r.depth());
		assertEquals(6, r.atI(0));
	}	

	@Test
	public void testSimplEval8() {
		Array r = itn.eval("⍴2");
		assertEquals(Array.INTEGER, r.type());
		assertEquals(1, r.rank());
		assertEquals(0,r.length());
		assertEquals(0,r.actualLength());
		assertEquals(1,r.depth());
	}	
	
	@Test
	public void testSimplEval9() {
		Array r = itn.eval("⍴⍴2");
		assertEquals(Array.INTEGER, r.type());
		assertEquals(1, r.rank());
		assertEquals(1,r.length());
		assertEquals(1,r.actualLength());
		assertEquals(1,r.depth());
		assertEquals(0, r.atI(0));
	}	

	@Test
	public void testSimplEval10() {
		Array r = itn.eval("20 25⍴1 1 0 0 1 0 1 1 0 0 0 1");
		assertEquals(Array.BIT, r.type());
		assertEquals(2, r.rank());
		assertEquals(20*25,r.length());
		assertEquals(12,r.actualLength());
		assertEquals(1,r.depth());
		assertEquals(1, r.atI(0));
	}	

	@Test
	public void testEnclosedAdd() {
		Array r = itn.eval("1+⊂2 3");
		assertTrue(r instanceof ArrayScalar);
		assertEquals(3, r.atA(0).atI(0));
		assertEquals(4, r.atA(0).atI(1));
	}

	@Test
	public void testZeroRho() {
		Array r = itn.eval("0⍴0");
		assertTrue(r instanceof IntArray);
		assertEquals(1, r.rank());
	}

}
