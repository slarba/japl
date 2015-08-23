package com.mlt.japl.newarrays;

import com.mlt.japl.tools.Dimensions;

public interface IValue extends ArrayAcceptor {
	Dimensions dims();
	int rank();
	int depth();
	int length();
	
	IValue force();   // realize lazy array into concrete array
}
