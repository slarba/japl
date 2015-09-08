package com.mlt.japl.ast;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.interf.IBitArray;
import com.mlt.japl.newarrays.interf.ICharArray;
import com.mlt.japl.newarrays.interf.IDoubleArray;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IMixedArray;
import com.mlt.japl.newfns.Func;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.workspace.EvalContext;

public class UserFnNode implements AstNode, Func {

	private AstNode body;
	private EvalContext frame;

	public UserFnNode(AstNode body) {
		this.body = body;
	}

	public UserFnNode(AstNode body, EvalContext frame) {
		this(body);
		this.frame = frame;
	}
	
	@Override
	public IValue eval(EvalContext context) {
		throw new RuntimeException("foo");
	}

	@Override
	public String print() {
		return "{ " + body.print() + " }";
	}

	@Override
	public IValue applyMonadic(IValue a, int axis) {
		EvalContext derived = frame.newFrame();
		derived.set("\u03b1", a);
		derived.set("\u237a", a);
		return body.eval(derived);
	}

	@Override
	public IValue applyDyadic(IValue a, IValue b, int axis) {
		EvalContext derived = frame.newFrame();
		derived.set("\u03b1", a);
		derived.set("\u03c9", b);
		derived.set("\u237a", a);
		derived.set("\u2375", b);
		return body.eval(derived);
	}

	@Override
	public IValue applyNiladic(int axis) {
		return body.eval(frame);
	}

	@Override
	public String getName() {
		return print();
	}

	@Override
	public IValue reduce(IIntArray a, int axis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValue reduce(IDoubleArray a, int axis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValue reduce(ICharArray a, int axis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValue reduce(IMixedArray a, int axis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValue reduce(IBitArray a, int axis) {
		// TODO Auto-generated method stub
		return null;
	}
}
