package com.mlt.japl;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.arrays.NestedArray;
import com.mlt.japl.fns.AddFn;
import com.mlt.japl.iface.Array;
import com.mlt.japl.iface.Func;
import com.mlt.japl.iface.PrimitiveFunc;
import com.mlt.japl.scalars.IntScalar;

@Ignore
public class SpeedTest {

	@Test
	public void test() {
		Array r = new NestedArray(new Array[10000]);
		Array a = new IntArray(new long[10000]);
		Array b = new IntArray(new long[10000]);

		PrimitiveFunc fn = new AddFn();

		long startTime = System.currentTimeMillis();
		for(int x = 0; x<1000; x++) {
			for(int i=0; i<r.length(); i++) {
				r.setA(i, new IntScalar(fn.I_II(a.atI(i), b.atI(i))));
			}			
		}
		long stopTime = System.currentTimeMillis();
		
		System.out.println("Time elapsed: " + (stopTime - startTime));
	}

	@Test
	public void test2() {
		Array r = new IntArray(new long[10000]);
		Array a = new IntArray(new long[10000]);
		Array b = new IntArray(new long[10000]);

		PrimitiveFunc fn = new AddFn();

		long startTime = System.currentTimeMillis();
		for(int x = 0; x<1000; x++) {
			for(int i=0; i<r.length(); i++) {
				r.setI(i, fn.I_II(a.atI(i), b.atI(i)));
			}			
		}
		long stopTime = System.currentTimeMillis();
		
		System.out.println("statically typed with call: Time elapsed: " + (stopTime - startTime));
	}

	@Test
	public void test3() {
		Array r = new IntArray(new long[10000]);
		Array a = new IntArray(new long[10000]);
		Array b = new IntArray(new long[10000]);

		long startTime = System.currentTimeMillis();
		for(int x = 0; x<1000; x++) {
			for(int i=0; i<r.length(); i++) {
				r.setI(i, a.atI(i)+b.atI(i));
			}			
		}
		long stopTime = System.currentTimeMillis();
		
		System.out.println("static no call: Time elapsed: " + (stopTime - startTime));
	}

	@Test
	public void test3_fastest() {
		long[] r = new long[100000];
		long[] a = new long[100000];
		long[] b = new long[100000];
		
		long startTime = System.currentTimeMillis();
		for(int x = 0; x<1000; x++) {
			for(int i=0; i<r.length; i++) {
				r[i] = a[i]+b[i];
			}			
		}
		long stopTime = System.currentTimeMillis();
		
		System.out.println("no indirection at all: Time elapsed: " + (stopTime - startTime));
	}
	
	
	@Test
	public void test4() {
		Array r = new IntArray(new long[10000]);
		Array a = new IntArray(new long[10000]);
		Array b = new IntArray(new long[10000]);

		Func fn = new AddFn();

		long startTime = System.currentTimeMillis();
		for(int x = 0; x<1000; x++) {
			for(int i=0; i<r.length(); i++) {
				r.setA(i, fn.dyadic(a.atA(i), b.atA(i), 0));
			}			
		}
		long stopTime = System.currentTimeMillis();
		
		System.out.println("Fully dynamic: Time elapsed: " + (stopTime - startTime));
	}
	
}
