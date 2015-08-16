package com.mlt.japl.ast;

import com.mlt.japl.errors.AplError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.iface.Func;
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
	public Array eval(EvalContext context) {
		throw new RuntimeException("foo");
	}

	@Override
	public String print() {
		return "{ " + body.print() + " }";
	}

	@Override
	public Array monadic(Array a, int axis) {
		EvalContext derived = frame.newFrame();
		derived.set("\u03c9", a);
		return body.eval(derived);
	}

	@Override
	public Array dyadic(Array a, Array b, int axis) {
		EvalContext derived = frame.newFrame();
		derived.set("\u03b1", a);
		derived.set("\u03c9", b);
		derived.set("\u237a", a);
		derived.set("\u2375", b);
		return body.eval(derived);
	}

	@Override
	public Array niladic() {
		return body.eval(frame);
	}

	@Override
	public String getName() {
		return print();
	}

	@Override
	public int resultTypeFor(Array a) {
		return body.resultTypeFor(a);
	}

	@Override
	public int resultTypeFor(Array a, Array b) {
		return body.resultTypeFor(a,b);
	}

	@Override
	public Dimensions resultDimsFor(Array a, int axis) {
		return body.resultDimsFor(a,axis);
	}

	@Override
	public Dimensions resultDimsFor(Array a, Array b, int axis) {
		return body.resultDimsFor(a,b,axis);
	}

}
