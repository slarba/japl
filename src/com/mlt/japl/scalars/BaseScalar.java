package com.mlt.japl.scalars;

import com.mlt.japl.errors.DomainError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;

public abstract class BaseScalar implements Array {

	@Override
	public int rank() {
		return 0;
	}

	@Override
	public int depth() {
		return 0;
	}

	@Override
	public Array atA(int... indx) {
		throw new DomainError();
	}

	@Override
	public Array atA(int idx) {
		throw new DomainError();
	}

	@Override
	public long atI(int... indx) {
		throw new DomainError();
	}

	@Override
	public long atI(int idx) {
		throw new DomainError();
	}

	@Override
	public double atD(int... indx) {
		throw new DomainError();
	}

	@Override
	public double atD(int idx) {
		throw new DomainError();
	}

	@Override
	public char atC(int... indx) {
		throw new DomainError();
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
}
