package com.mlt.japl.ast;

import com.mlt.japl.iface.Array;
import com.mlt.japl.iface.Func;
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
		return null;
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
		return body.eval(derived);
	}


	@Override
	public String getName() {
		return print();
	}
}