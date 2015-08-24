package com.mlt.japl.scalars;

import com.mlt.japl.arrays.NestedArrayImpl;
import com.mlt.japl.errors.DomainError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.utils.PrintConfig;

public class ArrayScalar extends BaseScalar {

	private Array data;
		
	public ArrayScalar() {
		data = null;
	}
	
	public ArrayScalar(Array value) {
		data = value;
	}
	
	@Override
	public int type() {
		return MIXED;
	}

	@Override
	public boolean isNested() {
		return true;
	}
	
	@Override
	public int depth() {
		return data.depth()+1;
	}

	@Override
	public Array atA(int idx) {
		return data;
	}

	@Override
	public void setA(int idx, Array val) {
		data = val;
	}
	
	@Override
	public Array unInitializedCopy() {
		return new ArrayScalar();
	}
	
	@Override
	public Array reshape(Dimensions newShape) {
		return new NestedArrayImpl(newShape, new Array[] { data });
	}

	@Override
	public String asString(PrintConfig printConfig) {
		return ""; // printConfig.print(data);
	}
	
	@Override
	public Array prototype() {
		return new NestedArrayImpl();
	}
	
	@Override
	public int hashCode() {
		return 3+57*data.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if(o==this) return true;
		return data.equals(o);
	}

	@Override
	public int compareTo(BaseScalar o) {
		throw new DomainError();
	}
}
