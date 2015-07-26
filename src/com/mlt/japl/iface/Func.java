package com.mlt.japl.iface;

/**
 * Function interface
 * 
 * @author mtl
 */
public interface Func {
	/**
	 * Apply function monadically
	 * 
	 * @param a right argument
	 * @param axis optional axis, or -1 if not applicable
	 * @return Array result array
	 */
	Array monadic(Array a, int axis);
	
	/**
	 * Apply function dyadically
	 * 
	 * @param a left argument
	 * @param b right argument 
	 * @param axis optional axis, or -1 if not applicable
	 * @return Array result array
	 */
	Array dyadic(Array a, Array b, int axis);
	
	/**
	 * Apply niladically (without arguments)
	 * 
	 * @return Array result array
	 */
	Array niladic();
	
	/**
	 * Name of the function for debugging purposes
	 * @return String name of the function
	 */
	String getName();

	/**
	 * Compute result type for given monadic argument
	 * 
	 * @see Array#INTEGER
	 * 
	 * @param a right argument
	 * @return int result type (see Array#INTEGER, BIT, NESTED, DOUBLE, CHARACTER)
	 */
	int resultTypeFor(Array a);
	
	/**
	 * Compute result type for given dyadic arguments
	 * 
	 * @param a left argument
	 * @param b right argument
	 * @return int result type
	 */
	int resultTypeFor(Array a, Array b);
}
