package com.mlt.japl;

public abstract class PrecisionMaintainingFn extends BaseFn {

	@Override
	public Array createResultArrayFor(Array a, int axis) {
		return a.morePreciseUnInitializedCopy(a);
	}

	@Override
	public Array createResultArrayFor(Array a, Array b, int axis) {
		if(a.isScalar()) {
			if(b.isScalar()) return a.morePreciseUnInitializedCopy(b);
			return b.morePreciseUnInitializedCopy(a);
		}
		if(b.isScalar()) {
			return a.morePreciseUnInitializedCopy(b);
		}
		if(a.rank() != b.rank()) throw new RankError();
		if(!a.dims().equals(b.dims())) throw new LengthError();
		return a.morePreciseUnInitializedCopy(b);
	}

}
