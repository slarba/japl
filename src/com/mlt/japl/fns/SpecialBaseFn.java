package com.mlt.japl.fns;

import com.mlt.japl.errors.ValenceError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.iface.Func;
import com.mlt.japl.tools.Iterator;

public abstract class SpecialBaseFn implements Func {

	@Override
	public Array monadic(Array a, int axis) {
		throw new ValenceError();
	}

	@Override
	public Array dyadic(Array a, Array b, int axis) {
		throw new ValenceError();
	}

	protected Array copyWithIterators(Array a, Array result, Iterator srcIterator,
			Iterator dstIterator) {
		switch(result.type()) {
		case Array.BIT:
		case Array.INTEGER:
			do {
				result.setI(dstIterator.index(), a.atI(srcIterator.index()));
				srcIterator.step();
				dstIterator.step();
			} while(!srcIterator.isFinished());
			break;
		case Array.CHARACTER:
			while(!srcIterator.isFinished()) {
				result.setC(dstIterator.index(), a.atC(srcIterator.index()));
				srcIterator.step();
				dstIterator.step();
			}
			break;
		case Array.DOUBLE:
			while(!srcIterator.isFinished()) {
				result.setD(dstIterator.index(), a.atD(srcIterator.index()));
				srcIterator.step();
				dstIterator.step();
			}
			break;
		case Array.NESTED:
			while(!srcIterator.isFinished()) {
				result.setA(dstIterator.index(), a.atA(srcIterator.index()));
				srcIterator.step();
				dstIterator.step();
			}
			break;
		}
		return result;
	}

}
