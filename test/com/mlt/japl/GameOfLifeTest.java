package com.mlt.japl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mlt.japl.workspace.Interpreter;

public class GameOfLifeTest {

	Interpreter itn = new Interpreter(System.out, System.err);
//	
//	@Test
//	public void test() {
//		String gol = "gol ← { ⊃∨/1 ω ∧ 3 4 = +/ +⌿ 1 0 ¯1 ∘.⊖ 1 0 ¯1 ⌽¨ ⊂ω }";
//		itn.eval(gol);
//		itn.eval("R ← ¯1 ⊖ ¯2 ⌽ 5 7 ↑ (3 3 ⍴(⍳9)−1) ∈ 1 2 3 4 7");
//		Array result = itn.eval("gol gol gol R");
//		assertEquals(2, result.rank());
//		assertEquals(Array.BIT, result.type());
//		assertEquals(new BitArray(new Dimensions(5,7), new long[] {
//				 0, 0, 1, 1, 0, 0, 0,
//				 0, 0, 1, 1, 1, 0, 0,
//				 0, 1, 0, 0, 1, 0, 0,
//				 0, 0, 1, 1, 0, 0, 0,
//				 0, 0, 1, 1, 0, 0, 0
//		}), result);
//	}
}
