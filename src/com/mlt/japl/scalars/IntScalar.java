package com.mlt.japl.scalars;

import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.utils.PrintConfig;

public class IntScalar extends BaseScalar {

	private long data;
	
	public IntScalar() {
		data = 0;
	}
	
	public IntScalar(long value) {
		data = value;
	}
	
	@Override
	public int type() {
		return INTEGER;
	}

	@Override
	public long atI(int... idx) {
		return data;
	}

	@Override
	public long atI(int idx) {
		return data;
	}

	@Override
	public void setI(int idx, long val) {
		data = val;
	}
	
	@Override
	public Array reshape(Dimensions newShape) {
		return new IntArray(newShape, new long[] { data });
	}

	@Override
	public Array unInitializedCopy() {
		return new IntScalar();
	}

	@Override
	public String asString(PrintConfig printConfig) {
		return printConfig.print(data);
	}	

}
