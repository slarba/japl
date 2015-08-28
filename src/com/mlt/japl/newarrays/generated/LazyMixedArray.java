package com.mlt.japl.newarrays.generated;

import com.mlt.japl.newarrays.ArrayBase;
import com.mlt.japl.newarrays.ArrayVisitor;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.DoubleArray;
import com.mlt.japl.newarrays.concrete.MixedArray;
import com.mlt.japl.newarrays.interf.IArray;
import com.mlt.japl.newarrays.interf.IBitArray;
import com.mlt.japl.newarrays.interf.ICharArray;
import com.mlt.japl.newarrays.interf.ICharScalar;
import com.mlt.japl.newarrays.interf.IDoubleArray;
import com.mlt.japl.newarrays.interf.IDoubleScalar;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IIntScalar;
import com.mlt.japl.newarrays.interf.IMixedArray;
import com.mlt.japl.newarrays.interf.IMixedScalar;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.utils.PrintConfig;

public abstract class LazyMixedArray extends ArrayBase implements IMixedArray {

	public LazyMixedArray(Dimensions dims) {
		super(dims);
	}

	@Override
	public IValue force() {
		IValue[] data = new IValue[dims().length()];
		for(int i=0; i<data.length; i++) data[i] = get(i);
		return new MixedArray(dims(), data);
	}

	@Override
	public IValue accept_dyadic(IBitArray a, ArrayVisitor visitor, int axis) {
		return visitor.visit_dyadic(a, this, axis);
	}

	@Override
	public IValue accept_dyadic(ArrayVisitor visitor, IValue b, int axis) {
		return visitor.visit_first(this, b, axis);
	}

	@Override
	public IValue accept_dyadic(IIntArray a, ArrayVisitor visitor, int axis) {
		return visitor.visit_dyadic(a, this, axis);
	}

	@Override
	public IValue accept_dyadic(IDoubleArray a, ArrayVisitor visitor, int axis) {
		return visitor.visit_dyadic(a, this, axis);
	}

	@Override
	public IValue accept_dyadic(ICharArray a, ArrayVisitor visitor, int axis) {
		return visitor.visit_dyadic(a, this, axis);
	}

	@Override
	public IValue accept_dyadic(IMixedArray a, ArrayVisitor visitor, int axis) {
		return visitor.visit_dyadic(a, this, axis);
	}

	@Override
	public IValue accept_dyadic(IIntScalar a, ArrayVisitor visitor, int axis) {
		return visitor.visit_dyadic(a, this, axis);
	}

	@Override
	public IValue accept_dyadic(IDoubleScalar a, ArrayVisitor visitor, int axis) {
		return visitor.visit_dyadic(a, this, axis);
	}

	@Override
	public IValue accept_dyadic(ICharScalar a, ArrayVisitor visitor, int axis) {
		return visitor.visit_dyadic(a, this, axis);
	}

	@Override
	public IValue accept_dyadic(IMixedScalar a, ArrayVisitor visitor, int axis) {
		return visitor.visit_dyadic(a, this, axis);
	}

	@Override
	public IValue accept_monadic(ArrayVisitor visitor, int axis) {
		return visitor.visit_monadic(this, axis);
	}

	@Override
	public String asString(PrintConfig config) {
		return config.print(this);
	}

	@Override
	public IValue reshape(int[] newShape) {
		IMixedArray self = this;
		return new LazyMixedArray(new Dimensions(newShape)) {
			@Override
			public IValue get(int index) {
				return self.get(index%dims().length());
			}
		};
	}

	@Override
	public boolean equals(Object o) {
		if(o==null) return false;
		if(o instanceof IArray) {
			if(!((IArray)o).dims().equals(dims()))
				return false;
		}
		if(o instanceof IMixedArray) {
			IMixedArray a = (IMixedArray)o;
			for(int i=0; i<a.length(); i++) {
				if(!a.get(i).equals(get(i))) return false;
			}
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		long prime = 17;
		long result = super.hashCode();
		for(int i=0; i<length(); i++) {
			result = prime * result + get(i).hashCode();			
		}
		return (int)result;
	}

}
