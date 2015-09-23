package com.mlt.japl.inliningtest;

public interface IFunc {
	IArr apply(IArr a, int index);
	IArr apply(IArr a, IArr b, int index);
}
