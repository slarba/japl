package testing;

public class PrecisionIncreasingFn extends BaseFn {

	@Override
	public Array createResultArrayFor(Array a, int axis) {
		// reciprocal result is always more (or equally) precise than its argument
		return a.morePreciseUnInitializedCopy();
	}

	@Override
	public Array createResultArrayFor(Array a, Array b, int axis) {
		if(a.isScalar()) {
			return b.morePreciseUnInitializedCopy();
		}
		if(b.isScalar()) {
			return a.morePreciseUnInitializedCopy();
		}
		if(a.rank() != b.rank()) throw new RankError();
		if(!a.dims().equals(b.dims())) throw new LengthError();
		return a.morePreciseUnInitializedCopy();
	}

}
