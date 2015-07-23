package com.mlt.japl.iface;

import com.mlt.japl.Dimensions;

public interface Array {
	static final int INTEGER = 1;
	static final int DOUBLE = 2;
	static final int CHARACTER = 3;
	static final int MIXED = 4;

	int type();
	int rank();
	int depth();

	Array atA(int... indx);
	Array atA(int idx);
	
	long atI(int... indx);
	long atI(int idx);

	double atD(int... indx);
	double atD(int idx);

	char atC(int... indx);
	char atC(int idx);

	boolean isScalar();
	boolean isNested();
	
	Dimensions dims();
	int length();
	int actualLength();
	Array reshape(int... newShape);
	Array reshape(Dimensions newShape);
	
	void setI(int idx, long val);
	void setD(int idx, double val);
	void setC(int idx, char val);
	void setA(int idx, Array val);
	Array unInitializedCopy();
	Array morePreciseUnInitializedCopy();
	Array morePreciseUnInitializedCopy(Array b);
}
