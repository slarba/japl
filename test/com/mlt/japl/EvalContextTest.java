package com.mlt.japl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mlt.japl.arrays.IntArrayImpl;
import com.mlt.japl.newarrays.concrete.IntArray;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.workspace.EvalContext;

public class EvalContextTest {

	@Test
	public void testEvalContext() {
		EvalContext ctx = new EvalContext();
		assertEquals(new IntArray(Dimensions.EMPTY_ARRAY, new long[0]), ctx.get("\u236c"));
		EvalContext derived = ctx.newFrame();
		assertEquals(new IntArray(Dimensions.EMPTY_ARRAY, new long[0]), derived.get("\u236c"));		
	}

}
