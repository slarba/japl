package com.mlt.japl.iface;

import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.utils.PrintConfig;

/**
 * Interface for arrays
 * 
 * @author mtl
 *
 */
public interface Array {
	/**
	 * Integer elements
	 */
	static final int INTEGER = 1;

	/**
	 * Double precision elements
	 */
	static final int DOUBLE = 2;

	/**
	 * Character elements
	 */
	static final int CHARACTER = 4;
	
	/**
	 * Bit elements
	 */
	static final int BIT = 8;

	/**
	 * Nested elements of any other type, including arrays
	 */
	static final int NESTED = 16;

	/**
	 * Get element type of this array
	 * 
	 * @return int element type
	 */
	int type();
	
	/**
	 * Get rank (number of dimensions)
	 * 
	 * @return int number of dimensions (rank)
	 */
	int rank();
	
	/**
	 * Get nesting level. Scalars have depth 0, primitive arrays 1, nested arrays have N where 
	 * N is the deepest nesting level
	 * 
	 * @return int nesting level
	 */
	int depth();

	/**
	 * Access array element as a nested element. Note that you can use this method for non-nested arrays too.
	 * In that case it will return just boxed scalar representing the value at the given index.
	 * 
	 * @param indx array of indices
	 * @return Array object
	 */
	Array atA(int... indx);
	
	/**
	 * Access array element as a nested element
	 * @param idx raw index
	 * @return Array object
	 */
	Array atA(int idx);
	
	/**
	 * Access array element as a bit
	 * @param indx raw index
	 * @return long 1 or 0
	 */
	long atB(int... indx);

	/**
	 * Access array element as a bit
	 * @param idx raw index
	 * @return long 1 or 0
	 */
	long atB(int idx);
	
	/**
	 * Access array element as a integer
	 * @param indx raw index
	 * @return long
	 */
	long atI(int... indx);
	/**
	 * Access array element as a integer
	 * @param idx raw index
	 * @return long
	 */
	long atI(int idx);

	/**
	 * Access array element as a double
	 * @param indx raw index
	 * @return double
	 */
	double atD(int... indx);
	/**
	 * Access array element as a double
	 * @param idx raw index
	 * @return long
	 */
	double atD(int idx);

	/**
	 * Access array element as a char
	 * @param indx raw index
	 * @return char
	 */
	char atC(int... indx);
	/**
	 * Access array element as a char
	 * @param idx raw index
	 * @return char
	 */
	char atC(int idx);

	/**
	 * Check if this array is a scalar (ie. rank is 0)
	 * 
	 * @return boolean true if it's a scalar
	 */
	boolean isScalar();
	
	/**
	 * Check if the array is nested
	 * 
	 * @return boolean true if the array is nested
	 */
	boolean isNested();
	
	/**
	 * Can the array be accessed using atI and atB?
	 * 
	 * @return boolean
	 */
	boolean isIntegral();

	/**
	 * Get the dimensions
	 * 
	 * @return Dimensions object
	 */
	Dimensions dims();
	
	/**
	 * Get total length of the array (ie. a product of all dimensions)
	 * 
	 * @return total number of elements in the array
	 */
	int length();
	
	/**
	 * Get actual length. Actual length can be shorter. All indexing is modulo this value, so array "repeats itself"
	 * if length is longer than actual length.
	 * 
	 * @return int actual length (number of real array elements)
	 */
	int actualLength();

	/**
	 * Return a reshaped copy of the array with same data. Note that the data may be shared.
	 * 
	 * @param newShape array of new dimensions
	 * @return Array reshaped array
	 */
	Array reshape(int... newShape);
	
	/**
	 * Return a reshaped copy with same data. Note that the data may be shared.
	 * 
	 * @param newShape new dimensions
	 * @return Array reshaped array
	 */
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
