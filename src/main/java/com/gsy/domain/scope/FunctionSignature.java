package com.gsy.domain.scope;

import com.gsy.domain.expression.FunctionParameter;
import com.gsy.domain.type.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class FunctionSignature {

    private final String name;
    private final List<FunctionParameter> arguments;
    private final Type returnType;
}
