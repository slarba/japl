package com.mlt.japl.arrays;

import com.mlt.japl.iface.Array;

public interface NestedArray {

	Array atA(int... indx);

	Array atA(int idx);

	void setA(int idx, Array val);

}