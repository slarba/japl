package com.mlt.japl.arrays;

import java.util.Arrays;

import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.utils.PrintConfig;

public class RotatedArray extends BaseArray {
	Array array;
	private int[] rotations;
	
	public RotatedArray(Array a, int[] rotations) {
		super(a.dims());
		this.array = a;
		this.rotations = rotations;
	}

	private int calcRotatedIndex(int idx) {
		int[] spans = dims().spans();
		int[] dims = dims().asArray();
		int result = 0;
		for(int i=0; i<spans.length; i++) {
			long origIndex = idx/spans[i];
			idx = idx%spans[i];
			long modIndex = (origIndex+rotations[i])%dims[i];
			if(modIndex<0) modIndex = dims[i]+modIndex;
			result += modIndex*spans[i];
		}
		return result;
	}

	@Override
	public int depth() {
		return array.depth();
	}

	@Override
	public int length() {
		return array.length();
	}
		
	@Override
	public long atB(int... indx) {
		return atB(dims.calculateIndex(indx));
	}
	
	@Override
	public long atB(int idx) {
		return array.atB(calcRotatedIndex(idx));
	}

	@Override
	public Array atA(int... indx) {
		return atA(dims.calculateIndex(indx));
	}

	@Override
	public Array atA(int idx) {
		return array.atA(calcRotatedIndex(idx));
	}

	@Override
	public long atI(int... indx) {
		return atI(dims.calculateIndex(indx));
	}

	@Override
	public long atI(int idx) {
		return array.atI(calcRotatedIndex(idx));
	}

	@Override
	public double atD(int... indx) {
		return atD(dims.calculateIndex(indx));
	}

	@Override
	public double atD(int idx) {
		return array.atD(calcRotatedIndex(idx));
	}

	@Override
	public char atC(int... indx) {
		return atC(dims.calculateIndex(indx));
	}

	@Override
	public char atC(int idx) {
		return array.atC(calcRotatedIndex(idx));
	}

	@Override
	public int type() {
		return array.type();
	}

	@Override
	public int actualLength() {
		return array.actualLength();
	}

	@Override
	public Array reshape(Dimensions newShape) {
		return null;
	}

	@Override
	public Array unInitializedCopy() {
		return null;
	}

	@Override
	public Array unInitializedReshapedCopy(Dimensions resultDims) {
		return null;
	}

	@Override
	public String asString(PrintConfig config) {
		return config.print(this);
	}
	
	@Override
	public boolean equals(Object o) {
		if(o==this) return true;
		if(o instanceof Array) {
			Array a = (Array)o;
			if(!a.dims().equals(dims())) return false;
			for(int i=0; i<a.length(); i++)
				if(!a.atA(i).equals(atA(i))) return false;
			return true;
		}
		return false;
	}

	public Array modifyRotations(int axis, int offset) {
		int[] newRotations = Arrays.copyOf(rotations, rotations.length);
		newRotations[axis] += offset;
		return new RotatedArray(array, newRotations);
	}
}
