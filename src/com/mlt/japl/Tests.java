package com.mlt.japl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mlt.japl.arrays.DoubleArray;
import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.arrays.NestedArray;
import com.mlt.japl.fns.DivFn;
import com.mlt.japl.fns.MulFn;
import com.mlt.japl.iface.Array;
import com.mlt.japl.iface.Func;
import com.mlt.japl.scalars.DoubleScalar;
import com.mlt.japl.scalars.IntScalar;

public class Tests {

	@Test
	public void testEmptyDimensions() {
		Dimensions d = new Dimensions();
		assertEquals(0, d.length());
		assertEquals(0, d.rank());
	}

	@Test
	public void testNonemptyDimensions() {
		Dimensions d = new Dimensions(3,4,5);
		assertEquals(3*4*5, d.length());
		assertEquals(3, d.rank());
		assertEquals(1*(4*5) + 2*5 + 3, d.calculateIndex(1, 2, 3));
	}
	
	@Test
	public void testEmptyDoubleArray() {
		Array d = new DoubleArray();
		assertEquals(1, d.depth());
		assertEquals(0, d.rank());
		assertEquals(0, d.actualLength());
		assertEquals(0, d.length());
	}
	
	@Test
	public void testDoubleArray() {
		Dimensions d = new Dimensions(2,3);
		Array a = new DoubleArray(d, 1, 2, 3, 4, 5);
		
		assertEquals(5, a.actualLength());
		assertEquals(6, a.length());
		assertEquals(2, a.rank());
		assertEquals(1, a.depth());
		assertTrue(1==a.atD(1,2));
	}
	
	@Test
	public void testDoubleArrayReshape() {
		Dimensions d = new Dimensions(2,3);
		Dimensions newShape = new Dimensions(4,5);
		Array a = new DoubleArray(d, 1, 2, 3, 4, 5);
		Array b = a.reshape(newShape);
		assertEquals(5, b.actualLength());
		assertEquals(4*5, b.length());
		assertEquals(2, b.rank());
		assertEquals(1, b.depth());
		assertTrue(1==a.atD(1,2));		
	}
	
	@Test
	public void testDivFnMonadic() {
		Array a = new IntArray(new Dimensions(2,3), 1, 2, 3, 4, 5, 6);
		Func f = new DivFn();
		Array b = f.monadic(a, 0);
		assertTrue(b instanceof DoubleArray);
		assertEquals(6, b.length());
		assertEquals(6, b.actualLength());
		assertFalse(a==b);
		assertTrue(1.0/5.0 == b.atD(1,1));
	}

	@Test
	public void testDivFnDyadicScalar() {
		Array a = new IntArray(new Dimensions(2,3), 1, 2, 3, 4, 5, 6);
		Array b = new IntScalar(2);
		Func f = new DivFn();
		Array r = f.dyadic(a, b, 0);
		assertTrue(r instanceof DoubleArray);
		assertEquals(6, r.length());
		assertEquals(6, r.actualLength());
		assertFalse(a==r);
		assertFalse(b==r);
		assertTrue(5.0/2 == r.atD(1,1));
	}

	@Test
	public void testDivFnDyadicScalarOnLeft() {
		Array b = new IntArray(new Dimensions(2,3), 1, 2, 3, 4, 5, 6);
		Array a = new IntScalar(2);
		Func f = new DivFn();
		Array r = f.dyadic(a, b, 0);
		assertTrue(r instanceof DoubleArray);
		assertEquals(6, r.length());
		assertEquals(6, r.actualLength());
		assertFalse(a==r);
		assertFalse(b==r);
		assertTrue(2.0/5 == r.atD(1,1));
	}

	@Test
	public void testScalarScalarDiv() {
		Array a = new IntScalar(5);
		Array b = new IntScalar(2);
		Func f = new DivFn();
		Array r = f.dyadic(a, b, 0);
		assertTrue(r instanceof DoubleScalar);
		assertEquals(0, r.length());
		assertEquals(1, r.actualLength());
		assertFalse(a==r);
		assertFalse(b==r);
		System.out.println(r.atD(0));
		assertTrue(5.0/2 == r.atD(0));
	}

	@Test
	public void testIntScalarScalarMul() {
		Array a = new IntScalar(5);
		Array b = new IntScalar(2);
		Func f = new MulFn();
		Array r = f.dyadic(a, b, 0);
		assertTrue(r instanceof IntScalar);
		assertEquals(0, r.length());
		assertEquals(1, r.actualLength());
		assertFalse(a==r);
		assertFalse(b==r);
		assertTrue(10 == r.atI(0));
	}

	@Test
	public void testIntDoubleScalarScalarMul() {
		Array a = new IntScalar(5);
		Array b = new DoubleScalar(2);
		Func f = new MulFn();
		Array r = f.dyadic(a, b, 0);
		assertTrue(r instanceof DoubleScalar);
		assertEquals(0, r.length());
		assertEquals(1, r.actualLength());
		assertFalse(a==r);
		assertFalse(b==r);
		assertTrue(10 == r.atD(0));
	}
	
	@Test
	public void testIntDoubleScalarScalarMul2() {
		Array a = new IntScalar(5);
		Array b = new DoubleScalar(2);
		Func f = new MulFn();
		Array r = f.dyadic(b, a, 0);
		assertTrue(r instanceof DoubleScalar);
		assertEquals(0, r.length());
		assertEquals(1, r.actualLength());
		assertFalse(a==r);
		assertFalse(b==r);
		assertTrue(10 == r.atD(0));
	}

	@Test
	public void testDivFnVectors() {
		Array a = new IntArray(new Dimensions(2,3), 1, 2, 3, 4, 5, 6);
		Array b = new IntArray(new Dimensions(2,3), 2, 3, 4, 5, 6, 7);
		Func f = new DivFn();
		Array r = f.dyadic(a, b, 0);
		assertTrue(r instanceof DoubleArray);
		assertEquals(6, r.length());
		assertEquals(6, r.actualLength());
		assertFalse(a==r);
		assertFalse(b==r);
		assertTrue(5.0/6.0 == r.atD(1,1));
	}

	@Test
	public void testMulFnVectors() {
		Array a = new IntArray(new Dimensions(2,3), 1, 2, 3, 4, 5, 6);
		Array b = new IntArray(new Dimensions(2,3), 2, 3, 4, 5, 6, 7);
		Func f = new MulFn();
		Array r = f.dyadic(a, b, 0);
		assertTrue(r instanceof IntArray);
		assertEquals(6, r.length());
		assertEquals(6, r.actualLength());
		assertFalse(a==r);
		assertFalse(b==r);
		assertTrue(5*6 == r.atI(1,1));
	}

	@Test
	public void testMulFnDoubleVectors() {
		Array a = new IntArray(new Dimensions(2,3), 1, 2, 3, 4, 5, 6);
		Array b = new DoubleArray(new Dimensions(2,3), 2, 3, 4, 5, 6, 7);
		Func f = new MulFn();
		Array r = f.dyadic(a, b, 0);
		assertTrue(r instanceof DoubleArray);
		assertEquals(6, r.length());
		assertEquals(6, r.actualLength());
		assertFalse(a==r);
		assertFalse(b==r);
		assertTrue(5*6 == r.atD(1,1));
	}

	@Test
	public void testMulFnDoubleVectors2() {
		Array a = new IntArray(new Dimensions(2,3), 1, 2, 3, 4, 5, 6);
		Array b = new DoubleArray(new Dimensions(2,3), 2, 3, 4, 5, 6, 7);
		Func f = new MulFn();
		Array r = f.dyadic(b, a, 0);
		assertTrue(r instanceof DoubleArray);
		assertEquals(6, r.length());
		assertEquals(6, r.actualLength());
		assertFalse(a==r);
		assertFalse(b==r);
		assertTrue(5*6 == r.atD(1,1));
	}
	
	@Test
	public void testNestedArray() {
		Array a = new IntScalar(42);
		Array b = new IntArray(new Dimensions(2,3), 4, 5, 6);
		Array c = new NestedArray(new Dimensions(2,3), a, b);
		assertEquals(Array.MIXED, c.type());
		assertEquals(2, c.depth());
		
		Func f = new DivFn();
		Array r = f.monadic(c, 0);
		assertTrue(r instanceof NestedArray);
		assertEquals(2, r.depth());
		assertEquals(6, r.length());
		assertEquals(2, r.actualLength());
		assertTrue(r.atA(0) instanceof DoubleScalar);
		assertTrue(r.atA(1) instanceof DoubleArray);
		assertTrue(1.0/42 == r.atA(0).atD(0));
		assertTrue(1.0/4 == r.atA(1).atD(0));
		assertTrue(1.0/5 == r.atA(1).atD(1));
	}

	@Test
	public void testNestedArrayDyadic() {
		Array a = new NestedArray(new Dimensions(2,3), 
				new IntScalar(42), 
				new IntArray(new Dimensions(2,3), 4, 5, 6));
		Array b = new NestedArray(new Dimensions(2,3), 
				new DoubleScalar(2), 
				new IntArray(new Dimensions(2,3), 5, 6, 7));
		
		Func f = new DivFn();
		Array r = f.dyadic(a, b, 0);
		assertTrue(r instanceof NestedArray);
		assertEquals(2, r.depth());
		assertEquals(2, r.rank());
		assertEquals(6, r.length());
		assertEquals(2, r.actualLength());
		assertTrue(r.atA(0) instanceof DoubleScalar);
		assertTrue(r.atA(1) instanceof DoubleArray);
		assertTrue(21.0==r.atA(0).atD(0));
		assertTrue(4.0/5 == r.atA(1).atD(0));
		assertTrue(5.0/6 == r.atA(1).atD(1));
	}
}
