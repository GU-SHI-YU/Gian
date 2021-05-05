package com.gsy.parsing.visitor;

import com.gsy.domain.expression.*;
import com.gsy.domain.scope.FunctionSignature;
import com.gsy.domain.scope.LocalVariable;
import com.gsy.domain.scope.Scope;
import com.gsy.domain.type.Type;
import com.gsy.gian.GianBaseVisitor;
import com.gsy.gian.GianParser;
import com.gsy.utils.TypeResolver;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ExpressionVisitor extends GianBaseVisitor<Expression> {

    private final Scope scope;

    @Override
    public Expression visitVarReference(GianParser.VarReferenceContext ctx) {

        String name = ctx.getText();
        LocalVariable localVariable = scope.getLocalVariable(name);
        return new VarReference(name, localVariable.getType());
    }

    @Override
    public Expression visitValue(GianParser.ValueContext ctx) {

        String value = ctx.getText();
        Type type = TypeResolver.getFromValue(value);
        return new Value(value, type);
    }

    @Override
    public Expression visitFunctionCall(GianParser.FunctionCallContext ctx) {

        String name = ctx.functionName().getText();
        FunctionSignature signature = scope.getSignature(name);
        List<GianParser.ExpressionContext> calledParams = ctx.expressionList().expression();
        List<Expression> arguments = calledParams.stream()
                .map(expressionContext -> expressionContext.accept(new ExpressionVisitor(scope)))
                .collect(Collectors.toList());
        return new FunctionCall(signature, arguments, null);
    }
}
