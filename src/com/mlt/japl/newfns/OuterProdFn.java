package com.mlt.japl.newfns;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.IntScalar;
import com.mlt.japl.newarrays.generated.LazyMixedArray;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IMixedArray;

public class OuterProdFn extends BaseFn {

	private Func fn;

	public OuterProdFn(Func fn) {
		this.fn = fn;		
	}
	
	@Override
	public IValue applyDyadic(IValue a, IValue b, int axis) {
		return null;
	}
	
	@Override
	public String getName() {
		return "outerprod<" + fn.getName() + ">";
	}

}
