package com.mlt.japl.scalars;

import com.mlt.japl.arrays.CharArray;
import com.mlt.japl.arrays.NestedArray;
import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.utils.PrintConfig;

public class CharScalar extends BaseScalar {

	private char data;
	
	public CharScalar() {
		data = ' ';
	}
	
	public CharScalar(char value) {
		data = value;
	}
	
	@Override
	public int type() {
		return CHARACTER;
	}

	@Override
	public char atC(int... idx) {
		return data;
	}

	@Override
	public char atC(int idx) {
		return data;
	}

	@Override
	public void setC(int idx, char val) {
		data = val;
	}
	
	@Override
	public Array unInitializedCopy() {
		return new CharScalar();
	}
	
	@Override
	public Array reshape(Dimensions newShape) {
		return new CharArray(newShape, new char[] { data });
	}

	@Override
	public String asString(PrintConfig printConfig) {
		return printConfig.print(data);
	}

	@Override
	public Array prototype() {
		return new CharScalar(' ');
	}

	@Override
	public boolean equals(Object o) {
		if(o==this) return true;
		if(o instanceof CharScalar) {
			return ((CharScalar)o).data == data;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return 1+31*Character.hashCode(data);
	}

	@Override
	public int compareTo(BaseScalar o) {
		if(o instanceof CharScalar) {
			CharScalar a = (CharScalar)o;
			if(data<a.data) return -1;
			if(data>a.data) return 1;
			return 0;
		}
		return 0;
	}

}
