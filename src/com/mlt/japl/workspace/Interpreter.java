package com.mlt.japl.workspace;

import com.mlt.japl.ast.AstNode;
import com.mlt.japl.errors.AplError;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.*;
import com.mlt.japl.parser.AplParser;
import com.mlt.japl.parser.ParseException;
import com.mlt.japl.parser.TokenMgrError;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.utils.PrintConfig;

import java.io.*;
import java.util.ArrayList;

public class Interpreter {
    private EvalContext context;
    private ArrayList<AplBusyListener> listeners = new ArrayList<AplBusyListener>();
    private PrintConfig printConfig;

    public Interpreter(OutputStream out, OutputStream error) {
        context = new EvalContext(out, error);
        printConfig = new PrintConfig();

        //startWebServer(8005);
    }

    public static void main(String[] args) {
        new Interpreter(System.out, System.err).eval(System.in);
    }

    public void reset() {
        context = new EvalContext(context.getOutputStream(), context.getErrorStream());
    }

    public void eval(String s) {
        PrintWriter w = new PrintWriter(context.getOutputStream());
        for (AplBusyListener listener : listeners) listener.evaluationStarted();
        try {
            IValue rval = parse(s).eval(context);
            w.println(rval.asString(printConfig));
            w.flush();
        } finally {
            for (AplBusyListener listener : listeners) listener.evaluationEnded();
        }
    }

    public void eval(InputStream s) {
        AplParser parser;
        try {
            parser = new AplParser(new InputStreamReader(s, "UTF-8"), context);
            PrintStream errorStream = new PrintStream(context.getErrorStream());
            try {
                parser.eval_stream();
            } catch (ParseException e) {
                errorStream.println("PARSE ERROR");
                e.printStackTrace(errorStream);
                parser.skipTo(parser.STMTSEPARATOR);
                errorStream.flush();
            } catch (TokenMgrError tme) {
                errorStream.println("LEXICAL ERROR");
                parser.skipTo(parser.STMTSEPARATOR);
                errorStream.flush();
            } catch (ArithmeticException ae) {
                errorStream.println("DIVBYZERO");
                errorStream.flush();
            } catch (AplError aple) {
                errorStream.println(aple.getMessage());
                errorStream.flush();
                parser.skipTo(parser.STMTSEPARATOR);
            } catch (Exception e) {
                e.printStackTrace(errorStream);
                errorStream.flush();
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
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

    public void addBusyListener(AplBusyListener listener) {
        listeners.add(listener);
    }

}
