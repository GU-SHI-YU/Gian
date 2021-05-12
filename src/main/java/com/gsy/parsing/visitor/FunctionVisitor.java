package com.gsy.parsing.visitor;

import com.gsy.domain.clazz.Function;
import com.gsy.domain.expression.FunctionParameter;
import com.gsy.domain.scope.LocalVariable;
import com.gsy.domain.scope.Scope;
import com.gsy.domain.statement.Statement;
import com.gsy.domain.type.Type;
import com.gsy.gian.GianBaseVisitor;
import com.gsy.gian.GianParser;
import com.gsy.utils.TypeResolver;

import java.util.List;
import java.util.stream.Collectors;

public class FunctionVisitor extends GianBaseVisitor<Function> {

    private final Scope scope;

    public FunctionVisitor(Scope scope) {

        this.scope = new Scope(scope);
    }

    @Override
    public Function visitFunction(GianParser.FunctionContext ctx) {

        String name = ctx.functionDeclaration().functionName().getText();
        Type returnType = TypeResolver.getFromTypeName(ctx.functionDeclaration().type());
        List<FunctionParameter> arguments = ctx.functionDeclaration().functionArgument().stream()
                .map(paramCtx ->
                        new FunctionParameter(paramCtx.ID().getText(), TypeResolver.getFromTypeName(paramCtx.type())))
                .peek(param -> scope.addLocalVariable(new LocalVariable(param.getName(), param.getType())))
                .collect(Collectors.toList());
        StatementVisitor statementVisitor = new StatementVisitor(scope);
        List<Statement> instructions = ctx.blockStatement().stream()
                .map(block -> block.accept(statementVisitor))
                .collect(Collectors.toList());
        return new Function(scope, name, returnType, arguments, instructions);
    }
}
