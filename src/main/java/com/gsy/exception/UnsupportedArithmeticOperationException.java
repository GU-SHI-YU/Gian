package com.gsy.exception;

import com.gsy.domain.expression.Expression;
import com.gsy.domain.math.ArithmeticExpression;

public class UnsupportedArithmeticOperationException extends RuntimeException {

    public UnsupportedArithmeticOperationException(ArithmeticExpression arithmeticExpression) {

        super(prepareMessage(arithmeticExpression));
    }

    private static String prepareMessage(ArithmeticExpression arithmeticExpression) {

        Expression leftExpression = arithmeticExpression.getLeftExpression();
        Expression rightExpression = arithmeticExpression.getRightExpression();
        return "Unsupported arithmetic operation between " + leftExpression + "and" + rightExpression;
    }
}
