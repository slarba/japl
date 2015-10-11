package com.mlt.japl.ast;

import com.mlt.japl.parser.AplBaseVisitor;
import com.mlt.japl.parser.AplParser.*;
import jdk.nashorn.internal.ir.Terminal;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class AstBuilderVisitor extends AplBaseVisitor<AstNode> {

    public AstBuilderVisitor() {
    }

    AstNode[] collect(List<? extends ParserRuleContext> items) {
        AstNode[] result = new AstNode[items.size()];
        int i = 0;
        for (ParseTree t : items) {
            result[i++] = visit(t);
        }
        return result;
    }

    @Override
    public AstNode visitInteractive(InteractiveContext ctx) {
        return visit(ctx.toplevelexpr());
    }

    @Override
    public AstNode visitFloating(FloatingContext ctx) {
        return new AstFloat(ctx.FLOAT().getText());
    }

    @Override
    public AstNode visitInteger(IntegerContext ctx) {
        return new AstInt(ctx.INT().getText());
    }

    @Override
    public AstNode visitComplexnum(ComplexnumContext ctx) {
        return new AstComplex(ctx.getText());
    }

    @Override
    public AstNode visitString(StringContext ctx) {
        IndexContext index = ctx.index();
        AstNode str = new AstString(ctx.STRING().getText());
        if (index == null) {
            return str;
        } else {
            return new AstIndex(str, visit(index));
        }
    }

    @Override
    public AstNode visitSubarrayexpr(SubarrayexprContext ctx) {
        IndexContext index = ctx.index();
        AstNode array = visit(ctx.arrayexpr());
        if (index == null) {
            return array;
        } else {
            return new AstIndex(array, visit(index));
        }
    }

    @Override
    public AstNode visitIdent(IdentContext ctx) {
        IndexContext index = ctx.index();
        AstNode array = new AstRef(ctx.ID().getText());
        if (index == null) {
            return array;
        } else {
            return new AstIndex(array, visit(index));
        }
    }

    // ;3    -> empty 3
    // 3;    -> 3 empty
    // 3;4   -> 3 4
    // 3;;4  -> 3 empty 4
    // ;;    -> empty empty empty
    @Override
    public AstNode visitIndex(IndexContext ctx) {
        List<IndexelementContext> indices = ctx.indexelement();
        List<AstNode> result = new ArrayList<>();
        boolean insertEmpty = true;
        for(int i=0; i<indices.size(); i++) {
            IndexelementContext iec = indices.get(i);
            if(iec.SEMICOLON()!=null) {
                if(insertEmpty)
                    result.add(new AstEmptyArray());
                else
                    insertEmpty = true;
                if(i==indices.size()-1) {
                    result.add(new AstEmptyArray());
                    break;
                }
            } else {
                result.add(visit(indices.get(i)));
                insertEmpty = false;
            }
        }
        return new AstArray(result.toArray(new AstNode[0]));
    }

    @Override
    public AstNode visitArray(ArrayContext ctx) {
        AstNode[] items = collect(ctx.arrayitem());
        if (items.length == 1) {
            return items[0];
        }
        return new AstArray(items);
    }

    @Override
    public AstNode visitIf_expr(If_exprContext ctx) {
        AstNode cond = visit(ctx.condition);
        AstNode thenb = visit(ctx.thenbranch);
        AstNode elseb = null;
        List<AstNode> elifs = new ArrayList<>();
        List<AstNode> elifthens = new ArrayList<>();
        for (ElseifsContext c : ctx.elseifs()) {
            elifs.add(visit(c.arrayexpr()));
            elifthens.add(visit(c.expr_list()));
        }
        if(ctx.elsebranch!=null) elseb = visit(ctx.elsebranch);
        return new AstIfNode(cond, thenb, elseb, elifs.toArray(new AstNode[elifs.size()]), elifthens.toArray(new AstNode[elifs.size()]));
    }

    @Override
    public AstNode visitWhile_expr(While_exprContext ctx) {
        return new AstWhileNode(visit(ctx.arrayexpr()), visit(ctx.expr_list()));
    }

    @Override
    public AstNode visitRepeat_expr(Repeat_exprContext ctx) {
        return new AstRepeatNode(visit(ctx.arrayexpr()), visit(ctx.expr_list()));
    }

    @Override
    public AstNode visitExpr_list(Expr_listContext ctx) {
        return new AstStatementList(collect(ctx.toplevelexpr()));
    }

    @Override
    public AstNode visitLambdafunc(LambdafuncContext ctx) {
        AstNode fn = new AstLambda(collect(ctx.guard_or_assignment()), visit(ctx.arrayexpr()));
        return fn;
    }

    @Override
    public AstNode visitFnassignment(FnassignmentContext ctx) {
        return new AstAssignment(ctx.ID().getText(), visit(ctx.func_operator()));
    }

    @Override
    public AstNode visitExpr_assign(Expr_assignContext ctx) {
        return new AstAssignment(ctx.ident().ID().getText(), visit(ctx.arrayexpr()));
    }

    @Override
    public AstNode visitStrandassignment(StrandassignmentContext ctx) {
        List<TerminalNode> ids = ctx.ID();
        AstNode expr = visit(ctx.arrayexpr());
        if (ids.size() > 1) {
            String[] tids = new String[ids.size()];
            for (int i = 0; i < tids.length; i++) tids[i] = ids.get(i).getText();
            return new AstStrandAssignment(tids, expr);
        } else {
            return new AstAssignment(ids.get(0).getText(), expr);
        }
    }

//    @Override
//    public AstNode visitSingleassignment(SingleassignmentContext ctx) {
//        return new AstAssignment(ctx.ID().getText(), visit(ctx.arrayexpr()));
//    }

    @Override
    public AstNode visitMonadic_call_or_niladic(Monadic_call_or_niladicContext ctx) {
        ArrayexprContext array = ctx.arrayexpr();
        AstFunc func = (AstFunc) visit(ctx.func_operator());
        if (array == null) {
            return new AstNiladicCall(func);
        } else {
            return new AstMonadicCall(func, visit(array));
        }
    }

    @Override
    public AstNode visitDyadic_call_or_array(Dyadic_call_or_arrayContext ctx) {
        if (ctx.fn == null) {
            return visit(ctx.l);
        } else
            return new AstDyadicCall((AstFunc) visit(ctx.fn), visit(ctx.l), visit(ctx.r));
    }


    @Override
    public AstNode visitLambda(LambdaContext ctx) {
        return visit(ctx.lambdafunc());
    };

    @Override
    public AstNode visitOuterproduct(OuterproductContext ctx) {
        return new AstOuterproduct((AstFunc)visit(ctx.func()));
    }

    @Override
    public AstNode visitBoundfunc(BoundfuncContext ctx) {
        return new AstBoundFunc(visit(ctx.arrayitem()), (AstFunc)visit(ctx.func()));
    }

    @Override
    public AstNode visitPowerfunc(PowerfuncContext ctx) {
        return new AstPowerFunc((AstFunc)visit(ctx.func()), visit(ctx.arrayitem()));
    }

    @Override
    public AstNode visitInnerprod(InnerprodContext ctx) {
        return new AstInnerproduct((AstFunc)visit(ctx.outer), (AstFunc)visit(ctx.inner));
    }

    @Override
    public AstNode visitSimplefunc(SimplefuncContext ctx) {
        AstNode axis = null;
        if(ctx.axis()!=null) {
            axis = visit(ctx.axis());
        }
        return new AstSimpleFunc(ctx.FUNC().getText(), axis);
    }

    @Override
    public AstNode visitIdfunc(IdfuncContext ctx) {
        return new AstFuncRef(ctx.ID().getText());
    }

    @Override
    public AstNode visitAxis(AxisContext ctx) {
        return visit(ctx.arrayexpr());
    }

    @Override
    public AstNode visitFunc_oper_no_parens(Func_oper_no_parensContext ctx) {
        AstNode axis = null;
        if(ctx.axis()!=null) {
            axis = visit(ctx.axis());
        }
        if(ctx.OPERATOR() != null) {
            return new AstOperator(ctx.OPERATOR().getText(), visit(ctx.func()), axis);
        }
        return visit(ctx.func());
    }

    @Override
    public AstNode visitFunc_with_parens(Func_with_parensContext ctx) {
        return visit(ctx.func());
    }

    @Override
    public AstNode visitFunc_oper_with_parens(Func_oper_with_parensContext ctx) {
        return visit(ctx.func_operator());
    }

    @Override
    public AstNode visitOperator_as_func(Operator_as_funcContext ctx) {
        AstNode axis = null;
        if(ctx.axis()!=null) {
            axis = visit(ctx.axis());
        }
        return new AstSimpleFunc(ctx.OPERATOR().getText(), axis);
    }

    @Override
    public AstNode visitGuard(GuardContext ctx) {
        return new AstGuardExpr(visit(ctx.arrayexpr(0)), visit(ctx.arrayexpr(1)));
    }

    @Override
    public AstNode visitToplevelfunc(ToplevelfuncContext ctx) {
        String retvar = null;
        String leftarg = null;
        String rightarg = null;
        String fnname = null;
        if(ctx.ret!=null) {
            retvar = ctx.ret.getText();
        }
        if(ctx.c!=null) {
            fnname = ctx.b.getText();
            leftarg = ctx.a.getText();
            rightarg = ctx.c.getText();
        } else {
            fnname = ctx.a.getText();
            if(ctx.b!=null)
                rightarg = ctx.b.getText();
        }
        String[] locals = new String[ctx.localslist().ID().size()];
        for(int i=0; i<locals.length; i++) {
            locals[i] = ctx.localslist().ID(i).getText();
        }
        return new AstToplevelFunc(fnname, retvar, visit(ctx.expr_list()), leftarg, rightarg, locals);
    }

    @Override
    public AstNode visitToplevel(ToplevelContext ctx) {
        return visit(ctx.expr_list());
    }
}
