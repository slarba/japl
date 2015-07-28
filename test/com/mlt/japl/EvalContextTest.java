package com.mlt.japl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.workspace.EvalContext;

public class EvalContextTest {

	@Test
	public void testEvalContext() {
		EvalContext ctx = new EvalContext();
		assertEquals(new IntArray(), ctx.get("\u236c"));
		EvalContext derived = ctx.newFrame();
		assertEquals(new IntArray(), derived.get("\u236c"));		
	}

}
