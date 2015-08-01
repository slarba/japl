package com.mlt.japl.scalars;

import com.mlt.japl.arrays.NestedArray;
import com.mlt.japl.errors.AplError;
import com.mlt.japl.errors.DomainError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.utils.PrintConfig;

public class ComplexScalar extends BaseScalar {

	private double im;
	private double re;

	public ComplexScalar(double re, double im) {
		this.re = re;
		this.im = im;
	}

	@Override
	public int type() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Array reshape(Dimensions newShape) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Array unInitializedCopy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Array prototype() {
		throw new AplError();
	}

	@Override
	public String asString(PrintConfig printConfig) {
		return printConfig.print(re, im);
	}

	@Override
	public int compareTo(BaseScalar o) {
		throw new DomainError();
	}

}
