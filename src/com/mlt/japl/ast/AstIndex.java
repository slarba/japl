package com.mlt.japl.ast;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.interf.IIntArray;
import com.mlt.japl.arrays.interf.IMixedArray;
import com.mlt.japl.errors.IndexError;
import com.mlt.japl.workspace.EvalContext;

public class AstIndex implements AstNode {

    private AstNode expr;
    private AstNode indexexpr;

    public AstIndex(AstNode str, AstNode visit) {
        this.expr = str;
        this.indexexpr = visit;
    }

    @Override
    public String toString() {
        return expr + "[" + indexexpr + "]";
    }

    @Override
    public IValue eval(EvalContext context) {
        IValue index = indexexpr.eval(context);
        IValue val = expr.eval(context);
        if(index instanceof IMixedArray) {
            return val.get((IMixedArray)index);
        }
        throw new IndexError();
    }
}
