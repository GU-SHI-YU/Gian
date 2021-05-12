package com.gsy.domain.math;

import com.gsy.bytecodegeneration.ExpressionGenerator;
import com.gsy.domain.expression.Expression;
import com.gsy.domain.type.Type;

public class Division extends ArithmeticExpression {

    public Division(Expression leftExpression, Expression rightExpression) {

        super(leftExpression.getType(), leftExpression, rightExpression);
    }

    @Override
    public void accept(ExpressionGenerator generator) {

        generator.generate(this);
    }
}
