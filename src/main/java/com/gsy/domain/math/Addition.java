package com.gsy.domain.math;

import com.gsy.bytecodegeneration.ExpressionGenerator;
import com.gsy.domain.expression.Expression;

public class Addition extends ArithmeticExpression {

    public Addition(Expression leftExpression, Expression rightExpression) {

        super(leftExpression.getType(), leftExpression, rightExpression);
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }
}
