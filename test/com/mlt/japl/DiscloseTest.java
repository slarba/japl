package com.mlt.japl;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiscloseTest extends EvalTestBase {

	@Test
	public void testDisclose() {
		itn.eval("box ← {ω⌿ ω/ ω ω⍴⍳ω⋆2}");
		itn.eval("{(⍳ω),¨ box ⊃ω⋆÷2} 4 4");
	}

}
