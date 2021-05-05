// Generated from D:/Study/Gian/Grammar\Gian.g4 by ANTLR 4.9.1
package com.gsy.gian;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GianParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GianVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GianParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(GianParser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link GianParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(GianParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GianParser#className}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassName(GianParser.ClassNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link GianParser#superClassName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperClassName(GianParser.SuperClassNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link GianParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(GianParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link GianParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(GianParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GianParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(GianParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GianParser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(GianParser.FunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link GianParser#functionArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionArgument(GianParser.FunctionArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link GianParser#functionParamdefaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParamdefaultValue(GianParser.FunctionParamdefaultValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link GianParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(GianParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GianParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(GianParser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GianParser#classType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassType(GianParser.ClassTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GianParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(GianParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GianParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(GianParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GianParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(GianParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GianParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(GianParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link GianParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(GianParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by {@link GianParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(GianParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GianParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(GianParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GianParser#varReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarReference(GianParser.VarReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link GianParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(GianParser.ValueContext ctx);
}