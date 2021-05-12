package com.gsy.domain.expression;

import com.gsy.bytecodegeneration.ExpressionGenerator;
import com.gsy.domain.statement.Statement;
import com.gsy.domain.type.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Expression {

    private final Type type;
    public abstract void accept(ExpressionGenerator generator);
}
