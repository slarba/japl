package com.mlt.japl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mlt.japl.arrays.BitArray;
import com.mlt.japl.arrays.CharArray;
import com.mlt.japl.arrays.DoubleArray;
import com.mlt.japl.arrays.IntArrayImpl;
import com.mlt.japl.arrays.IotaArray;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.utils.PrintConfig;

public class ReshapeTest {
	Dimensions d = new Dimensions(2,3);
	Dimensions d2 = new Dimensions(2,2);
	
	Dimensions newShape = new Dimensions(4,5);

	@Test
	public void testIntArrayReshape() {
		Array a = new IntArrayImpl(d, 1, 2, 3, 4, 5);
		assertEquals(2, a.rank());
		assertEquals(1, a.depth());
		assertEquals(2*3, a.length());
		assertEquals(5, a.actualLength());
		assertEquals(new Dimensions(2,3), a.dims());
		assertEquals(new IntArrayImpl(new Dimensions(2,3), new long[] {
			1,2,3,
			4,5,1
		}), a);

		// reshape bigger
		Array b = a.reshape(newShape);
		assertTrue(b instanceof IntArrayImpl);
		assertEquals(2, b.rank());
		assertEquals(1, b.depth());
		assertEquals(4*5, b.length());
		assertEquals(6, b.actualLength());   // was reshaped bigger, actual length stays the same
		assertEquals(new Dimensions(4,5), b.dims());
		System.out.println(b.asString(new PrintConfig()));
		assertEquals(new IntArrayImpl(new Dimensions(4,5), new long[] {
			1,2,3,4,5,
			1,1,2,3,4,
			5,1,1,2,3,
			4,5,1,1,2
		}), b);
		
		// reshape smaller
		Array c = b.reshape(d2);
		assertTrue(c instanceof IntArrayImpl);
		assertEquals(2, c.rank());
		assertEquals(1, c.depth());
		assertEquals(2*2, c.length());
		assertEquals(2*2, c.actualLength());
		assertEquals(new Dimensions(2,2), c.dims());
		assertEquals(new IntArrayImpl(new Dimensions(2,2), new long[] {
			1,2,
			3,4
		}), c);
	}
	
	@Test
	public void testDoubleArrayReshape() {
		Array a = new DoubleArray(d, 1, 2, 3, 4, 5);
		assertEquals(2, a.rank());
		assertEquals(1, a.depth());
		assertEquals(2*3, a.length());
		assertEquals(5, a.actualLength());
		assertEquals(new Dimensions(2,3), a.dims());
		assertEquals(new DoubleArray(new Dimensions(2,3), new double[] {
			1,2,3,
			4,5,1
		}), a);

		// reshape bigger
		Array b = a.reshape(newShape);
		assertTrue(b instanceof DoubleArray);
		assertEquals(2, b.rank());
		assertEquals(1, b.depth());
		assertEquals(4*5, b.length());
		assertEquals(6, b.actualLength());   // was reshaped bigger, actual length stays the same
		assertEquals(new Dimensions(4,5), b.dims());
		System.out.println(b.asString(new PrintConfig()));
		assertEquals(new DoubleArray(new Dimensions(4,5), new double[] {
			1,2,3,4,5,
			1,1,2,3,4,
			5,1,1,2,3,
			4,5,1,1,2
		}), b);
		
		// reshape smaller
		Array c = b.reshape(d2);
		assertTrue(c instanceof DoubleArray);
		assertEquals(2, c.rank());
		assertEquals(1, c.depth());
		assertEquals(2*2, c.length());
		assertEquals(2*2, c.actualLength());
		assertEquals(new Dimensions(2,2), c.dims());
		assertEquals(new DoubleArray(new Dimensions(2,2), new double[] {
			1,2,
			3,4
		}), c);
	}

	@Test
	public void testCharArrayReshape() {
		Array a = new CharArray(d, 'a', 'b', 'c', 'd', 'e');
		assertEquals(2, a.rank());
		assertEquals(1, a.depth());
		assertEquals(2*3, a.length());
		assertEquals(5, a.actualLength());
		assertEquals(new Dimensions(2,3), a.dims());
		assertEquals(new CharArray(new Dimensions(2,3), new char[] {
			'a','b','c',
			'd','e','a'
		}), a);

		// reshape bigger
		Array b = a.reshape(newShape);
		assertTrue(b instanceof CharArray);
		assertEquals(2, b.rank());
		assertEquals(1, b.depth());
		assertEquals(4*5, b.length());
		assertEquals(6, b.actualLength());   // was reshaped bigger, actual length stays the same
		assertEquals(new Dimensions(4,5), b.dims());
		System.out.println(b.asString(new PrintConfig()));
		assertEquals(new CharArray(new Dimensions(4,5), new char[] {
			'a','b','c','d','e',
			'a','a','b','c','d',
			'e','a','a','b','c',
			'd','e','a','a','b'
		}), b);
		
		// reshape smaller
		Array c = b.reshape(d2);
		assertTrue(c instanceof CharArray);
		assertEquals(2, c.rank());
		assertEquals(1, c.depth());
		assertEquals(2*2, c.length());
		assertEquals(2*2, c.actualLength());
		assertEquals(new Dimensions(2,2), c.dims());
		assertEquals(new CharArray(new Dimensions(2,2), new char[] {
			'a','b',
			'c','d'
		}), c);
	}

	@Test
	public void testBitArrayReshape() {
		Array a = new BitArray(d, 1, 0, 0, 1, 1);
		assertEquals(2, a.rank());
		assertEquals(1, a.depth());
		assertEquals(2*3, a.length());
		assertEquals(5, a.actualLength());
		assertEquals(new Dimensions(2,3), a.dims());
		assertEquals(new BitArray(new Dimensions(2,3), new long[] {
			1,0,0,
			1,1,1
		}), a);

		// reshape bigger
		Array b = a.reshape(newShape);
		assertTrue(b instanceof BitArray);
		assertEquals(2, b.rank());
		assertEquals(1, b.depth());
		assertEquals(4*5, b.length());
		assertEquals(6, b.actualLength());   // was reshaped bigger, actual length stays the same
		assertEquals(new Dimensions(4,5), b.dims());
		System.out.println(b.asString(new PrintConfig()));
		assertEquals(new BitArray(new Dimensions(4,5), new long[] {
			1,0,0,1,1,
			1,1,0,0,1,
			1,1,1,0,0,
			1,1,1,1,0
		}), b);
		
		// reshape smaller
		Array c = b.reshape(d2);
		assertTrue(c instanceof BitArray);
		assertEquals(2, c.rank());
		assertEquals(1, c.depth());
		assertEquals(2*2, c.length());
		assertEquals(2*2, c.actualLength());
		assertEquals(new Dimensions(2,2), c.dims());
		assertEquals(new BitArray(new Dimensions(2,2), new long[] {
			1, 0,
			0, 1
		}), c);
	}	

	@Test
	public void testIotaArrayReshape() {
		Array a = new IotaArray(d, 5);
		assertEquals(2, a.rank());
		assertEquals(1, a.depth());
		assertEquals(2*3, a.length());
		assertEquals(5, a.actualLength());
		assertEquals(new Dimensions(2,3), a.dims());
		System.out.println(a.asString(new PrintConfig()));
		assertEquals(new IntArrayImpl(new Dimensions(2,3), new long[] {
			1,2,3,
			4,5,1
		}), a);

		// reshape bigger
		Array b = a.reshape(newShape);
		assertTrue(b instanceof IntArrayImpl);
		assertEquals(2, b.rank());
		assertEquals(1, b.depth());
		assertEquals(4*5, b.length());
		assertEquals(6, b.actualLength());   // was reshaped bigger, actual length stays the same
		assertEquals(new Dimensions(4,5), b.dims());
		System.out.println(b.asString(new PrintConfig()));
		assertEquals(new IntArrayImpl(new Dimensions(4,5), new long[] {
			1,2,3,4,5,
			1,1,2,3,4,
			5,1,1,2,3,
			4,5,1,1,2
		}), b);
		
		// reshape smaller
		Array c = b.reshape(d2);
		assertTrue(c instanceof IntArrayImpl);
		assertEquals(2, c.rank());
		assertEquals(1, c.depth());
		assertEquals(2*2, c.length());
		assertEquals(2*2, c.actualLength());
		assertEquals(new Dimensions(2,2), c.dims());
		assertEquals(new IntArrayImpl(new Dimensions(2,2), new long[] {
			1, 2,
			3, 4
		}), c);
	}	

}
