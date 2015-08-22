package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.interf.ICharArray;
import com.mlt.japl.newarrays.interf.IDoubleArray;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IMixedArray;

public interface Prim {

	long call(long l);
	double call(double d);
	char call(char c);
	IValue call(IValue iValue);
	
	IValue createLazyMonadic(IDoubleArray a);
	IValue createLazyMonadic(IIntArray a);
	IValue createLazyMonadic(ICharArray a);
	IValue createLazyMonadic(IMixedArray a);
}
