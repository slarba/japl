package com.mlt.japl.ast;

import com.mlt.japl.parser.AplBaseVisitor;
import com.mlt.japl.parser.AplParser;
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
        String text = ctx.STRING().getText();
        AstNode str = new AstString(text);
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
        String namespace = null;
        if(ctx.namespaceprefix()!=null) {
            namespace = createNamespacePrefix(ctx.namespaceprefix());
        }
        AstNode array = new AstRef(ctx.non_fn_id().ID().getText(), namespace);
        return array;
    }

    @Override
    public AstNode visitIdent_idx(Ident_idxContext ctx) {
        if(ctx.index()!=null) {
            return new AstIndex(visit(ctx.ident()), visit(ctx.index()));
        }
        return visit(ctx.ident());
    }

    private String createNamespacePrefix(NamespaceprefixContext ctx) {
        StringBuilder builder = new StringBuilder();
        for(Non_fn_idContext c : ctx.non_fn_id()) {
            builder.append(c.ID().getText());
            builder.append('.');
        }
        return builder.toString();
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
        return new AstAssignment(ctx.ID().getText(), visit(ctx.func()));
    }

//    @Override
//    public AstNode visitExpr_assign(Expr_assignContext ctx) {
//        return new AstAssignment(ctx.ident().non_fn_id().ID().getText(), visit(ctx.arrayexpr()));
//    }

    @Override
    public AstNode visitAssign(AssignContext ctx) {
        return visit(ctx.assignment());
    }

    @Override
    public AstNode visitStrandassignment(StrandassignmentContext ctx) {
        List<AnyidentContext> ids = ctx.anyident();
        AstFunc fn = null;
        if(ctx.func()!=null) {
            fn = (AstFunc)visit(ctx.func());
        }
        AstNode expr = visit(ctx.arrayexpr());
        if (ids.size() > 1) {
            String[] tids = new String[ids.size()];
            for (int i = 0; i < tids.length; i++) tids[i] = ids.get(i).ID().getText();
            return new AstStrandAssignment(tids, expr);
        } else {
            if(fn!=null) {
                String id = ids.get(0).ID().getText();
                return new AstAssignment(id, new AstDyadicCall(fn, new AstRef(id), expr));
            }
            return new AstAssignment(ids.get(0).ID().getText(), expr);
        }
    }

    @Override
    public AstNode visitMonadic_call(Monadic_callContext ctx) {
        ArrayexprContext array = ctx.arrayexpr();
        AstFunc func = (AstFunc) visit(ctx.func());
        return new AstMonadicCall(func, visit(array));
    }

    @Override
    public AstNode visitDyadic_call(Dyadic_callContext ctx) {
        if(ctx.fn != null) {
            return new AstDyadicCall((AstFunc) visit(ctx.fn), visit(ctx.l), visit(ctx.r));
        } else {
            return visit(ctx.l);
        }
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
        String namespace = null;
        if(ctx.funcid().namespaceprefix()!=null) {
            namespace = createNamespacePrefix(ctx.funcid().namespaceprefix());
        }
        return new AstFuncRef(ctx.funcid().fn_id().ID().getText(), namespace);
    }

    @Override
    public AstNode visitAxis(AxisContext ctx) {
        return visit(ctx.arrayexpr());
    }

    @Override
    public AstNode visitFunc_with_parens(Func_with_parensContext ctx) {
        return visit(ctx.func());
    }

    @Override
    public AstNode visitFunc_with_operator(Func_with_operatorContext ctx) {
        AstFunc fn = (AstFunc)visit(ctx.func());
        String operator = ctx.OPERATOR().getText();
        AstNode axis = ctx.axis()!=null ? visit(ctx.axis()) : null;
        return new AstOperator(operator, fn, axis);
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
