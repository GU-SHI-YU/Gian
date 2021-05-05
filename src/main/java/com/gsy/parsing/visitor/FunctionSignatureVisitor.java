package com.gsy.parsing.visitor;

import com.gsy.domain.expression.FunctionParameter;
import com.gsy.domain.scope.FunctionSignature;
import com.gsy.domain.type.Type;
import com.gsy.gian.GianBaseVisitor;
import com.gsy.gian.GianParser;
import com.gsy.utils.TypeResolver;

import java.util.ArrayList;
import java.util.List;

public class FunctionSignatureVisitor extends GianBaseVisitor<FunctionSignature> {

    @Override
    public FunctionSignature visitFunctionDeclaration(GianParser.FunctionDeclarationContext ctx) {

        String functionName = ctx.functionName().getText();
        List<GianParser.FunctionArgumentContext> argumentContextList = ctx.functionArgument();
        List<FunctionParameter> functionParameters = new ArrayList<>();
        for (GianParser.FunctionArgumentContext argCtx : argumentContextList) {
            String name = argCtx.ID().getText();
            Type type = TypeResolver.getFromTypeName(argCtx.type());
            FunctionParameter functionParameter = new FunctionParameter(name, type);
            functionParameters.add(functionParameter);
        }
        Type returnType = TypeResolver.getFromTypeName(ctx.type());
        return new FunctionSignature(functionName, functionParameters, returnType);
    }
}
