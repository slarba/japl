package com.mlt.japl.newarrays.concrete;

import com.mlt.japl.newarrays.ArrayVisitor;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.ScalarBase;
import com.mlt.japl.newarrays.interf.IBitArray;
import com.mlt.japl.newarrays.interf.ICharArray;
import com.mlt.japl.newarrays.interf.ICharScalar;
import com.mlt.japl.newarrays.interf.IDoubleArray;
import com.mlt.japl.newarrays.interf.IDoubleScalar;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IIntScalar;
import com.mlt.japl.newarrays.interf.IMixedArray;
import com.mlt.japl.newarrays.interf.IMixedScalar;
import com.mlt.japl.utils.PrintConfig;

public class ObjectScalar extends ScalarBase implements IMixedScalar {

	private Object value;
	
	public ObjectScalar(Object instance) {
		value = instance;
	}

	@Override
	public String asString(PrintConfig printConfig) {
		return "#<" + value.getClass().getName() + ": " + value.toString() + ">";
	}

	@Override
	public IValue reshape(int[] newShape) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValue accept_dyadic(ArrayVisitor visitor, IValue b, int axis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValue accept_dyadic(IIntArray a, ArrayVisitor visitor, int axis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValue accept_dyadic(IDoubleArray a, ArrayVisitor visitor, int axis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValue accept_dyadic(ICharArray a, ArrayVisitor visitor, int axis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValue accept_dyadic(IMixedArray a, ArrayVisitor visitor, int axis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValue accept_dyadic(IBitArray a, ArrayVisitor visitor, int axis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValue accept_dyadic(IIntScalar a, ArrayVisitor visitor, int axis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValue accept_dyadic(IDoubleScalar a, ArrayVisitor visitor, int axis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValue accept_dyadic(ICharScalar a, ArrayVisitor visitor, int axis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValue accept_dyadic(IMixedScalar a, ArrayVisitor visitor, int axis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValue accept_monadic(ArrayVisitor visitor, int axis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValue get() {
		return this;
	}

	@Override
	public Class<?> getCorrespondingJavaClass() {
		return value.getClass();
	}

	@Override
	public Object coerceToJavaObject() {
		return value;
	}

	@Override
	public IValue getGeneric(int index) {
		return this;
	}

}
