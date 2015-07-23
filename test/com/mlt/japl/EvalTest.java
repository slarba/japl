package com.mlt.japl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mlt.japl.iface.Array;
import com.mlt.japl.workspace.Interpreter;

public class EvalTest {

	Interpreter itn = new Interpreter();
	
	@Test
	public void testSimplEval() {
		Array r = itn.eval("1+2");
		assertEquals(3, r.atI(0));
	}

	@Test
	public void testSimplEval2() {
		Array r = itn.eval("1+2 3.2 4");
		assertTrue(3==r.atD(0));
		assertTrue(4.2==r.atD(1));
		assertTrue(5==r.atD(2));
	}

	@Test
	public void testSimplEval3() {
		Array r = itn.eval("1 + (2 3) 4.2");
		assertTrue(3==r.atA(0).atI(0));
		assertTrue(4==r.atA(0).atI(1));
		assertTrue(5.2==r.atA(1).atD(0));
	}

	@Test
	public void testSimplEval4() {
		Array r = itn.eval("1 + ((2 3) (4 5)) 4.2");
		assertTrue(3==r.atA(0).atA(0).atI(0));
		assertTrue(4==r.atA(0).atA(0).atI(1));
		assertTrue(5==r.atA(0).atA(1).atI(0));
		assertTrue(6==r.atA(0).atA(1).atI(1));
		assertTrue(5.2==r.atA(1).atD(0));
	}	

	@Test
	public void testSimplEval5() {
		Array r = itn.eval("1 2 + ((2 3) (4 5)) 4.2");
		assertTrue(3==r.atA(0).atA(0).atI(0));
		assertTrue(4==r.atA(0).atA(0).atI(1));
		assertTrue(5==r.atA(0).atA(1).atI(0));
		assertTrue(6==r.atA(0).atA(1).atI(1));
		assertTrue(6.2==r.atA(1).atD(0));
	}	
}
