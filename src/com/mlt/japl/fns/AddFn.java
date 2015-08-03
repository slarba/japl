package com.mlt.japl.fns;

import com.mlt.japl.iface.Array;

public class AddFn extends PrimitiveBaseFn {
	
	@Override
	public double D_DD(double a, double b) { return a+b; }
	@Override
	public double D_DI(double a, long b) { return a+b; }
	@Override
	public double D_ID(long a, double b) { return a+b; }
	@Override
	public long I_II(long a, long b) { return a+b; }

//	public void innerloop_D_DD(double[] result, double[] a, double[] b) {
//		for(int i=0; i<result.length; i++) result[i] = a[i] + b[i];
//	}
//	public void innerloop_D_DI(double[] result, double[] a, long[] b) {
//		for(int i=0; i<result.length; i++) result[i] = a[i] + b[i];
//	}
//	public void innerloop_D_ID(double[] result, long[] a, double[] b) {
//		for(int i=0; i<result.length; i++) result[i] = a[i] + b[i];
//	}
//	public void innerloop_I_II(long[] result, long[] a, long[] b) {
//		for(int i=0; i<result.length; i++) result[i] = a[i] + b[i];
//	}
//	public void innerloop_D_DD(double[] result, double[] a, double b) {
//		for(int i=0; i<result.length; i++) result[i] = a[i] + b;
//	}
//	public void innerloop_D_DI(double[] result, double[] a, long b) {
//		for(int i=0; i<result.length; i++) result[i] = a[i] + b;
//	}
//	public void innerloop_D_ID(double[] result, long[] a, double b) {
//		for(int i=0; i<result.length; i++) result[i] = a[i] + b;
//	}
//	public void innerloop_I_II(long[] result, long[] a, long b) {
//		for(int i=0; i<result.length; i++) result[i] = a[i] + b;
//	}
//	public void innerloop_D_DD(double[] result, double a, double[] b) {
//		for(int i=0; i<result.length; i++) result[i] = a + b[i];
//	}
//	public void innerloop_D_DI(double[] result, double a, long[] b) {
//		for(int i=0; i<result.length; i++) result[i] = a + b[i];
//	}
//	public void innerloop_D_ID(double[] result, long a, double[] b) {
//		for(int i=0; i<result.length; i++) result[i] = a + b[i];
//	}
//	public void innerloop_I_II(long[] result, long a, long[] b) {
//		for(int i=0; i<result.length; i++) result[i] = a + b[i];
//	}
		
	@Override
	public Array monadic(Array a, int axis) {
		return a;
	}

	@Override
	public String getName() {
		return "+";
	}
}
