// Generated from D:/Study/Gian/Grammar\Gian.g4 by ANTLR 4.9.1
package com.gsy.gian;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GianParser}.
 */
public interface GianListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GianParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(GianParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link GianParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(GianParser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link GianParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(GianParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GianParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(GianParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GianParser#className}.
	 * @param ctx the parse tree
	 */
	void enterClassName(GianParser.ClassNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link GianParser#className}.
	 * @param ctx the parse tree
	 */
	void exitClassName(GianParser.ClassNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link GianParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(GianParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link GianParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(GianParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link GianParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(GianParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link GianParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(GianParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link GianParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(GianParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link GianParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(GianParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link GianParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(GianParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link GianParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(GianParser.ValueContext ctx);
}