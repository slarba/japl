package com.mlt.japl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mlt.japl.arrays.BitArray;
import com.mlt.japl.arrays.RotatedArray;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.workspace.Interpreter;

public class GameOfLifeTest {

	Interpreter itn = new Interpreter(System.out);
	
	@Test
	public void test() {
		String gol = "gol ← { ⊃∨/1 ω ∧ 3 4 = +/ +⌿ 1 0 ¯1 ∘.⊖ 1 0 ¯1 ⌽¨ ⊂ω }";
		itn.eval(gol);
		itn.eval("R ← ¯1 ⊖ ¯2 ⌽ 5 7 ↑ (3 3 ⍴(⍳9)−1) ∈ 1 2 3 4 7");
		Array result = itn.eval("gol gol gol R");
		assertEquals(2, result.rank());
		// TODO: this assertion does not succeed. equal does not handle array scalars containing bitarrays
		//assertEquals(Array.BIT, result.type());
		assertEquals(new BitArray(new Dimensions(5,7), new long[] {
				 0, 0, 1, 1, 0, 0, 0,
				 0, 0, 1, 1, 1, 0, 0,
				 0, 1, 0, 0, 1, 0, 0,
				 0, 0, 1, 1, 0, 0, 0,
				 0, 0, 1, 1, 0, 0, 0
		}), result);
	}
}
