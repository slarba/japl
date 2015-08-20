package com.mlt.japl.scalars;

import com.mlt.japl.arrays.IntArrayImpl;
import com.mlt.japl.errors.DomainError;
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
		return (data==0 || data==1) ? BIT : INTEGER;
	}

	@Override
	public long atI(int... idx) {
		return data;
	}

	@Override
	public double atD(int idx) {
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
	public void setD(int idx, double val) {
		if(val!=(long)val) throw new DomainError();
		data = (long)val;
	}
	
	@Override
	public Array reshape(Dimensions newShape) {
		return new IntArrayImpl(newShape, new long[] { data });
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
	public int compareTo(BaseScalar o) {
		if(o instanceof IntScalar) {
			IntScalar d = (IntScalar)o;
			if(data<d.data) return -1;
			if(data>d.data) return 1;
			return 0;
		}
		return 0;
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
