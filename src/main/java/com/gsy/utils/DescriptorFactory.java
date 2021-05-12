package com.gsy.utils;

import com.gsy.domain.clazz.Function;
import com.gsy.domain.expression.FunctionParameter;
import com.gsy.domain.scope.FunctionSignature;
import com.gsy.domain.type.Type;

import java.util.Collection;
import java.util.stream.Collectors;

public class DescriptorFactory {

    public static String getMethodDescriptor(Function function) {

        Collection<FunctionParameter> arguments = function.getArguments();
        Type returnType = function.getReturnType();
        return getMethodDescriptor(arguments, returnType);
    }

    public static String getMethodDescriptor(FunctionSignature signature) {

        Collection<FunctionParameter> arguments = signature.getArguments();
        Type returnType = signature.getReturnType();
        return getMethodDescriptor(arguments, returnType);
    }

    private static String getMethodDescriptor(Collection<FunctionParameter> arguments, Type returnType) {

        String argumentDescriptor = arguments.stream()
                .map(argument -> argument.getType().getDescriptor())
                .collect(Collectors.joining("", "(", ")"));
        String returnDescriptor = returnType.getDescriptor();
        return argumentDescriptor + returnDescriptor;
    }
}
