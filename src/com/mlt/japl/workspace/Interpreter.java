package com.mlt.japl.workspace;

import java.io.OutputStream;
import java.io.StringReader;

import com.mlt.japl.arrays.CharArray;
import com.mlt.japl.arrays.DoubleArray;
import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.ast.AstNode;
import com.mlt.japl.iface.Array;
import com.mlt.japl.parser.AplParser;
import com.mlt.japl.scalars.CharScalar;
import com.mlt.japl.scalars.DoubleScalar;
import com.mlt.japl.scalars.IntScalar;
import com.mlt.japl.tools.Dimensions;

public class Interpreter {
	private EvalContext context;

	public Interpreter(OutputStream out) {
		context = new EvalContext(out);
	}

	public void reset() {
		context = new EvalContext();
	}
	
	public Array eval(String s) {
		return parse(s).eval(context);
	}
	
	public AstNode parse(String s) {
		AplParser parser = new AplParser(new StringReader(s), context);
		AstNode node = parser.parse();
		return node;
	}
	
	public void define(String id, long... data) {
		context.set(id, new IntArray(data));
	}

	public void define(String id, long[] data, int... dims) {
		context.set(id, new IntArray(new Dimensions(dims), data));
	}

	public void define(String id, double... data) {
		context.set(id, new DoubleArray(data));
	}

	public void define(String id, double[] data, int... dims) {
		context.set(id, new DoubleArray(new Dimensions(dims), data));
	}

	public void define(String id, String data, int... dims) {
		context.set(id, new CharArray(new Dimensions(dims), data));
	}

	public void define(String id, String data) {
		context.set(id, new CharArray(data));
	}
	
	public void define(String id, char[] data, int... dims) {
		context.set(id, new CharArray(new Dimensions(dims), data));
	}

	public void define(String id, int val) {
		context.set(id, new IntScalar(val));
	}

	public void define(String id, double val) {
		context.set(id, new DoubleScalar(val));
	}

	public void define(String id, char val) {
		context.set(id, new CharScalar(val));
	}

}
