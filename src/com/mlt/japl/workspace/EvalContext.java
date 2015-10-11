package com.mlt.japl.workspace;

import com.mlt.japl.errors.ValueError;
import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.FuncValue;
import com.mlt.japl.arrays.concrete.IntArray;
import com.mlt.japl.fns.Func;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.utils.PrintConfig;

import java.io.OutputStream;
import java.util.HashMap;

public class EvalContext {
    HashMap<String, Var> valueMap = new HashMap<String, Var>();
    HashMap<String, Func> functionMap = new HashMap<String, Func>();
    EvalContext parent;
    OutputStream out;
    private OutputStream error;

    public EvalContext() {
        valueMap.put("\u236c", new Var(new IntArray(Dimensions.EMPTY_ARRAY, new long[0])));
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

    public void reset() {
        valueMap = new HashMap<String, Var>();
        functionMap = new HashMap<String, Func>();
    }

    public Var get(String id) {
        if (valueMap.containsKey(id)) {
            return valueMap.get(id);
        } else if (parent != null) {
            return parent.get(id);
        } else
            throw new ValueError();
    }

    public Var set(String id, IValue eval) {
        Var var = findVar(id);
        if (var == null) {
            var = new Var(eval);
            valueMap.put(id, var);
        }
        var.set(eval);
        return var;
    }

    private Var findVar(String id) {
        if (valueMap.containsKey(id)) {
            return valueMap.get(id);
        } else if (parent != null) {
            return parent.findVar(id);
        } else
            return null;
    }

    public Func set(String id, Func eval) {
        functionMap.put(id, eval);
        return eval;
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
        if (!functionMap.containsKey(id))
            throw new ValueError();
        else
            return functionMap.get(id);
    }

    public boolean isBoundToFunction(String id) {
        Var v = findVar(id);
        if(v==null) return false;
        if(v.get() instanceof FuncValue) return true;
        return false;
    }

    public PrintConfig printConfig() {
        return new PrintConfig();
    }

    public boolean isBound(String id) {
        if (valueMap.containsKey(id)) return true;
        if (parent != null) return parent.isBound(id);
        return false;
    }
}
