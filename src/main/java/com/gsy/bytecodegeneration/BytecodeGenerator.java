package com.gsy.bytecodegeneration;

import com.gsy.domain.ClassDeclaration;
import com.gsy.domain.CompilationUnit;
import com.gsy.domain.Instruction;
import com.gsy.domain.VariableDeclaration;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import java.util.Queue;

public class BytecodeGenerator{

    public byte[] generate(CompilationUnit compilationUnit) throws Exception {

        ClassDeclaration classDeclaration = compilationUnit.getClassDeclaration();
        ClassGenerator classGenerator = new ClassGenerator();
        return classGenerator.generate(classDeclaration).toByteArray();
    }
}
