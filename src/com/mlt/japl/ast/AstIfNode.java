package com.mlt.japl.ast;

import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.IntScalar;
import com.mlt.japl.workspace.EvalContext;

public class AstIfNode implements AstNode {

    private AstNode cond;
    private AstNode thenb;
    private AstNode elseb;
    private AstNode[] elifs;
    private AstNode[] elifthens;

    public AstIfNode(AstNode cond, AstNode thenb, AstNode elseb, AstNode[] elifs, AstNode[] elifthens) {
        this.cond = cond;
        this.thenb = thenb;
        this.elseb = elseb;
        this.elifs = elifs;
        this.elifthens = elifthens;
    }

    @Override
    public String toString() {
        return "IF(" + cond + ") {\n" + AstNode.indent("   ", thenb.toString()) + "}";
    }

    @Override
    public IValue eval(EvalContext context) {
        if(cond.eval(context).equals(IntScalar.ONE)) {
            return thenb.eval(context);
        } else {
            if(elifs.length>0) {
                for(int i=0; i<elifs.length; i++) {
                    if(elifs[i].eval(context).equals(IntScalar.ONE)) return elifthens[i].eval(context);
                }
            }
            if(elseb!=null)
                return elseb.eval(context);
            else
                return null;
        }
    }
}
