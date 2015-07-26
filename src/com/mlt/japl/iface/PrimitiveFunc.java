package com.mlt.japl.iface;

/**
 * Primitive function interface
 * 
 * @author mtl
 *
 */
public interface PrimitiveFunc {
	public int I_C(char c);

	public int I_CC(char a, char b);
	
	public double D_D(double d);

	public double D_I(long d);

	public double D_DD(double a, double b);

	public double D_DI(double a, long b);

	public double D_ID(long a, double b);

	public double D_II(long a, long b);

	public long I_D(double d);

	public long I_I(long d);

	public long I_DD(double a, double b);

	public long I_DI(double a, long b);

	public long I_ID(long a, double b);

	public long I_II(long a, long b);

	public long I_CI(char a, long b);

	public long I_IC(long a, char b);

	public long I_CD(char a, double b);

	public long I_DC(double a, char b);
}
