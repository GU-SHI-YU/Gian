package com.gsy.bytecodegeneration;

import com.gsy.domain.clazz.Function;
import com.gsy.domain.global.ClassDeclaration;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.util.List;


public class ClassGenerator {

    private static final int CLASS_VERSION = 52;
    private final ClassWriter classWriter;

    public ClassGenerator() {

        classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS + ClassWriter.COMPUTE_FRAMES);
    }

    public ClassWriter generate(ClassDeclaration classDeclaration) {

        String name = classDeclaration.getName();
        classWriter.visit(
                CLASS_VERSION,
                Opcodes.ACC_PUBLIC + Opcodes.ACC_SUPER,
                name,
                null,
                "java/lang/Object",
                null);
        List<Function> methods = classDeclaration.getMethods();
        methods.forEach(function -> new MethodGenerator(classWriter).generate(function));
        classWriter.visitEnd();
        return classWriter;
    }
}
