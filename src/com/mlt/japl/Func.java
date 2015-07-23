package com.mlt.japl;

public interface Func {
	double D_D(double d);
	double D_I(long d);
	long I_D(double d);
	long I_I(long d);
	
	double D_DD(double a, double b);
	double D_DI(double a, long b);
	double D_ID(long a, double b);
	double D_II(long a, long b);

	long I_DD(double a, double b);
	long I_DI(double a, long b);
	long I_ID(long a, double b);
	long I_II(long a, long b);
	
	Array monadic(Array a, int axis);
	Array dyadic(Array a, Array b, int axis);
}
