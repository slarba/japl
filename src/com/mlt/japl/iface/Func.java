package com.mlt.japl.iface;

public interface Func {
	Array monadic(Array a, int axis);
	Array dyadic(Array a, Array b, int axis);
	String getName();
	
	int resultTypeFor(Array a);
	int resultTypeFor(Array type, Array type2);
}
