package com.mlt.japl.ast;

import java.util.List;

import com.mlt.japl.errors.AplError;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.interf.IBitArray;
import com.mlt.japl.newarrays.interf.ICharArray;
import com.mlt.japl.newarrays.interf.IDoubleArray;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IMixedArray;
import com.mlt.japl.newfns.Func;
import com.mlt.japl.workspace.EvalContext;

public class NiladicUserFnNode implements AstNode, Func {

	private List<String> locals;
	private AstNode body;
	private String rightArgName;
	private String leftArgName;
	private String outName;

	public NiladicUserFnNode(String outName, List<String> locals, AstNode body) {
		this.locals = locals;
		this.body = body;
		this.outName = outName;
	}

	public NiladicUserFnNode(String outName, List<String> locals, AstNode body, String rightArgName) {
		this.outName = outName;
		this.locals = locals;
		this.body = body;
		this.rightArgName = rightArgName;
	}

	public NiladicUserFnNode(String outName, List<String> locals, AstNode body, String rightArgName, String leftArgName) {
		this.outName = outName;
		this.locals = locals;
		this.body = body;
		this.rightArgName = rightArgName;
		this.leftArgName = leftArgName;
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
	public IValue applyDyadic(IValue a, IValue b, int axis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValue applyMonadic(IValue a, int axis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValue applyNiladic(int axis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		return "<niladicUserFn>";
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

	@Override
	public IValue outerprod(IIntArray a, IIntArray b, int axis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValue outerprod(IIntArray a, IDoubleArray b, int axis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValue outerprod(IIntArray a, IBitArray b, int axis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValue outerprod(IDoubleArray a, IIntArray b, int axis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValue outerprod(IDoubleArray a, IDoubleArray b, int axis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValue outerprod(IDoubleArray a, IBitArray b, int axis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValue outerprod(IBitArray a, IIntArray b, int axis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValue outerprod(IBitArray a, IDoubleArray b, int axis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValue outerprod(IBitArray a, IBitArray b, int axis) {
		// TODO Auto-generated method stub
		return null;
	}

}
