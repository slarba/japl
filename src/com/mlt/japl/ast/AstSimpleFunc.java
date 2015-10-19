package com.mlt.japl.ast;

import com.mlt.japl.arrays.interf.IIntScalar;
import com.mlt.japl.errors.AxisError;
import com.mlt.japl.errors.ValueError;
import com.mlt.japl.arrays.IValue;
import com.mlt.japl.arrays.concrete.FuncValue;
import com.mlt.japl.fns.*;
import com.mlt.japl.utils.PrintConfig;
import com.mlt.japl.workspace.EvalContext;
import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

import java.util.HashMap;

/**
 * Created by markolau on 07/10/15.
 */
public class AstSimpleFunc extends AstFunc {
    private final String fn;
    private final AstNode axis;

    public AstSimpleFunc(String text, AstNode axis) {
        this.fn = text;
        this.axis = axis;
    }

    @Override
    public String toString() {
        return fn + (axis!=null ? ("[" + axis.toString() + "]") : "");
    }

    private Func getFn(String name, EvalContext context, int axis) {
        switch(name) {
            case "\u003f": return new RollFn(axis);
            case "\u002b": return new AddFn(axis);
            case "\u2212": return new SubFn(axis);
            case "\u00d7": return new MulFn(axis);
            case "\u22c6": return new ExpFn(axis);
            case "*": return new ExpFn(axis);
            case "\u235f": return new LogFn(axis);
            case "\u002c": return new RavelFn(axis,false);
            case "⍪": return new RavelFn(axis,true);
            case "\u230a": return new FloorFn(axis);
            case "\u2308": return new CeilFn(axis);
            case "\u2223": return new AbsFn(axis);
            case "\u0021": return new FacFn(axis);
            case "\u00f7": return new DivFn(axis);
            case "\u2374": return new RhoFn(axis);
            case "\u2373": return new IotaFn(axis);
            case "\u25cb": return new TrigFn(axis);
            case "\u220a": return new ExistsFn(axis);
            case "\u003c": return new LtFn(axis);
            case "\u003e": return new GtFn(axis);
            case "\u2264": return new LteFn(axis);
            case "\u2265": return new GteFn(axis);
            case "\u003d": return new EqFn(axis);
            case "\u223c": return new NotFn(axis);
            case "\u2260": return new NeqFn(axis);
            case "\u2228": return new OrFn(axis);  // logical or
            case "\u2227": return new AndFn(axis);  // logical and
            case "\u2371": return new NorFn(axis);  // nor
            case "\u2372": return new NandFn(axis);  // nand
            case "\u2349": return new ReverseFn(axis);
            case "\u233d": return new RotateFn(axis,false);
            case "\u2296": return new RotateFn(axis,true);
            case "\u2191": return new TakeFn(axis);
            case "\u2193": return new DropFn(axis);
            case "\u2261": return new DepthFn(axis);
            case "\u2282": return new EncloseFn(axis);
            case "\u2283": return new DiscloseFn(axis);
//		map.put("\u22a5", new DecodeFn());
//		map.put("\....", new EncodeFn());
            case "\u222a": return new UnionFn(axis);
            case "∩": return new IntersectionFn(axis);
            case "\u22a3": return new StopFn(axis);
            case "\u22a2": return new PassFn(axis);
            case "/": return new ReplicateFn(axis,false);
            case "\u233f": return new ReplicateFn(axis,true);
            case "⍬": return new ZildeFn(axis);
            case "⍎": return new ExecuteFn(axis,context);
            case "⎕NEW": return new NewFn(axis);
            case "⎕SLURP": return new SlurpFn(axis);
            case "⎕SS": return new StringSearchFn(axis);
            case "⍕": return new FormatFn(axis,new PrintConfig());
//		case "\\": new ExpandFn(false));
//		case "\u2340": new ExpandFn(true));
            case "\u234b": return new GradeUpFn(axis);
            case "\u2352": return new GradeDownFn(axis);
            case "\u2337": return new IndexFn(axis);
            default:
                throw new ValueError();
        }
    }

    @Override
    public IValue eval(EvalContext context) {
        long axis = -1;
        if(this.axis!=null) {
            IValue ax = this.axis.eval(context);
            if (!(ax instanceof IIntScalar)) throw new AxisError();
            axis = ((IIntScalar)ax).get()-1;
            if(axis<0) throw new AxisError();
        }
        Func f = getFn(fn, context, (int)axis);
        return new FuncValue(f);
    }
}
