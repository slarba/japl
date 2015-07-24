package com.mlt.japl.scalars;

import com.mlt.japl.errors.AplError;
import com.mlt.japl.errors.DomainError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;

public abstract class BaseScalar implements Array {

	@Override 
	public Array ofSameTypeWithDimensions(Dimensions resultDims) {
		throw new AplError();
	};
	
	@Override
	public Array morePreciseUnInitializedCopy() {
		throw new DomainError();
	}

	@Override
	public Array morePreciseUnInitializedCopy(Array b) {
		throw new DomainError();
	}

	@Override
	public int rank() {
		return 0;
	}

	@Override
	public int depth() {
		return 0;
	}

	@Override
	public long atB(int... indx) {
		return atB(0);
	}

	@Override
	public long atB(int idx) {
		throw new DomainError();
	}
	
	@Override
	public Array atA(int... indx) {
		return this;
	}

	@Override
	public Array atA(int idx) {
		return this;
	}

	@Override
	public long atI(int... indx) {
		return atI(0);
	}

	@Override
	public long atI(int idx) {
		throw new DomainError();
	}

	@Override
	public double atD(int... indx) {
		return atD(0);
	}

	@Override
	public double atD(int idx) {
		throw new DomainError();
	}

	@Override
	public char atC(int... indx) {
		return atC(0);
	}

	@Override
	public char atC(int idx) {
		throw new DomainError();
	}

	@Override
	public boolean isScalar() {
		return true;
	}

	@Override
	public boolean isNested() {
		return false;
	}

	@Override
	public boolean isIntegral() {
		return type()==Array.BIT || type()==Array.INTEGER;
	}
	
	@Override
	public Dimensions dims() {
		return Dimensions.EMPTY;
	}

	@Override
	public int length() {
		return 0;
	}

	@Override
	public int actualLength() {
		return 1;
	}

	@Override
	public Array reshape(int... newShape) {
		return reshape(new Dimensions(newShape));
	}

	@Override
	public void setI(int idx, long val) {
		throw new DomainError();
	}

	@Override
	public void setD(int idx, double val) {
		throw new DomainError();
	}

	@Override
	public void setC(int idx, char val) {
		throw new DomainError();
	}

	@Override
	public void setA(int idx, Array val) {
		throw new DomainError();
	}

	@Override
	public void setB(int idx, long val) {
		throw new DomainError();
	}

}
