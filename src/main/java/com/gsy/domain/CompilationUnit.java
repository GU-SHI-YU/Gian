package com.gsy.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import org.springframework.asm.Opcodes;

import java.util.Queue;

@AllArgsConstructor
public class CompilationUnit {

    @Getter
    private final ClassDeclaration classDeclaration;

    public String getClassName() {
        return classDeclaration.getName();
    }

    public byte[] getByteCode() {
        ClassWriter classWriter = new ClassWriter(0);
        MethodVisitor methodVisitor;
        classWriter.visit(52, Opcodes.ACC_PUBLIC + Opcodes.ACC_SUPER, getClassName(), null, "java/lang/Object", null);

        methodVisitor = classWriter
                .visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "main",  "([Ljava/lang/String;)V", null, null);
        Queue<Instruction> instructionQueue = classDeclaration.getInstructionQueue();
        final long localVariableCount = instructionQueue.stream()
                .filter(instruction -> instruction instanceof VariableDeclaration)
                .count();
        final int maxStack = 100; // TODO: do that properly

        for (Instruction instruction : instructionQueue) {
            instruction.apply(methodVisitor);
        }
        methodVisitor.visitInsn(Opcodes.RETURN);

        methodVisitor.visitMaxs(maxStack, (int)localVariableCount);
        methodVisitor.visitEnd();
        classWriter.visitEnd();

        return classWriter.toByteArray();
    }
}
