package com.mlt.japl.workspace;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import com.mlt.japl.ast.AstNode;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.CharArray;
import com.mlt.japl.newarrays.concrete.CharScalar;
import com.mlt.japl.newarrays.concrete.DoubleArray;
import com.mlt.japl.newarrays.concrete.DoubleScalar;
import com.mlt.japl.newarrays.concrete.IntArray;
import com.mlt.japl.newarrays.concrete.IntScalar;
import com.mlt.japl.parser.AplParser;
import com.mlt.japl.parser.ParseException;
import com.mlt.japl.tools.Dimensions;

public class Interpreter {
	private EvalContext context;
	private ArrayList<AplBusyListener> listeners = new ArrayList<AplBusyListener>();
	
	public Interpreter(OutputStream out) {
		context = new EvalContext(out);
	}

	public void reset() {
		context = new EvalContext();
	}
	
	public IValue eval(String s) {
		for(AplBusyListener listener : listeners) listener.evaluationStarted();
		try {
			return parse(s).eval(context);
		} finally {
			for(AplBusyListener listener : listeners) listener.evaluationEnded();			
		}
	}
	
	public void eval(InputStream s) {
		AplParser parser;
		try {
			parser = new AplParser(new InputStreamReader(s, "UTF-8"), context);
			parser.eval_stream();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public AstNode parse(String s) {
		AplParser parser = new AplParser(new StringReader(s), context);
		AstNode node = parser.parse();
		return node;
	}
	
	public void define(String id, long... data) {
		context.set(id, new IntArray(new Dimensions(data.length), data));
	}

	public void define(String id, long[] data, int... dims) {
		context.set(id, new IntArray(new Dimensions(dims), data));
	}

	public void define(String id, double... data) {
		context.set(id, new DoubleArray(new Dimensions(data.length), data));
	}

	public void define(String id, double[] data, int... dims) {
		context.set(id, new DoubleArray(new Dimensions(dims), data));
	}

	public void define(String id, String data, int... dims) {
		context.set(id, new CharArray(new Dimensions(dims), data.toCharArray()));
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

	public static void main(String[] args) {
		new Interpreter(System.out).eval(System.in);
	}

	public void addBusyListener(AplBusyListener listener) {
		listeners.add(listener);
	}
}
