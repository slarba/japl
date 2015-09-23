package com.mlt.japl.inliningtest;

public class MulFunc implements IFunc {

	@Override
	public IArr apply(IArr a, IArr b, int axis) {
		return new LazyArr(new Object()) {
			@Override
			public double get(int index) {
				return a.get(index) * b.get(index);
			}
		};
	}

	@Override
	public IArr apply(IArr a, int axis) {
		return new LazyArr(new Object()) {
			@Override
			public double get(int index) {
				return a.get(index);
			}
		};
	}

}
