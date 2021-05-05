package com.gsy.exception;

import com.gsy.domain.scope.Scope;

public class MethodSignatureNotFoundException extends RuntimeException {

    public MethodSignatureNotFoundException(Scope scope, String methodName) {

        super("There is no method" + methodName);
    }
}
