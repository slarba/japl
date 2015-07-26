package com.mlt.japl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mlt.japl.arrays.BitArray;
import com.mlt.japl.iface.Array;
import com.mlt.japl.workspace.Interpreter;

public class GameOfLifeTest {

	Interpreter itn = new Interpreter();
	
	@Test
	public void test() {
		String gol = "gol ← { ⊃∨/1 ω ∧ 3 4 = +/ +⌿ 1 0 ¯1 ∘.⊖ 1 0 ¯1 ⌽¨ ⊂ω }";
		itn.eval(gol);
		itn.eval("R ← ¯1 ⊖ ¯2 ⌽ 5 7 ↑ (3 3 ⍴(⍳9)−1) ∈ 1 2 3 4 7");
		Array result = itn.eval("gol gol gol R");
		assertEquals(2, result.rank());
		assertTrue(result instanceof BitArray);
//		assertEquals(new BitArray(new int[] {
//				 0, 0, 1, 1, 0, 0, 0,
//				 0, 0, 1, 1, 1, 0, 0,
//				 0, 1, 0, 0, 1, 0, 0,
//				 0, 0, 1, 1, 0, 0, 0,
//				 0, 0, 1, 1, 0, 0, 0
//		}, 5, 7)), result);
	}
}
