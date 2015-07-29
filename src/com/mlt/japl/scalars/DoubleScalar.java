package com.mlt.japl.scalars;

import com.mlt.japl.arrays.DoubleArray;
import com.mlt.japl.arrays.NestedArray;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.utils.PrintConfig;


public class DoubleScalar extends BaseScalar {

	private double data;
	
	public DoubleScalar() {
		data = 0;
	}
	
	public DoubleScalar(double value) {
		data = value;
	}
	
	@Override
	public int type() {
		return DOUBLE;
	}

	@Override
	public double atD(int... idx) {
		return data;
	}

	@Override
	public double atD(int idx) {
		return data;
	}

	@Override
	public void setD(int idx, double val) {
		data = val;
	}
	
	@Override
	public Array unInitializedCopy() {
		return new DoubleScalar();
	}
	
	@Override
	public Array reshape(Dimensions newShape) {
		return new DoubleArray(newShape, new double[] { data });
	}

	@Override
	public String asString(PrintConfig printConfig) {
		return printConfig.print(data);
	}

	@Override
	public Array prototype() {
		return new DoubleScalar(0);
	}

	@Override
	public boolean equals(Object o) {
		if(o==this) return true;
		if(o instanceof DoubleScalar) {
			return ((DoubleScalar)o).data == data;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 1+7*Double.hashCode(data);
	}

}
