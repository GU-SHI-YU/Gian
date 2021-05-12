package com.gsy.bytecodegeneration;

import com.gsy.domain.expression.*;
import com.gsy.domain.math.*;
import com.gsy.domain.scope.LocalVariable;
import com.gsy.domain.scope.Scope;
import com.gsy.domain.type.BuiltInType;
import com.gsy.domain.type.ClassType;
import com.gsy.domain.type.Type;
import com.gsy.exception.CalledFunctionDoesNotExistException;
import com.gsy.utils.DescriptorFactory;
import lombok.AllArgsConstructor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
public class ExpressionGenerator {

    private final MethodVisitor methodVisitor;
    private final Scope scope;

    public void generate(VarReference varReference) {

        String varName = varReference.getVarName();
        int index = scope.getLocalVariableIndex(varName);
        LocalVariable localVariable = scope.getLocalVariable(varName);
        Type type = localVariable.getType();
        if (type == BuiltInType.INT) {
            methodVisitor.visitVarInsn(Opcodes.ILOAD, index);
        } else if (type == BuiltInType.STRING) {
            methodVisitor.visitVarInsn(Opcodes.ALOAD, index);
        }
    }

    public void generate(FunctionParameter parameter) {

        Type type = parameter.getType();
        int index = scope.getLocalVariableIndex(parameter.getName());
        if (type == BuiltInType.INT) {
            methodVisitor.visitVarInsn(Opcodes.ILOAD, index);
        } else if (type == BuiltInType.STRING) {
            methodVisitor.visitVarInsn(Opcodes.ALOAD, index);
        }
    }


    public void generate(Value value) {

        Type type = value.getType();
        String stringValue = value.getValue();
        if (type == BuiltInType.INT) {
            int intValue = Integer.parseInt(stringValue);
            methodVisitor.visitIntInsn(Opcodes.BIPUSH, intValue);
        } else if (type == BuiltInType.STRING) {
            methodVisitor.visitLdcInsn(stringValue);
        }
    }

    public void generate(FunctionCall functionCall) {

        Collection<Expression> parameters = functionCall.getParameters();
        parameters.forEach(parameter -> parameter.accept(this));
        Type owner = functionCall.getOwner().orElse(new ClassType(scope.getClassName()));
        String methodDescriptor = getFunctionDescriptor(functionCall, scope);
        String ownerDescriptor = owner.getInternalName();
        String functionName = functionCall.getName();
        methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, ownerDescriptor, functionName, methodDescriptor, false);
    }

    public void generate(Addition addition) {

        evaluateArithmeticComponents(addition);
        methodVisitor.visitInsn(Opcodes.IADD);
    }

    public void generate(Subtraction subtraction) {

        evaluateArithmeticComponents(subtraction);
        methodVisitor.visitInsn(Opcodes.ISUB);
    }

    public void generate(Multiplication multiplication) {

        evaluateArithmeticComponents(multiplication);
        methodVisitor.visitInsn(Opcodes.IMUL);
    }

    public void generate(Division division) {

        evaluateArithmeticComponents(division);
        methodVisitor.visitInsn(Opcodes.IDIV);
    }

    private void evaluateArithmeticComponents(ArithmeticExpression arithmeticExpression) {

        Expression leftExpression = arithmeticExpression.getLeftExpression();
        Expression rightExpression = arithmeticExpression.getRightExpression();
        leftExpression.accept(this);
        rightExpression.accept(this);
    }

    public String getFunctionDescriptor(FunctionCall functionCall, Scope scope) {

        return Optional.of(getDescriptorForFunctionInScope(functionCall, scope))
                .orElse(getDescriptorForFunctionOnClasspath(functionCall, scope))
                .orElseThrow(() -> new CalledFunctionDoesNotExistException(functionCall, scope));
    }

    private Optional<String> getDescriptorForFunctionInScope(FunctionCall functionCall, Scope scope) {

        return Optional.of(DescriptorFactory.getMethodDescriptor(functionCall.getSignature()));//TODO check errors here (not found function tec)
    }

    private Optional<String> getDescriptorForFunctionOnClasspath(FunctionCall functionCall, Scope scope) {

        try {
            String functionName = functionCall.getName();
            Collection<Expression> parameters = functionCall.getParameters();
            Optional<Type> owner = functionCall.getOwner();
            String className = owner.isPresent() ? owner.get().getName() : scope.getClassName();
            Class<?> aClass = Class.forName(className);
            Method method = aClass.getMethod(functionName);
            String methodDescriptor = org.objectweb.asm.Type.getMethodDescriptor(method);
            return Optional.of(methodDescriptor);
        } catch (ReflectiveOperationException e) {
            return Optional.empty();
        }
    }
}
