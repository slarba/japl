package com.mlt.japl;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mlt.japl.arrays.NestedArrayImpl;
import com.mlt.japl.iface.Array;

public class DiscloseTest extends EvalTestBase {

	@Test
	public void testDisclose() {
		itn.eval("box ← {ω⌿ ω/ ω ω⍴⍳ω⋆2}");
		itn.eval("rcb ← {(⍳ω),¨ box ⊃ω⋆÷2}");
		Array result = itn.eval("{1 ∈¨ ω = ⊂3 3 4} rcb 4 4");
	
		assertTrue(result instanceof NestedArrayImpl);
	}

}
