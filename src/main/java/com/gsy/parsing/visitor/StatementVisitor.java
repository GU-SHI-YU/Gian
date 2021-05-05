package com.gsy.parsing.visitor;

import com.gsy.domain.Instruction;
import com.gsy.domain.PrintVariable;
import com.gsy.domain.Variable;
import com.gsy.domain.expression.Expression;
import com.gsy.domain.scope.LocalVariable;
import com.gsy.domain.scope.Scope;
import com.gsy.domain.statement.PrintStatement;
import com.gsy.domain.statement.Statement;
import com.gsy.domain.statement.VariableDeclarationStatement;
import com.gsy.domain.type.Type;
import com.gsy.gian.GianBaseVisitor;
import com.gsy.gian.GianParser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

@Getter
@AllArgsConstructor
public class StatementVisitor extends GianBaseVisitor<Statement> {

    private final Scope scope;
    private final Queue<Instruction> instructionQueue = new ArrayDeque<>();
    private final Map<String, Variable> variableMap = new HashMap<>();

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

    private void logVariableDeclarationStatementFound(TerminalNode varName, GianParser.ValueContext varValue) {

        final int line = varName.getSymbol().getLine();
        final String format = "OK: You declared variable named '%s' with value of '%s' at line '%s'.\n";
        System.out.printf(format, varName, varValue.getText(), line);
    }

    private void logPrintStatementFound(TerminalNode varName, Variable variable) {

        final int line = varName.getSymbol().getLine();
        final String format = "OK: You instructed to print variable '%s' which has value of '%s' at line '%s'.'\n";
        System.out.printf(format, variable.getID(), variable.getValue(), line);
    }
}
