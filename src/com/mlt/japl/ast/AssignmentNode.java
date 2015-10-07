package com.mlt.japl.ast;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.IntArray;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.workspace.EvalContext;
import com.mlt.japl.workspace.Var;

import java.io.PrintWriter;

public class AssignmentNode implements AstNode {

    private AstNode expr;
    private String id;
    private Var var;

    public AssignmentNode(String id, AstNode expr) {
        this.id = id;
        this.expr = expr;
    }

    @Override
    public IValue eval(EvalContext context) {
        if (id.equals("\u2395")) {
            IValue result = expr.eval(context);
            PrintWriter w = new PrintWriter(context.getOutputStream());
            w.print(result.asString(context.printConfig()));
            w.flush();
            return result;
        }
        if (expr instanceof NiladicCallNode) {
            NiladicCallNode n = (NiladicCallNode) expr;
            context.set(id, n.func());
            return new IntArray(Dimensions.EMPTY_ARRAY, new long[0]);
        }
        IValue v = expr.eval(context).force();
        if (var != null) {
            var.set(v);
        } else {
            var = context.set(id, v);
        }
        return v;
    }

    @Override
    public String print() {
        return id + " <- " + expr.print();
    }
}
