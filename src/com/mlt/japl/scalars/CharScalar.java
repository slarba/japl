package com.mlt.japl.scalars;

import com.mlt.japl.arrays.CharArray;
import com.mlt.japl.arrays.DoubleArray;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;

public class CharScalar extends BaseScalar {

	private char data;
	
	public CharScalar() {
		data = ' ';
	}
	
	public CharScalar(char value) {
		data = value;
	}
	
	@Override
	public int type() {
		return CHARACTER;
	}

	@Override
	public char atC(int... idx) {
		return data;
	}

	@Override
	public char atC(int idx) {
		return data;
	}

	@Override
	public void setC(int idx, char val) {
		data = val;
	}
	
	@Override
	public Array unInitializedCopy() {
		return new CharScalar(data);
	}
	
	@Override
	public Array reshape(Dimensions newShape) {
		return new CharArray(newShape, new char[] { data });
	}


}
