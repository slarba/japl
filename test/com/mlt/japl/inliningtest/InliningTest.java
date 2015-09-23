package com.mlt.japl.inliningtest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mlt.japl.ast.AstNode;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.interf.IDoubleArray;
import com.mlt.japl.workspace.Interpreter;

public class InliningTest {

//	@Test
//	public void test() {
//		double[] testArray = new double[10000];
//
//		long startTime = System.currentTimeMillis();
//		for(int k=0; k<100000; k++) {
//			double[] result = new double[10000];
//			for(int i=0; i<testArray.length; i++) {
//				result[i] = testArray[i] * (testArray[i] + testArray[i]) - Math.abs(testArray[i]);
//			}			
//		}
//		long endTime = System.currentTimeMillis();
//		System.out.println("Test took " + (endTime-startTime) + "ms");
//	}
//
//	@Test
//	public void test3() {
//		double[] testArray = new double[10000];
//		IArr x = new DArr(testArray);
//		MulFunc mul = new MulFunc();
//		AddFunc add = new AddFunc();
//		AbsFunc abs = new AbsFunc();
//		SubFunc sub = new SubFunc();
//
//		long startTime = System.currentTimeMillis();
//		IArr r = sub.apply(mul.apply(x, add.apply(x,x, 0), 0), abs.apply(x, 0), 0);
//		for(int k=0; k<100000; k++) {
//			double[] result = new double[10000];
//			for(int i=0; i<testArray.length; i++) {
//				result[i] = r.get(i);
//			}			
//		}
//		long endTime = System.currentTimeMillis();
//		System.out.println("Test 3 took " + (endTime-startTime) + "ms");
//		
//	}
//	@Test
//	public void test2() {
//		// (x*(x+x))-Math.abs(x)
//		Interpreter i = new Interpreter(System.out, System.err);
//		double[] testArray = new double[10000];
//		i.define("x", testArray);
//		AstNode n = i.parse("(x×(x+x))−∣x");
//		System.out.println(n.print());
//
//		long startTime = System.currentTimeMillis();
//		IDoubleArray res = (IDoubleArray)i.eval(n);
//		for(int k=0; k<100000; k++) {
//			double[] result = new double[10000];
//			for(int j=0; j<10000; j++) {
//				result[j] = res.get(j);
//			}
//		}
//		long endTime = System.currentTimeMillis();
//		System.out.println("Test 2 took " + (endTime-startTime) + "ms");
//	}
}
