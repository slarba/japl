package com.mlt.japl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mlt.japl.arrays.CharArray;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.utils.PrintConfig;

public class RotateTest extends EvalTestBase {

	@Test
	public void testRotations() {
		//⌽⊖
		Array result = itn.eval("1⌽3 3⍴'abcdefghi'");
		assertEquals(result, new CharArray(new Dimensions(3,3),"bcaefdhig"));
	}

	@Test
	public void testRotations2() {
		//⌽⊖
		Array result = itn.eval("1⊖3 3⍴'abcdefghi'");
		assertEquals(result, new CharArray(new Dimensions(3,3),"defghiabc"));
	}

	@Test
	public void testRotations3() {
		//⌽⊖
		Array result = itn.eval("1⌽1⊖3 3⍴'abcdefghi'");
		assertEquals(result, new CharArray(new Dimensions(3,3),"efdhigbca"));
	}

	@Test
	public void testRotations4() {
		//⌽⊖
		Array result = itn.eval("0⌽0⊖3 3⍴'abcdefghi'");
		assertEquals(result, new CharArray(new Dimensions(3,3),"abcdefghi"));
	}
	
	@Test
	public void testRotations5() {
		//⌽⊖
		Array result = itn.eval("¯1⌽1⊖3 3⍴'abcdefghi'");
		assertEquals(result, new CharArray(new Dimensions(3,3),"fdeighcab"));
	}

	@Test
	public void testRotations6() {
		//⌽⊖
		Array result = itn.eval("¯1⌽¯1⊖3 3⍴'abcdefghi'");
		assertEquals(result, new CharArray(new Dimensions(3,3),"ighcabfde"));
	}	
}
