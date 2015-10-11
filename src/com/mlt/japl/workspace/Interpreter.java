package com.mlt.japl.workspace;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.*;
import com.mlt.japl.newast.AstNode;
import com.mlt.japl.parsing.Parser;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.utils.PrintConfig;

import java.io.*;
import java.util.ArrayList;

public class Interpreter {
    private EvalContext context;
    private ArrayList<AplBusyListener> listeners = new ArrayList<>();
    private PrintConfig printConfig;
    private PrintWriter output;
    private PrintWriter errors;

    public Interpreter(OutputStream out, OutputStream error) {
        context = new EvalContext(out, error);
        printConfig = new PrintConfig();
        output = new PrintWriter(out);
        errors = new PrintWriter(error);
    }

    public static void main(String[] args) {
        new Interpreter(System.out, System.err).eval(System.in);
    }

    public void reset() {
        context = new EvalContext(context.getOutputStream(), context.getErrorStream());
    }

    public void eval(String s) {
        for (AplBusyListener listener : listeners) listener.evaluationStarted();
        try {
            AstNode result = Parser.parse(s, context);
            IValue rval = result.eval(context);
            output.println(rval.asString(printConfig));
            output.flush();
        } catch(Throwable t) {
            t.printStackTrace(errors);
            errors.flush();
        } finally {
            for (AplBusyListener listener : listeners) listener.evaluationEnded();
        }
    }

    public void eval(InputStream s) {
        try {
            AstNode n = Parser.parse(s, context);
            IValue rval = n.eval(context);
            output.println(rval.asString(printConfig));
            output.flush();
        } catch(Throwable t) {
            t.printStackTrace(errors);
            errors.flush();
        }
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

    public void addBusyListener(AplBusyListener listener) {
        listeners.add(listener);
    }

}
