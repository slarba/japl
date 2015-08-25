package com.mlt.japl.ast;

import com.mlt.japl.errors.SyntaxError;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.CharArray;
import com.mlt.japl.newarrays.concrete.CharScalar;
import com.mlt.japl.newarrays.concrete.DoubleScalar;
import com.mlt.japl.newarrays.concrete.IntScalar;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.workspace.EvalContext;

public class ConstantAstNode implements AstNode {

	public static final int COMPLEX = 1;

	private int type;
	private String value;
	private IValue parsedValue;

	public ConstantAstNode(String c) {
		this.value = c;
		if(isStringConstant()) parsedValue = new CharArray(getString());
		else if(isInteger()) parsedValue = new IntScalar(getInt());
		else if(isDouble()) parsedValue = new DoubleScalar(getDouble());
		else if(isCharConstant()) parsedValue = new CharScalar(getChar());
		else throw new SyntaxError();
	}
	
	@Override
	public IValue eval(EvalContext context) {
		return parsedValue;
	}

	@Override
	public String print() {
		return value;
	}

	public boolean isStringConstant() {
		return value.startsWith("'") && value.endsWith("'") && (value.length()==2 || value.length()>3);
	}

	public boolean isInteger() {
		return !value.startsWith("'") && !value.endsWith("'") && value.indexOf('.')<0;
	}
	
	public boolean isDouble() {
		return type!=COMPLEX && !value.startsWith("'") && !value.endsWith("'") && value.indexOf('.')>=0;
	}
	
	public double getDouble() {
		if(value.startsWith("¯")) return -Double.parseDouble(value.substring(1));
		return Double.parseDouble(value);
	}
	
	public int getInt() {
		if(value.startsWith("¯")) return -Integer.parseInt(value.substring(1));
		return Integer.parseInt(value);
	}
	
	public String getString() {
		return value.substring(1, value.length()-1);
	}

	public boolean isCharConstant() {
		return value.startsWith("'") && value.endsWith("'") && value.length()==3;
	}

	public char getChar() {
		return value.charAt(1);
	}

	public boolean isComplex() {
		return type==COMPLEX;
	}

	public IValue getAsCell() {
		return parsedValue;
	}
}
