package com.mlt.japl.arrays;

public interface IntArray {

	public long atI(int... indx);
	long atI(int idx);

	void setI(int idx, long val);
}