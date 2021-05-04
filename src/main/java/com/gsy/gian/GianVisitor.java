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
	 * Visit a parse tree produced by {@link GianParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(GianParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link GianParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(GianParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link GianParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(GianParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link GianParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(GianParser.ValueContext ctx);
}