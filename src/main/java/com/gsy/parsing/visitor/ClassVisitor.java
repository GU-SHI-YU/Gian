package com.gsy.parsing.visitor;

import com.gsy.domain.ClassDeclaration;
import com.gsy.gian.GianBaseVisitor;
import com.gsy.gian.GianParser;

public class ClassVisitor extends GianBaseVisitor<ClassDeclaration> {

    @Override
    public ClassDeclaration visitClassDeclaration(GianParser.ClassDeclarationContext ctx) {

        String name = ctx.className().getText();
        return new ClassDeclaration(null, name);
    }
}
