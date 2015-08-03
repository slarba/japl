package com.mlt.japl.arrays;

import java.util.Arrays;

import com.mlt.japl.errors.DomainError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.utils.PrintConfig;

/**
 * Base for primitive-containing arrays
 * 
 * @author mtl
 *
 */
public abstract class BaseArray implements Array {
	protected Dimensions dims;
	private int depth;
	
	public BaseArray() {
		dims = Dimensions.EMPTY_ARRAY;
		depth = 1;
	}
	
	public BaseArray(Dimensions dims) {
		this.dims = dims;
		depth = 1;
	}

	@Override
	public long atB(int... indx) {
		return atB(dims.calculateIndex(indx));
	}

	@Override
	public long atB(int idx) {
		throw new DomainError();		
	}
	
	@Override
	public int depth() {
		return depth;
	}

	@Override
	public Array reshape(int... newShape) {
		return reshape(new Dimensions(newShape));
	}

	@Override
	public Array atA(int... indx) {
		return atA(dims.calculateIndex(indx));
	}

	@Override
	public Array atA(int idx) {
		throw new DomainError();
	}

	@Override
	public long atI(int... indx) {
		return atI(dims.calculateIndex(indx));
	}

	@Override
	public long atI(int idx) {
		throw new DomainError();
	}

	@Override
	public double atD(int... indx) {
		return atD(dims.calculateIndex(indx));
	}

	@Override
	public double atD(int idx) {
		throw new DomainError();
	}

	@Override
	public char atC(int... indx) {
		return atC(dims.calculateIndex(indx));
	}

	@Override
	public char atC(int idx) {
		throw new DomainError();
	}

	@Override
	public boolean isScalar() {
		return dims.rank()==0;
	}

	@Override
	public Dimensions dims() {
		return dims;
	}

	@Override
	public int length() {
		return dims.length();
	}

	@Override
	public boolean isIntegral() {
		return type()==Array.BIT || type()==Array.INTEGER;
	}
	
	@Override
	public int rank() {
		return dims.rank();
	}

	@Override
	public boolean isNested() {
		return depth>1;
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

	@Override
	public String asString(PrintConfig printConfig) {
		return printConfig.print(this);
	}
	
	@Override
	public int[] asIntArray() {
		throw new DomainError();
	}

	@Override
	public int hashCode() {
		return 5*depth + 37*dims.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if(o==this) return true;
		if(o instanceof Array) {
			Array a = (Array)o;
			for(int i=0; i<a.length(); i++) {
				if(!atA(i).equals(a.atA(i))) return false;
			}
			return true;
		}
		return false;
	}
}
