package com.mlt.japl;

import static org.junit.Assert.assertEquals;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.workspace.Interpreter;

public class EvalTestBase {

	protected Interpreter itn = new Interpreter(System.out, System.err);

	public EvalTestBase() {
		super();
	}

	public IValue eval(String s) {
		//return itn.eval(s);
		return null;
	}
	
	public void check(IValue a, int type, int rank, int length, int actualLength, int depth) {
		assertEquals(rank, a.rank());
		assertEquals(length, a.length());
		assertEquals(depth, a.depth());
	}
}