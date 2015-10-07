package com.mlt.japl.newast;

public class AstLambda extends AstFunc {

    private AstNode body;
    private AstNode[] guards_assignments;

    public AstLambda(AstNode[] astNodes, AstNode body) {
        this.guards_assignments = astNodes;
        this.body = body;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\n");
        for (AstNode n : guards_assignments) builder.append(AstNode.indent("   ", n.toString()));
        builder.append(AstNode.indent("   ", body.toString()));
        builder.append("}");
        return builder.toString();
    }
}
