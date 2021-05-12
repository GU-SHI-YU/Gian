package com.gsy.domain.math;

import com.gsy.bytecodegeneration.ExpressionGenerator;
import com.gsy.domain.expression.Expression;

public class Multiplication extends ArithmeticExpression {

    public Multiplication(Expression leftExpression, Expression rightExpression) {

        super(leftExpression.getType(), leftExpression, rightExpression);
    }

    @Override
    public void accept(ExpressionGenerator generator) {

        generator.generate(this);
    }
}
