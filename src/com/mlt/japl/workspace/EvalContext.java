package com.mlt.japl.workspace;

import java.io.OutputStream;
import java.util.HashMap;

import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.errors.ValueError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.iface.Func;
import com.mlt.japl.utils.PrintConfig;

public class EvalContext {
	HashMap<String, Array> valueMap = new HashMap<String,Array>();
	HashMap<String, Func> functionMap = new HashMap<String,Func>();
	EvalContext parent;
	OutputStream out;
	
	public Array get(String id) {
		if(valueMap.containsKey(id)) {
			return valueMap.get(id);
		} else if(parent!=null) {
			return parent.get(id);
		} else
			throw new ValueError();
	}

	public Array set(String id, Array eval) {
		valueMap.put(id, eval);
		return eval;
	}

	public Func set(String id, Func eval) {
		functionMap.put(id, eval);
		return eval;
	}
	
	public EvalContext() {
		valueMap.put("\u236c", new IntArray());
	}
	
	public EvalContext(EvalContext parent) {
		this.parent = parent;
	}
	
	public EvalContext(OutputStream out) {
		this.out = out;
	}

	public EvalContext(EvalContext parent, OutputStream out) {
		this.parent = parent;
		this.out = out;
	}
	
	public EvalContext newFrame() {
		return new EvalContext(this, out);
	}

	public OutputStream getOutputStream() {
		return out;
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
