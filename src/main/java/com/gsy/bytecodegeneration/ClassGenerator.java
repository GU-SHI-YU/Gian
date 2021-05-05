package com.gsy.bytecodegeneration;

import com.gsy.domain.ClassDeclaration;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;


public class ClassGenerator {

    private static final int CLASS_VERSION = 52;
    private final ClassWriter classWriter;

    public ClassGenerator() {
        classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS + ClassWriter.COMPUTE_FRAMES);
    }

    public ClassWriter generate(ClassDeclaration classDeclaration) {

        String name = classDeclaration.getName();
        classWriter.visit(CLASS_VERSION, Opcodes.ACC_PUBLIC + Opcodes.ACC_SUPER, name,
                null,"java/lang/Object",null);
        classWriter.visitEnd();
        return classWriter;
    }
}
