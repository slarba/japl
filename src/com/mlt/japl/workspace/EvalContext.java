package com.mlt.japl.workspace;

import java.io.OutputStream;
import java.util.HashMap;

import com.mlt.japl.errors.ValueError;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.IntArray;
import com.mlt.japl.newfns.Func;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.utils.PrintConfig;

public class EvalContext {
	HashMap<String, IValue> valueMap = new HashMap<String,IValue>();
	HashMap<String, Func> functionMap = new HashMap<String,Func>();
	EvalContext parent;
	OutputStream out;
	private OutputStream error;
	
	public void reset() {
		valueMap = new HashMap<String,IValue>();
		functionMap = new HashMap<String,Func>();		
	}
	
	public IValue get(String id) {
		if(valueMap.containsKey(id)) {
			return valueMap.get(id);
		} else if(parent!=null) {
			return parent.get(id);
		} else
			throw new ValueError();
	}

	public IValue set(String id, IValue eval) {
		if(parent!=null && parent.tryReplace(id, eval)) {
			return eval;
		} else
			valueMap.put(id, eval);
		return eval;
	}

	protected boolean tryReplace(String id, IValue eval) {
		if(valueMap.containsKey(id)) {
			valueMap.put(id, eval);
			return true;
		} else {
			if(parent!=null) return parent.tryReplace(id, eval);
		}
		return false;
	}

	public Func set(String id, Func eval) {
		functionMap.put(id, eval);
		return eval;
	}
	
	public EvalContext() {
		valueMap.put("\u236c", new IntArray(Dimensions.EMPTY_ARRAY, new long[0]));
	}
	
	public EvalContext(EvalContext parent) {
		this();
		this.parent = parent;
	}
	
	public EvalContext(OutputStream out) {
		this();
		this.out = out;
	}

	public EvalContext(EvalContext parent, OutputStream out) {
		this();
		this.parent = parent;
		this.out = out;
	}
	
	public EvalContext(OutputStream out, OutputStream error) {
		this();
		this.out = out;
		this.error = error;
	}

	public EvalContext newFrame() {
		return new EvalContext(this, out);
	}

	public OutputStream getOutputStream() {
		return out;
	}

	public OutputStream getErrorStream() {
		return error;
	}
	
	public Func tryGetFunction(String id) {
		if(!functionMap.containsKey(id))
			throw new ValueError();
		else
			return functionMap.get(id);
	}

	public boolean isBoundToFunction(String id) {
		if(!functionMap.containsKey(id)) {
			if(parent!=null){
				return parent.isBoundToFunction(id);
			} else
				return false;
		}
		return true;
	}

	public PrintConfig printConfig() {
		return new PrintConfig();
	}
}
