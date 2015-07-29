package com.mlt.japl;

import static org.junit.Assert.*;

import org.junit.Test;

public class ModuloTest {

	@Test
	public void test() {
		long dim = 5;
		long coord = 6;
		assertEquals(1, modulo(dim,coord));
	}

	@Test
	public void test3() {
		long dim = 5;
		long coord = 4;
		assertEquals(4, modulo(dim,coord));
	}
	
	@Test
	public void test2() {
		long dim = 5;
		long coord = -1;
		assertEquals(4, modulo(dim,coord));
	}
	
	private long modulo(long dim, long coord) {
		long actual = coord%dim;
		if(actual<0) return dim+actual;
		return actual;
	}
}
