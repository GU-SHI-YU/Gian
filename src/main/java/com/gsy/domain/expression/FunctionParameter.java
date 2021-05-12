package com.gsy.domain.expression;

import com.gsy.bytecodegeneration.ExpressionGenerator;
import com.gsy.domain.type.Type;
import lombok.Getter;

@Getter
public class FunctionParameter extends Expression {

    private final String name;

    public FunctionParameter(String name, Type type) {

        super(type);
        this.name = name;
    }

    @Override
    public void accept(ExpressionGenerator generator) {

        generator.generate(this);
    }
}
