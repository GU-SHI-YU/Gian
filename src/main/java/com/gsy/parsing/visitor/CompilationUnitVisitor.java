package com.gsy.parsing.visitor;

import com.gsy.domain.global.ClassDeclaration;
import com.gsy.domain.global.CompilationUnit;
import com.gsy.gian.GianBaseVisitor;
import com.gsy.gian.GianParser;

public class CompilationUnitVisitor extends GianBaseVisitor<CompilationUnit> {

    @Override
    public CompilationUnit visitCompilationUnit(GianParser.CompilationUnitContext ctx) {

        ClassVisitor classVisitor = new ClassVisitor();
        GianParser.ClassDeclarationContext classDeclarationContext = ctx.classDeclaration();
        ClassDeclaration classDeclaration = classDeclarationContext.accept(classVisitor);
        return new CompilationUnit(classDeclaration);
    }
}
