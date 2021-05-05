package com.gsy.parsing.visitor;

import com.gsy.domain.clazz.Function;
import com.gsy.domain.global.ClassDeclaration;
import com.gsy.domain.global.Metadata;
import com.gsy.domain.scope.FunctionSignature;
import com.gsy.domain.scope.Scope;
import com.gsy.gian.GianBaseVisitor;
import com.gsy.gian.GianParser;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

public class ClassVisitor extends GianBaseVisitor<ClassDeclaration> {
    private Scope scope;

    @Override
    public ClassDeclaration visitClassDeclaration(GianParser.ClassDeclarationContext ctx) {

        String name = ctx.className().getText();
        FunctionSignatureVisitor functionSignatureVisitor = new FunctionSignatureVisitor();
        List<GianParser.FunctionContext> methodCtx = ctx.classBody().function();
        Metadata metadata = new Metadata(ctx.className().getText());
        scope = new Scope(metadata);
        List<FunctionSignature> signatures = methodCtx.stream()
                .map(method -> method.functionDeclaration().accept(functionSignatureVisitor))
                .peek(scope::addSignature)
                .collect(Collectors.toList());
        List<Function> methods = methodCtx.stream()
                .map(method -> method.accept(new FunctionVisitor(scope)))
                .collect(Collectors.toList());
        return new ClassDeclaration(name, methods);
    }
}
