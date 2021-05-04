package com.gsy.domain;

import com.gsy.gian.GianLexer;
import lombok.AllArgsConstructor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

@AllArgsConstructor
public class VariableDeclaration implements Opcodes, Instruction {

    Variable variable;

    @Override
    public void apply(MethodVisitor methodVisitor) {
        final int type = variable.getType();
        if (type == GianLexer.NUMBER) {
            int val = Integer.parseInt(variable.getValue());
            methodVisitor.visitIntInsn(BIPUSH, val);
            methodVisitor.visitVarInsn(ISTORE, variable.getID());
        } else if (type == GianLexer.STRING) {
            methodVisitor.visitLdcInsn(variable.getValue());
            methodVisitor.visitVarInsn(ASTORE, variable.getID());
        }
    }
}
