package com.mlt.japl.newast;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.workspace.EvalContext;

public class AstStatementList implements AstNode {

    private AstNode[] stmts;

    public AstStatementList(AstNode[] stmts) {
        this.stmts = stmts;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (AstNode s : stmts) {
            builder.append(s.toString());
            builder.append('\n');
        }
        return builder.toString();
    }

    @Override
    public IValue eval(EvalContext context) {
        IValue result = null;
        for(int i=0; i<stmts.length; i++) result = stmts[i].eval(context);
        return result;
    }
}
