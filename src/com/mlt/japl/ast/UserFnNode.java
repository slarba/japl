package com.mlt.japl.ast;

import java.util.ArrayList;
import java.util.List;

import com.mlt.japl.errors.AplError;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.DoubleScalar;
import com.mlt.japl.newarrays.concrete.IntArray;
import com.mlt.japl.newarrays.concrete.IntScalar;
import com.mlt.japl.newarrays.generated.LazyMixedArray;
import com.mlt.japl.newarrays.interf.IBitArray;
import com.mlt.japl.newarrays.interf.ICharArray;
import com.mlt.japl.newarrays.interf.IDoubleArray;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IMixedArray;
import com.mlt.japl.newfns.Func;
import com.mlt.japl.newfns.UserFnReducer;
import com.mlt.japl.tools.Dimensions;
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
		for(String s : locals) {
			derived.set(s, IntScalar.ZERO);
		}
		if(rightArgName==null) {
			derived.set("\u03c9", a);
			derived.set("\u237a", a);
		} else {
			derived.set(rightArgName, a);
		}
		IValue result = body.eval(derived);
		if(outName!=null) {
			return derived.get(outName).force();
		} else return result.force();
	}

	@Override
	public IValue applyDyadic(IValue a, IValue b, int axis) {
		EvalContext derived = frame.newFrame();
		for(String s : locals) {
			derived.set(s, IntScalar.ZERO);
		}
		if(rightArgName==null) {
			derived.set("\u03c9", b);
			derived.set("\u2375", b);
		} else {
			derived.set(rightArgName, b);
		}

		if(leftArgName==null) {
			derived.set("\u03b1", a);
			derived.set("\u237a", a);
		} else {
			derived.set(leftArgName, a);
		}
		IValue result = body.eval(derived);
		if(outName!=null) {
			return derived.get(outName).force();
		} else return result.force();
	}

	@Override
	public IValue applyNiladic(int axis) {
		return body.eval(frame.newFrame());
	}

	@Override
	public String getName() {
		return print();
	}

	private IValue generic_reduce(IValue a, int axis) {
		UserFnReducer reducer = new UserFnReducer(a, axis) {
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
		}.force();		
	}
	
	@Override
	public IValue reduce(IIntArray a, int axis) {
		return generic_reduce(a, axis);
	}

	@Override
	public IValue reduce(IDoubleArray a, int axis) {
		return generic_reduce(a, axis);
	}

	@Override
	public IValue reduce(ICharArray a, int axis) {
		return generic_reduce(a, axis);
	}

	@Override
	public IValue reduce(IMixedArray a, int axis) {
		return generic_reduce(a, axis);
	}

	@Override
	public IValue reduce(IBitArray a, int axis) {
		return generic_reduce(a, axis);
	}

	protected Dimensions outerProdDims(IValue a, IValue b, int axis) {
		return a.dims().concat(b.dims());
	}

	private IValue generic_outerprod(IValue a, IValue b, int axis) {
		return new LazyMixedArray(outerProdDims(a, b, axis)) {
			@Override
			public IValue get(int index) {
				int idx = index / a.length();
				return applyDyadic(a.getGeneric(idx), b.getGeneric(index), axis);
			}
		}.force();
	}
	
	@Override
	public IValue outerprod(IIntArray a, IIntArray b, int axis) {
		return generic_outerprod(a, b, axis);
	}

	@Override
	public IValue outerprod(IDoubleArray a, IDoubleArray b, int axis) {
		return generic_outerprod(a, b, axis);
	}

	@Override
	public IValue outerprod(IBitArray a, IBitArray b, int axis) {
		return generic_outerprod(a, b, axis);
	}

	@Override
	public IValue outerprod(IIntArray a, IDoubleArray b, int axis) {
		return generic_outerprod(a, b, axis);
	}

	@Override
	public IValue outerprod(IIntArray a, IBitArray b, int axis) {
		return generic_outerprod(a, b, axis);
	}

	@Override
	public IValue outerprod(IDoubleArray a, IIntArray b, int axis) {
		return generic_outerprod(a, b, axis);
	}

	@Override
	public IValue outerprod(IDoubleArray a, IBitArray b, int axis) {
		return generic_outerprod(a, b, axis);
	}

	@Override
	public IValue outerprod(IBitArray a, IIntArray b, int axis) {
		return generic_outerprod(a, b, axis);
	}

	@Override
	public IValue outerprod(IBitArray a, IDoubleArray b, int axis) {
		return generic_outerprod(a, b, axis);
	}

	@Override
	public IValue outerprod(IIntArray a, ICharArray b, int axis) {
		return generic_outerprod(a, b, axis);
	}

	@Override
	public IValue outerprod(IIntArray a, IMixedArray b, int axis) {
		return generic_outerprod(a, b, axis);
	}

	@Override
	public IValue outerprod(IDoubleArray a, ICharArray b, int axis) {
		return generic_outerprod(a, b, axis);
	}

	@Override
	public IValue outerprod(IDoubleArray a, IMixedArray b, int axis) {
		return generic_outerprod(a, b, axis);
	}

	@Override
	public IValue outerprod(IBitArray a, ICharArray b, int axis) {
		return generic_outerprod(a, b, axis);
	}

	@Override
	public IValue outerprod(IBitArray a, IMixedArray b, int axis) {
		return generic_outerprod(a, b, axis);
	}

	@Override
	public IValue outerprod(ICharArray a, IIntArray b, int axis) {
		return generic_outerprod(a, b, axis);
	}

	@Override
	public IValue outerprod(ICharArray a, IDoubleArray b, int axis) {
		return generic_outerprod(a, b, axis);
	}

	@Override
	public IValue outerprod(ICharArray a, IBitArray b, int axis) {
		return generic_outerprod(a, b, axis);
	}

	@Override
	public IValue outerprod(ICharArray a, IMixedArray b, int axis) {
		return generic_outerprod(a, b, axis);
	}

	@Override
	public IValue outerprod(ICharArray a, ICharArray b, int axis) {
		return generic_outerprod(a, b, axis);
	}

	@Override
	public IValue outerprod(IMixedArray a, IIntArray b, int axis) {
		return generic_outerprod(a, b, axis);
	}

	@Override
	public IValue outerprod(IMixedArray a, IDoubleArray b, int axis) {
		return generic_outerprod(a, b, axis);
	}

	@Override
	public IValue outerprod(IMixedArray a, IBitArray b, int axis) {
		return generic_outerprod(a, b, axis);
	}

	@Override
	public IValue outerprod(IMixedArray a, ICharArray b, int axis) {
		return generic_outerprod(a, b, axis);
	}

	@Override
	public IValue outerprod(IMixedArray a, IMixedArray b, int axis) {
		return generic_outerprod(a, b, axis);
	}

}
