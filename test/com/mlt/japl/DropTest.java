package com.mlt.japl;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.mlt.japl.arrays.IntArrayImpl;
import com.mlt.japl.arrays.NestedArrayImpl;
import com.mlt.japl.errors.RankError;
import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.tools.Dimensions;

public class DropTest extends EvalTestBase {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
//	@Test
//	public void testSimpleDrop() {
//		IValue r = itn.eval("2↓3 4 5 6 7");
//		assertEquals(r, new IntArray(5,6,7));
//	}
//
//	@Test
//	public void testZeroDrop() {
//		Array r = itn.eval("0↓3 4 5 6 7");
//		assertEquals(r, new IntArrayImpl(3,4,5,6,7));
//	}
//
//	@Test
//	public void testAllDrop() {
//		Array r = itn.eval("6↓3 4 5 6 7");
//		assertEquals(r, new IntArrayImpl());
//	}
//
//	@Test
//	public void testSimpleDropFromOtherEnd() {
//		Array r = itn.eval("¯2↓3 4 5 6 7");
//		assertEquals(r, new IntArrayImpl(3,4,5));
//	}
//
//	@Test
//	public void testMultidimDrop() {
//		Array r = itn.eval("¯2 2↓4 5⍴3 4 5 6 7 8");
//		assertEquals(r, new IntArrayImpl(new Dimensions(2, 3), 5, 6, 7, 4, 5, 6));
//	}
//	
//	@Test
//	public void testValenceError() {
//		thrown.expect(ValenceError.class);
//		itn.eval("↓10 20");
//	}
//
//	@Test
//	public void testRankError() {
//		thrown.expect(RankError.class);
//		itn.eval("1↓2 3⍴3 4 5");
//	}
//	
//	@Test
//	public void testDropNestedArray() {
//		Array r = itn.eval("2↓(4 5) (5 6) (7 8)");
//		assertEquals(r, new NestedArrayImpl(new IntArrayImpl(7,8)));
//	}
}
