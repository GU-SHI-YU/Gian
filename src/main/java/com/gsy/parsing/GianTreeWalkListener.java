package com.gsy.parsing;

import com.gsy.domain.*;
import com.gsy.gian.GianBaseListener;
import com.gsy.gian.GianParser;
import lombok.Getter;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

@Getter
public class GianTreeWalkListener extends GianBaseListener {

    Queue<Instruction> instructionQueue = new ArrayDeque<>();
    Map<String, Variable> variableMap = new HashMap<>();
    private CompilationUnit compilationUnit;
    private ClassDeclaration classDeclaration;

    @Override
    public void exitVariable(GianParser.VariableContext ctx) {

        final TerminalNode varName = ctx.ID();
        final GianParser.ValueContext varValue = ctx.value();
        final int varType = varValue.getStart().getType();
        final int varIndex = variableMap.size();
        final String varTextValue = varValue.getText();
        Variable var = new Variable(varIndex, varType, varTextValue);
        variableMap.put(varName.getText(), var);
        instructionQueue.add(new VariableDeclaration(var));
        logVariableDeclarationStatementFound(varName, varValue);
    }

    @Override
    public void exitPrint(GianParser.PrintContext ctx) {

        final TerminalNode varName = ctx.ID();
        final boolean printedVarNotDeclared = !variableMap.containsKey(varName.getText());
        if (printedVarNotDeclared) {
            final String errorFormat = "ERROR: You are trying to print var '%s' which has not been declared!.";
            System.err.printf(errorFormat, varName.getText());
            return;
        }
        final Variable variable = variableMap.get(varName.getText());
        instructionQueue.add(new PrintVariable(variable));
        logPrintStatementFound(varName, variable);
    }

    @Override
    public void exitCompilationUnit(GianParser.CompilationUnitContext ctx) {

        compilationUnit = new CompilationUnit(classDeclaration);
    }

    @Override
    public void exitClassDeclaration(GianParser.ClassDeclarationContext ctx) {

        final String name = ctx.className().getText();
        classDeclaration = new ClassDeclaration(instructionQueue, name);
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
