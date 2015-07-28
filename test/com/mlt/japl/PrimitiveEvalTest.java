package com.mlt.japl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.iface.Array;
import com.mlt.japl.scalars.ArrayScalar;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.workspace.Interpreter;

public class PrimitiveEvalTest {

	Interpreter itn = new Interpreter(System.out);
	
	@Test
	public void testScalarSum() {
		Array r = itn.eval("1+2");
		assertEquals(Array.INTEGER, r.type());
		assertEquals(0,r.depth());
		assertEquals(0,r.length());
		assertEquals(0,r.rank());
		assertEquals(3, r.atI(0));
	}

	@Test
	public void testScalarSum2() {
		Array r = itn.eval("1+2.1");
		assertEquals(Array.DOUBLE, r.type());
		assertEquals(0,r.depth());
		assertEquals(0,r.length());
		assertEquals(0,r.rank());
		assertTrue(3.1==r.atD(0));
	}

	@Test
	public void testScalarSum3() {
		Array r = itn.eval("1.1+2");
		assertEquals(Array.DOUBLE, r.type());
		assertEquals(0,r.depth());
		assertEquals(0,r.length());
		assertEquals(0,r.rank());
		assertTrue(3.1==r.atD(0));
	}
	
	@Test
	public void testScalarArray() {
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
	public void testScalarArray2() {
		Array r = itn.eval("2 3.2 4+1");
		assertEquals(Array.DOUBLE, r.type());
		assertEquals(1,r.depth());
		assertEquals(1,r.rank());
		assertEquals(3,r.length());
		assertTrue(3==r.atD(0));
		assertTrue(4.2==r.atD(1));
		assertTrue(5==r.atD(2));
	}
	
	@Test
	public void testScalarNested() {
		Array r = itn.eval("1 + (2 3) 4.2");
		assertEquals(Array.NESTED, r.type());
		assertEquals(2,r.depth());
		assertEquals(2,r.length());
		assertTrue(3==r.atA(0).atI(0));
		assertTrue(4==r.atA(0).atI(1));
		assertTrue(5.2==r.atA(1).atD(0));
	}

	@Test
	public void testNestedScalar() {
		Array r = itn.eval("(2 3) 4.2+1");
		assertEquals(Array.NESTED, r.type());
		assertEquals(2,r.depth());
		assertEquals(2,r.length());
		assertTrue(3==r.atA(0).atI(0));
		assertTrue(4==r.atA(0).atI(1));
		assertTrue(5.2==r.atA(1).atD(0));
	}
	
	@Test
	public void testDeeplyNested() {
		Array r = itn.eval("1 + ((2 3) (4 5)) 4.2");
		assertEquals(Array.NESTED, r.type());
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
	public void testDeeplyNested2() {
		Array r = itn.eval("((2 3) (4 5)) 4.2+1");
		assertEquals(Array.NESTED, r.type());
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
	public void testVectorAdd() {
		Array r = itn.eval("1 2 3 + 3 4 5");
		assertEquals(Array.INTEGER, r.type());
		assertEquals(1,r.rank());
		assertEquals(3,r.length());
		assertEquals(3,r.actualLength());
		assertEquals(1,r.depth());
		assertTrue(4==r.atI(0));
		assertTrue(6==r.atI(1));
		assertTrue(8==r.atI(2));
	}	
	
	@Test
	public void testVectorNested() {
		Array r = itn.eval("1 2 + ((2 3) (4 5)) 4.2");
		assertEquals(Array.NESTED, r.type());
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

	@Test
	public void testNestedVector() {
		Array r = itn.eval("((2 3) (4 5)) 4.2 + 1 2");
		assertEquals(Array.NESTED, r.type());
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

	@Test
	public void testScalarMonadic() {
		Array r = itn.eval("−2");
		assertEquals(Array.INTEGER, r.type());
		assertEquals(0,r.rank());
		assertEquals(0,r.length());
		assertEquals(1,r.actualLength());
		assertEquals(0,r.depth());
		assertTrue(-2==r.atI(0));
	}	

	@Test
	public void testVectorMonadic() {
		Array r = itn.eval("−2 3");
		assertEquals(Array.INTEGER, r.type());
		assertEquals(1,r.rank());
		assertEquals(2,r.length());
		assertEquals(2,r.actualLength());
		assertEquals(1,r.depth());
		assertTrue(-2==r.atI(0));
		assertTrue(-3==r.atI(1));
	}	

	@Test
	public void testNestedMonadic() {
		Array r = itn.eval("−(2 4) 3");
		assertEquals(Array.NESTED, r.type());
		assertEquals(1,r.rank());
		assertEquals(2,r.length());
		assertEquals(2,r.actualLength());
		assertEquals(2,r.depth());
		assertTrue(-2==r.atA(0).atI(0));
		assertTrue(-4==r.atA(0).atI(1));
		assertTrue(-3==r.atA(1).atI(0));
	}	

	@Test
	public void testDeeplyMonadic() {
		Array r = itn.eval("−(2 (4 5)) 3");
		assertEquals(Array.NESTED, r.type());
		assertEquals(1,r.rank());
		assertEquals(2,r.length());
		assertEquals(2,r.actualLength());
		assertEquals(3,r.depth());
		assertTrue(-2==r.atA(0).atA(0).atI(0));
		assertTrue(-4==r.atA(0).atA(1).atI(0));
		assertTrue(-5==r.atA(0).atA(1).atI(1));
		assertTrue(-3==r.atA(1).atI(0));
	}	
	
	// gol ← { ⊃∨/1 ω ∧ 3 4 = +/ +⌿ 1 0 ¯1 ∘.⊖ 1 0 ¯1 ⌽¨ ⊂ω }
	
	@Test
	public void testEnclosedAdd() {
		Array r = itn.eval("1+⊂2 3");
		assertTrue(r instanceof ArrayScalar);
		assertEquals(3, r.atA(0).atI(0));
		assertEquals(4, r.atA(0).atI(1));
	}

	@Test
	public void testEnclosing() {
		
	}
	

}
