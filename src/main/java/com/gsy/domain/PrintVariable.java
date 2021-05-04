package com.gsy.domain;

import com.gsy.gian.GianLexer;
import lombok.AllArgsConstructor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

@AllArgsConstructor
public class PrintVariable implements Instruction, Opcodes {

    Variable variable;

    @Override
    public void apply(MethodVisitor methodVisitor) {

        final int type = variable.getType();
        final int id = variable.getID();
        methodVisitor.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        if (type == GianLexer.NUMBER) {
            methodVisitor.visitVarInsn(ILOAD, id);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
        } else if (type == GianLexer.STRING) {
            methodVisitor.visitVarInsn(ALOAD, id);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println",
                    "(Ljava/lang/String;)V", false);
        }
    }
}
