package com.mlt.japl.workspace;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import com.mlt.japl.ast.AstNode;
import com.mlt.japl.errors.AplError;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.CharArray;
import com.mlt.japl.newarrays.concrete.CharScalar;
import com.mlt.japl.newarrays.concrete.DoubleArray;
import com.mlt.japl.newarrays.concrete.DoubleScalar;
import com.mlt.japl.newarrays.concrete.IntArray;
import com.mlt.japl.newarrays.concrete.IntScalar;
import com.mlt.japl.parser.AplParser;
import com.mlt.japl.parser.ParseException;
import com.mlt.japl.parser.TokenMgrError;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.utils.PrintConfig;

public class Interpreter extends AbstractHandler {
	private EvalContext context;
	private ArrayList<AplBusyListener> listeners = new ArrayList<AplBusyListener>();
	private PrintConfig printConfig;
	private Server server;
	
	public Interpreter(OutputStream out, OutputStream error) {
		context = new EvalContext(out, error);
		printConfig = new PrintConfig();
		
		//startWebServer(8005);
	}

	public void startWebServer(int port) {
		server = new Server(port);
		try {
			server.setHandler(this);
			server.start();
		} catch (Exception e) {
			throw new RuntimeException("cannot start webserver in port " + port);
		}
	}
	
	public void reset() {
		context = new EvalContext(context.getOutputStream(), context.getErrorStream());
	}
	
	public void eval(String s) {
		PrintWriter w = new PrintWriter(context.getOutputStream());
		for(AplBusyListener listener : listeners) listener.evaluationStarted();
		try {
			IValue rval = parse(s).eval(context);
			w.println(rval.asString(printConfig));
			w.flush();
		} finally {
			for(AplBusyListener listener : listeners) listener.evaluationEnded();			
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
			} catch(TokenMgrError tme) {
				errorStream.println("LEXICAL ERROR");
				parser.skipTo(parser.STMTSEPARATOR);
				errorStream.flush();
			} catch(ArithmeticException ae) {
				errorStream.println("DIVBYZERO");
				errorStream.flush();
			} catch(AplError aple) {
				errorStream.println(aple.getMessage());
				errorStream.flush();
				parser.skipTo(parser.STMTSEPARATOR);
			} catch(Exception e) {
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

	public static void main(String[] args) {
		new Interpreter(System.out, System.err).eval(System.in);
	}

	public void addBusyListener(AplBusyListener listener) {
		listeners.add(listener);
	}

	@Override
	public void handle(String target, Request baseReq, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String id = target.substring(1);
		if(!context.isBound(id)) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			baseReq.setHandled(true);
			return;
		}
		String val = context.get(id).asString(printConfig);
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().write(val);
		baseReq.setHandled(true);
	}

}
