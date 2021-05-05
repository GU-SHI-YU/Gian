package com.gsy.domain.scope;

import com.google.common.collect.Lists;
import com.gsy.domain.global.Metadata;
import com.gsy.exception.LocalVariableNotFoundException;
import com.gsy.exception.MethodSignatureNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Scope {

    private final List<LocalVariable> localVariables;
    private final List<FunctionSignature> functionSignatures;
    private final Metadata metadata;

    public Scope(Metadata metadata) {

        this.metadata = metadata;
        localVariables = new ArrayList<>();
        functionSignatures = new ArrayList<>();
    }

    public Scope(Scope scope) {

        this.metadata = scope.metadata;
        this.functionSignatures = Lists.newArrayList(scope.functionSignatures);
        this.localVariables = new ArrayList<>();
    }

    public void addSignature(FunctionSignature signature) {

        functionSignatures.add(signature);
    }

    public FunctionSignature getSignature(String methodName) {

        return functionSignatures.stream()
                .filter(signature -> signature.getName().equals(methodName))
                .findFirst()
                .orElseThrow(() -> new MethodSignatureNotFoundException(this, methodName));
    }

    public void addLocalVariable(LocalVariable variable) {

        localVariables.add(variable);
    }

    public LocalVariable getLocalVariable(String variableName) {

        return localVariables.stream()
                .filter(localVariable -> localVariable.getName().equals(variableName))
                .findFirst()
                .orElseThrow(() -> new LocalVariableNotFoundException(this, variableName));
    }

    public int getLocalVariableIndex(String variableName) {

        LocalVariable localVariable = getLocalVariable(variableName);
        return localVariables.indexOf(localVariable);
    }

    public String getClassName() {

        return metadata.getClassName();
    }
}
