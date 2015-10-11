// Generated from /Users/markolau/IdeaProjects/Japl/src/com/mlt/japl/newparser/Apl.g4 by ANTLR 4.5.1
package com.mlt.japl.newparser;

import java.util.*;
import com.mlt.japl.workspace.EvalContext;
import com.mlt.japl.newast.AstFunc;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AplParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AplVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AplParser#sep}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSep(AplParser.SepContext ctx);
	/**
	 * Visit a parse tree produced by {@link AplParser#toplevel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToplevel(AplParser.ToplevelContext ctx);
	/**
	 * Visit a parse tree produced by {@link AplParser#interactive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteractive(AplParser.InteractiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link AplParser#toplevelexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToplevelexpr(AplParser.ToplevelexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link AplParser#expr_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_list(AplParser.Expr_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link AplParser#if_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_expr(AplParser.If_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link AplParser#for_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_expr(AplParser.For_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link AplParser#while_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_expr(AplParser.While_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link AplParser#repeat_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeat_expr(AplParser.Repeat_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_assign}
	 * labeled alternative in {@link AplParser#arrayexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_assign(AplParser.Expr_assignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code monadic_call_or_niladic}
	 * labeled alternative in {@link AplParser#arrayexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMonadic_call_or_niladic(AplParser.Monadic_call_or_niladicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dyadic_call_or_array}
	 * labeled alternative in {@link AplParser#arrayexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDyadic_call_or_array(AplParser.Dyadic_call_or_arrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fnassignment}
	 * labeled alternative in {@link AplParser#toplevelassignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFnassignment(AplParser.FnassignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code strandassignment}
	 * labeled alternative in {@link AplParser#toplevelassignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrandassignment(AplParser.StrandassignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link AplParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(AplParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link AplParser#arrayitem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayitem(AplParser.ArrayitemContext ctx);
	/**
	 * Visit a parse tree produced by {@link AplParser#subarrayexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubarrayexpr(AplParser.SubarrayexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link AplParser#integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(AplParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by {@link AplParser#floating}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloating(AplParser.FloatingContext ctx);
	/**
	 * Visit a parse tree produced by {@link AplParser#complexnum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComplexnum(AplParser.ComplexnumContext ctx);
	/**
	 * Visit a parse tree produced by {@link AplParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(AplParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by {@link AplParser#ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdent(AplParser.IdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link AplParser#index}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex(AplParser.IndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link AplParser#indexelement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexelement(AplParser.IndexelementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code func_oper_no_parens}
	 * labeled alternative in {@link AplParser#func_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_oper_no_parens(AplParser.Func_oper_no_parensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code operator_as_func}
	 * labeled alternative in {@link AplParser#func_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator_as_func(AplParser.Operator_as_funcContext ctx);
	/**
	 * Visit a parse tree produced by the {@code func_oper_with_parens}
	 * labeled alternative in {@link AplParser#func_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_oper_with_parens(AplParser.Func_oper_with_parensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idfunc}
	 * labeled alternative in {@link AplParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdfunc(AplParser.IdfuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code powerfunc}
	 * labeled alternative in {@link AplParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowerfunc(AplParser.PowerfuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simplefunc}
	 * labeled alternative in {@link AplParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimplefunc(AplParser.SimplefuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lambda}
	 * labeled alternative in {@link AplParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda(AplParser.LambdaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code outerproduct}
	 * labeled alternative in {@link AplParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOuterproduct(AplParser.OuterproductContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boundfunc}
	 * labeled alternative in {@link AplParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoundfunc(AplParser.BoundfuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code func_with_parens}
	 * labeled alternative in {@link AplParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_with_parens(AplParser.Func_with_parensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code innerprod}
	 * labeled alternative in {@link AplParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInnerprod(AplParser.InnerprodContext ctx);
	/**
	 * Visit a parse tree produced by {@link AplParser#axis}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAxis(AplParser.AxisContext ctx);
	/**
	 * Visit a parse tree produced by {@link AplParser#lambdafunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdafunc(AplParser.LambdafuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link AplParser#toplevelfunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToplevelfunc(AplParser.ToplevelfuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link AplParser#localslist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalslist(AplParser.LocalslistContext ctx);
	/**
	 * Visit a parse tree produced by {@link AplParser#guard_or_assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuard_or_assignment(AplParser.Guard_or_assignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link AplParser#guard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuard(AplParser.GuardContext ctx);
}