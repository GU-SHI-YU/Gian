package com.gsy.domain.scope;

import com.gsy.bytecodegeneration.ExpressionGenerator;
import com.gsy.domain.expression.Expression;
import com.gsy.domain.type.Type;
import lombok.Getter;

@Getter
public class LocalVariable {

    private final String name;
    private final Type type;

    public LocalVariable(String name, Type type) {
        this.type = type;
        this.name = name;
    }
}
