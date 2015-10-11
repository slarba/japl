package com.mlt.japl.ast;

import com.mlt.japl.errors.AplError;
import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.FuncValue;
import com.mlt.japl.fns.EachFn;
import com.mlt.japl.fns.ReduceFn;
import com.mlt.japl.fns.ScanFn;
import com.mlt.japl.workspace.EvalContext;

/**
 * Created by markolau on 07/10/15.
 */
public class AstOperator extends AstFunc {
    private final String operator;
    private final AstNode fn;
    private final AstNode axis;

    public AstOperator(String text, AstNode visit, AstNode axis) {
        this.operator = text;
        this.fn = visit;
        this.axis = axis;
    }

    @Override
    public String toString() {
        return "(" + fn.toString() + ")" + operator + (axis!=null ? ("[" + axis.toString() + "]") : "");
    }

    @Override
    public IValue eval(EvalContext context) {
        FuncValue func = (FuncValue)fn.eval(context);

        switch(operator) {
            case "/":
                return new FuncValue(new ReduceFn(func.get(), false));
            case "\u233f":
                return new FuncValue(new ReduceFn(func.get(), true));
            case "\\":
                return new FuncValue(new ScanFn(func.get(), false));
            case "\u2340":
                return new FuncValue(new ScanFn(func.get(), true));
            case "¨":
                return new FuncValue(new EachFn(func.get()));
            default:
                throw new AplError();
        }
    }
}
