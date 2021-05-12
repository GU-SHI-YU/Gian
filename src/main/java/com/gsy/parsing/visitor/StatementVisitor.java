package com.gsy.parsing.visitor;

import com.gsy.domain.expression.Expression;
import com.gsy.domain.scope.LocalVariable;
import com.gsy.domain.scope.Scope;
import com.gsy.domain.statement.PrintStatement;
import com.gsy.domain.statement.Statement;
import com.gsy.domain.statement.VariableDeclarationStatement;
import com.gsy.gian.GianBaseVisitor;
import com.gsy.gian.GianParser;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StatementVisitor extends GianBaseVisitor<Statement> {

    private final Scope scope;

    @Override
    public Statement visitPrintStatement(GianParser.PrintStatementContext ctx) {

        GianParser.ExpressionContext expressionContext = ctx.expression();
        ExpressionVisitor expressionVisitor = new ExpressionVisitor(scope);
        Expression expression = expressionContext.accept(expressionVisitor);
        return new PrintStatement(expression);
    }

    @Override
    public Statement visitVariableDeclaration(GianParser.VariableDeclarationContext ctx) {

        GianParser.ExpressionContext expressionContext = ctx.expression();
        ExpressionVisitor expressionVisitor = new ExpressionVisitor(scope);
        Expression expression = expressionContext.accept(expressionVisitor);
        String name = ctx.name().getText();
        scope.addLocalVariable(new LocalVariable(name, expression.getType()));
        return new VariableDeclarationStatement(name, expression);
    }

    @Override
    public Statement visitFunctionCall(GianParser.FunctionCallContext ctx) {

        ExpressionVisitor expressionVisitor = new ExpressionVisitor(scope);
        return (Statement) ctx.accept(expressionVisitor);
    }
}
