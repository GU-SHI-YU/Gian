package com.gsy.domain.expression;

import com.gsy.bytecodegeneration.ExpressionGenerator;
import com.gsy.domain.type.Type;
import lombok.Getter;

@Getter
public class VarReference extends Expression {
    private final String varName;

    public VarReference(String varName, Type type) {
        super(type);
        this.varName = varName;
    }

    @Override
    public void accept(ExpressionGenerator generator) {

        generator.generate(this);
    }
}
