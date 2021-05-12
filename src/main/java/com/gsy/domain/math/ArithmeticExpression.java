package com.gsy.domain.math;

import com.gsy.bytecodegeneration.ExpressionGenerator;
import com.gsy.domain.expression.Expression;
import com.gsy.domain.type.BuiltInType;
import com.gsy.domain.type.Type;
import com.gsy.exception.UnsupportedArithmeticOperationException;
import lombok.Getter;

@Getter
public abstract class ArithmeticExpression extends Expression {

    private final Expression leftExpression;
    private final Expression rightExpression;

    public ArithmeticExpression(Type type, Expression leftExpression, Expression rightExpression) {

        super(type);
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        if (type != BuiltInType.INT) {
            throw new UnsupportedArithmeticOperationException(this);
        }
    }

}
