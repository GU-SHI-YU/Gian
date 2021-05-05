package com.gsy.bytecodegeneration;

import com.gsy.domain.clazz.Function;
import com.gsy.domain.scope.Scope;
import com.gsy.domain.statement.Statement;
import com.gsy.utils.DescriptorFactory;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import lombok.AllArgsConstructor;

import java.util.Collection;

@AllArgsConstructor
public class MethodGenerator {

    private final ClassWriter classWriter;

    public void generate(Function function) {

        Scope scope = function.getScope();
        String name = function.getName();
        String descriptor = DescriptorFactory.getMethodDescriptor(function);
        Collection<Statement> instructions = function.getStatements();
        int access = Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC;
        MethodVisitor methodVisitor = classWriter.visitMethod(access, name, descriptor, null, null);
        methodVisitor.visitCode();
        StatementGenerator statementGenerator = new StatementGenerator(methodVisitor);
        instructions.forEach(instruction -> statementGenerator.generate(instruction, scope));
        methodVisitor.visitInsn(Opcodes.RETURN);
        methodVisitor.visitMaxs(-1, -1);
        methodVisitor.visitEnd();
    }
}
