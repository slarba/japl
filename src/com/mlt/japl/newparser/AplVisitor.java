// Generated from /Users/markolau/IdeaProjects/Japl/src/com/mlt/japl/newparser/Apl.g4 by ANTLR 4.5.1
package com.mlt.japl.newparser;

import java.util.*;

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
	 * Visit a parse tree produced by {@link AplParser#arrayexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayexpr(AplParser.ArrayexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link AplParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(AplParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link AplParser#monadic_call_or_niladic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMonadic_call_or_niladic(AplParser.Monadic_call_or_niladicContext ctx);
	/**
	 * Visit a parse tree produced by {@link AplParser#dyadic_call_or_array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDyadic_call_or_array(AplParser.Dyadic_call_or_arrayContext ctx);
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
	 * Visit a parse tree produced by {@link AplParser#func_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_operator(AplParser.Func_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link AplParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(AplParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link AplParser#lambdafunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdafunc(AplParser.LambdafuncContext ctx);
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