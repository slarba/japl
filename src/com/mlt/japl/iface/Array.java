package com.mlt.japl.iface;

import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.utils.PrintConfig;

/**
 * Interface for all arrays
 * 
 * @author mtl
 *
 */
public interface Array {
	static final int INTEGER = 1;
	static final int DOUBLE = 2;
	static final int CHARACTER = 4;
	static final int BIT = 8;
	static final int NESTED = 16;
	
	int type();
	int rank();
	int depth();

	Array atA(int... indx);
	Array atA(int idx);
	
	long atB(int... indx);
	long atB(int idx);
	
	long atI(int... indx);
	long atI(int idx);

	double atD(int... indx);
	double atD(int idx);

	char atC(int... indx);
	char atC(int idx);

	boolean isScalar();
	boolean isNested();
	boolean isIntegral();
	
	Dimensions dims();
	int length();
	int actualLength();

	Array reshape(int... newShape);
	Array reshape(Dimensions newShape);
	
	void setI(int idx, long val);
	void setD(int idx, double val);
	void setC(int idx, char val);
	void setA(int idx, Array val);
	void setB(int idx, long val);
	
	Array unInitializedCopy();
	Array unInitializedReshapedCopy(Dimensions resultDims);

	String asString(PrintConfig printConfig);
}
