package com.mlt.japl.ast;

/**
 * Created by markolau on 19/10/15.
 */

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.MixedArray;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.workspace.EvalContext;

public class AstIndexArray implements AstNode {

    private AstNode[] items;

    public AstIndexArray(AstNode[] result) {
        items = result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < items.length; i++) {
            builder.append(items[i].toString());
            if (i < items.length - 1) builder.append(';');
        }
        builder.append("]");
        return builder.toString();
    }

    @Override
    public IValue eval(EvalContext context) {
        IValue[] vals = new IValue[items.length];
        for (int i = vals.length-1; i >= 0; i--) {
            vals[i] = items[i].eval(context);
        }
        return new MixedArray(new Dimensions(vals.length), vals);
    }
}
