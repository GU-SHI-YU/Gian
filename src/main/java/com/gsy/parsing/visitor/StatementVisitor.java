package com.gsy.parsing.visitor;

import com.gsy.domain.Instruction;
import com.gsy.domain.PrintVariable;
import com.gsy.domain.Variable;
import com.gsy.domain.VariableDeclaration;
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
public class StatementVisitor extends GianBaseVisitor<Instruction> {

    private final Queue<Instruction> instructionQueue = new ArrayDeque<>();
    private final Map<String, Variable> variableMap = new HashMap<>();

    @Override
    public Instruction visitVariable(GianParser.VariableContext ctx) {

        final TerminalNode varName = ctx.ID();
        final GianParser.ValueContext varValue = ctx.value();
        final int varType = varValue.getStart().getType();
        final int varIndex = variableMap.size();
        final String varTextValue = varValue.getText();
        Variable var = new Variable(varIndex, varType, varTextValue);
        variableMap.put(varName.getText(), var);
        VariableDeclaration variableDeclaration = new VariableDeclaration(var);
        instructionQueue.add(variableDeclaration);
        logVariableDeclarationStatementFound(varName, varValue);
        return variableDeclaration;
    }

    @Override
    public Instruction visitPrint(GianParser.PrintContext ctx) {

        final TerminalNode varName = ctx.ID();
        final boolean printedVarNotDeclared = !variableMap.containsKey(varName.getText());
        if (printedVarNotDeclared) {
            final String errorFormat = "ERROR: You are trying to print var '%s' which has not been declared!.";
            System.err.printf(errorFormat, varName.getText());
            return null;
        }
        final Variable variable = variableMap.get(varName.getText());
        PrintVariable printVariable = new PrintVariable(variable);
        instructionQueue.add(printVariable);
        logPrintStatementFound(varName, variable);
        return printVariable;
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
