package com.mlt.japl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mlt.japl.arrays.IntArrayImpl;
import com.mlt.japl.workspace.EvalContext;

public class EvalContextTest {

	@Test
	public void testEvalContext() {
		EvalContext ctx = new EvalContext();
		assertEquals(new IntArrayImpl(), ctx.get("\u236c"));
		EvalContext derived = ctx.newFrame();
		assertEquals(new IntArrayImpl(), derived.get("\u236c"));		
	}

}
