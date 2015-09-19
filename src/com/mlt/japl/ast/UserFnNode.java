package com.mlt.japl.ast;

import java.util.ArrayList;
import java.util.List;

import com.mlt.japl.errors.AplError;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.IntScalar;
import com.mlt.japl.newarrays.generated.LazyMixedArray;
import com.mlt.japl.newarrays.interf.IBitArray;
import com.mlt.japl.newarrays.interf.ICharArray;
import com.mlt.japl.newarrays.interf.IDoubleArray;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IMixedArray;
import com.mlt.japl.newfns.Func;
import com.mlt.japl.newfns.UserFnReducer;
import com.mlt.japl.workspace.EvalContext;

public class UserFnNode implements AstNode, Func {

	private List<String> locals;
	private AstNode body;
	private String rightArgName;
	private String leftArgName;
	private String outName;
	private EvalContext frame;

	public UserFnNode(AstNode body, EvalContext frame) {
		this.locals = new ArrayList<String>();
		this.frame = frame;
		this.body = body;
	}
	
	public UserFnNode(EvalContext frame, String outName, List<String> locals, AstNode body) {
		this.locals = locals;
		this.body = body;
		this.outName = outName;
		this.frame = frame;
	}

	public UserFnNode(EvalContext frame, String outName, List<String> locals, AstNode body, String rightArgName) {
		this.outName = outName;
		this.locals = locals;
		this.body = body;
		this.rightArgName = rightArgName;
		this.frame = frame;
	}

	public UserFnNode(EvalContext frame, String outName, List<String> locals, AstNode body, String rightArgName, String leftArgName) {
		this.outName = outName;
		this.locals = locals;
		this.body = body;
		this.rightArgName = rightArgName;
		this.leftArgName = leftArgName;
		this.frame = frame;
	}

	@Override
	public IValue eval(EvalContext context) {
		throw new AplError();
	}

	@Override
	public String print() {
		StringBuilder builder = new StringBuilder();
		for(String s : locals) {
			builder.append(s);
			builder.append(' ');
		}
		return "<userfn locals=(" + builder.toString() + 
				") larg=" + leftArgName + 
				" rarg=" + rightArgName +
				" out=" + outName + 
				">{" + body.print() + "}";
	}

	@Override
	public IValue applyMonadic(IValue a, int axis) {
		EvalContext derived = frame.newFrame();
		derived.set("\u03c9", a);
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
		return body.eval(frame.newFrame());
	}

	@Override
	public String getName() {
		return print();
	}

	@Override
	public IValue reduce(IIntArray a, int axis) {
		UserFnReducer reducer = new UserFnReducer(new IntScalar(a.get(0)), a, axis) {
			@Override
			public IValue op(IValue a, IValue b) {
				return applyDyadic(a, b, axis);
			}
		};
		if(a.rank()==1) return reducer.rank1case();
		return new LazyMixedArray(a.dims().elideAxis(axis)) {
			@Override
			public IValue get(int index) {
				return reducer.get(index);
			}
		};
	}

	@Override
	public IValue reduce(IDoubleArray a, int axis) {
		throw new AplError();
	}

	@Override
	public IValue reduce(ICharArray a, int axis) {
		throw new AplError();
	}

	@Override
	public IValue reduce(IMixedArray a, int axis) {
		throw new AplError();
	}

	@Override
	public IValue reduce(IBitArray a, int axis) {
		throw new AplError();
	}

	@Override
	public IValue outerprod(IIntArray a, IIntArray b, int axis) {
		throw new AplError();
	}

	@Override
	public IValue outerprod(IDoubleArray a, IDoubleArray b, int axis) {
		throw new AplError();
	}

	@Override
	public IValue outerprod(IBitArray a, IBitArray b, int axis) {
		throw new AplError();
	}

	@Override
	public IValue outerprod(IIntArray a, IDoubleArray b, int axis) {
		throw new AplError();
	}

	@Override
	public IValue outerprod(IIntArray a, IBitArray b, int axis) {
		throw new AplError();
	}

	@Override
	public IValue outerprod(IDoubleArray a, IIntArray b, int axis) {
		throw new AplError();
	}

	@Override
	public IValue outerprod(IDoubleArray a, IBitArray b, int axis) {
		throw new AplError();
	}

	@Override
	public IValue outerprod(IBitArray a, IIntArray b, int axis) {
		throw new AplError();
	}

	@Override
	public IValue outerprod(IBitArray a, IDoubleArray b, int axis) {
		throw new AplError();
	}

}
