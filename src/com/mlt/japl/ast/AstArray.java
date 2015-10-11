package com.mlt.japl.ast;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.generated.LazyMixedArray;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.workspace.EvalContext;

public class AstArray implements AstNode {

    private AstNode[] items;

    public AstArray(AstNode[] result) {
        items = result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < items.length; i++) {
            builder.append(items[i].toString());
            if (i < items.length - 1) builder.append(',');
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
        return new LazyMixedArray(new Dimensions(vals.length)) {
            @Override
            public IValue get(int index) {
                return vals[index];
            }
        }.force();
    }
}
