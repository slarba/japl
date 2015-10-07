package com.mlt.japl.ast;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.IntArray;
import com.mlt.japl.newarrays.concrete.MixedArray;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.workspace.EvalContext;

import java.util.List;

public class IndexExprNode implements AstNode {

    private List<AstNode> chain;

    public IndexExprNode(List<AstNode> chain) {
        this.chain = chain;
    }

    @Override
    public IValue eval(EvalContext context) {
        IValue[] data = new IValue[chain.size()];
        for (int i = chain.size() - 1; i >= 0; i--) {
            AstNode n = chain.get(i);
            if (n != null)
                data[i] = n.eval(context);
            else
                data[i] = IntArray.EMPTY;
        }
        return new MixedArray(new Dimensions(data.length), data);
    }

    @Override
    public String print() {
        StringBuilder builder = new StringBuilder();
        int j = 0;
        for (AstNode n : chain) {
            if (n != null) {
                builder.append(n.print());
            }
            if (j < chain.size() - 1)
                builder.append(";");
            j++;
        }
        return builder.toString();
    }
}
