package com.mlt.japl.scalars;

import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.arrays.NestedArray;
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
	
	public static Array fromBoolean(boolean n) {
		return new IntScalar(n ? 1 : 0);
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
	
	@Override
	public int[] asIntArray() {
		return new int[] { (int)data };
	}
	
	@Override
	public Array prototype() {
		return new IntScalar(0);
	}
	
	@Override
	public boolean equals(Object o) {
		if(o==this) return true;
		if(o instanceof Array) {
			Array a = (Array)o;
			if(!a.isScalar()) return false;
			if(a.isIntegral()) {
				return atI(0) == a.atI(0);
			}
			return false;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return 1+17*Long.hashCode(data);
	}

}
