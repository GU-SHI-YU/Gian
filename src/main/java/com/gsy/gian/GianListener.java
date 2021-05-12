// Generated from D:/Study/CompilePrinciple/Gian/Grammar\Gian.g4 by ANTLR 4.9.1
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
	 * Enter a parse tree produced by {@link GianParser#superClassName}.
	 * @param ctx the parse tree
	 */
	void enterSuperClassName(GianParser.SuperClassNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link GianParser#superClassName}.
	 * @param ctx the parse tree
	 */
	void exitSuperClassName(GianParser.SuperClassNameContext ctx);
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
	 * Enter a parse tree produced by {@link GianParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(GianParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GianParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(GianParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GianParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(GianParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GianParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(GianParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GianParser#functionName}.
	 * @param ctx the parse tree
	 */
	void enterFunctionName(GianParser.FunctionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link GianParser#functionName}.
	 * @param ctx the parse tree
	 */
	void exitFunctionName(GianParser.FunctionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link GianParser#functionArgument}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArgument(GianParser.FunctionArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link GianParser#functionArgument}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArgument(GianParser.FunctionArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link GianParser#functionParamDefaultValue}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParamDefaultValue(GianParser.FunctionParamDefaultValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link GianParser#functionParamDefaultValue}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParamDefaultValue(GianParser.FunctionParamDefaultValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link GianParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(GianParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GianParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(GianParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GianParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(GianParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GianParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(GianParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GianParser#classType}.
	 * @param ctx the parse tree
	 */
	void enterClassType(GianParser.ClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GianParser#classType}.
	 * @param ctx the parse tree
	 */
	void exitClassType(GianParser.ClassTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GianParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(GianParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GianParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(GianParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GianParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(GianParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GianParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(GianParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GianParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(GianParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GianParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(GianParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GianParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(GianParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link GianParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(GianParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link GianParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(GianParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link GianParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(GianParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link GianParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(GianParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GianParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(GianParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarRef}
	 * labeled alternative in {@link GianParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVarRef(GianParser.VarRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarRef}
	 * labeled alternative in {@link GianParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVarRef(GianParser.VarRefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Add}
	 * labeled alternative in {@link GianParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAdd(GianParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link GianParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAdd(GianParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueExpr}
	 * labeled alternative in {@link GianParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterValueExpr(GianParser.ValueExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueExpr}
	 * labeled alternative in {@link GianParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitValueExpr(GianParser.ValueExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Divide}
	 * labeled alternative in {@link GianParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDivide(GianParser.DivideContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Divide}
	 * labeled alternative in {@link GianParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDivide(GianParser.DivideContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunCall}
	 * labeled alternative in {@link GianParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunCall(GianParser.FunCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunCall}
	 * labeled alternative in {@link GianParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunCall(GianParser.FunCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Multiply}
	 * labeled alternative in {@link GianParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiply(GianParser.MultiplyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Multiply}
	 * labeled alternative in {@link GianParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiply(GianParser.MultiplyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Subtract}
	 * labeled alternative in {@link GianParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSubtract(GianParser.SubtractContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Subtract}
	 * labeled alternative in {@link GianParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSubtract(GianParser.SubtractContext ctx);
	/**
	 * Enter a parse tree produced by {@link GianParser#varReference}.
	 * @param ctx the parse tree
	 */
	void enterVarReference(GianParser.VarReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link GianParser#varReference}.
	 * @param ctx the parse tree
	 */
	void exitVarReference(GianParser.VarReferenceContext ctx);
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