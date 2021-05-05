package com.gsy.domain.global;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class CompilationUnit {

    @Getter
    private final ClassDeclaration classDeclaration;

    public String getClassName() {

        return classDeclaration.getName();
    }
}
