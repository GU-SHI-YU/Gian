package com.gsy.bytecodegeneration;

import com.gsy.domain.ClassDeclaration;
import com.gsy.domain.CompilationUnit;

public class BytecodeGenerator{

    public byte[] generate(CompilationUnit compilationUnit) throws Exception {

        ClassDeclaration classDeclaration = compilationUnit.getClassDeclaration();
        ClassGenerator classGenerator = new ClassGenerator();
        return classGenerator.generate(classDeclaration).toByteArray();
    }
}
