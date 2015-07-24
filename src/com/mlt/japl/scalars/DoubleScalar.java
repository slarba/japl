package com.mlt.japl.scalars;

import com.mlt.japl.arrays.DoubleArray;
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
	public Array morePreciseUnInitializedCopy(Array b) {
		if(b.type()==MIXED) return new ArrayScalar();
		return unInitializedCopy();  // no more precise than that
	}

	@Override
	public Array morePreciseUnInitializedCopy() {
		return unInitializedCopy();  // no more precise than that
	}

	@Override
	public String asString(PrintConfig printConfig) {
		return printConfig.print(data);
	}

}
