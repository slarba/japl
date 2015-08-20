package com.mlt.japl;

import static org.junit.Assert.assertEquals;

import com.mlt.japl.iface.Array;
import com.mlt.japl.workspace.Interpreter;

public class EvalTestBase {

	protected Interpreter itn = new Interpreter(System.out);

	public EvalTestBase() {
		super();
	}

	public Array eval(String s) {
		return itn.eval(s);
	}
	
	public void check(Array a, int type, int rank, int length, int actualLength, int depth) {
		assertEquals(type, a.type());
		assertEquals(rank, a.rank());
		assertEquals(length, a.length());
		assertEquals(actualLength, a.actualLength());
		assertEquals(depth, a.depth());
	}
}