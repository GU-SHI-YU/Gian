package com.gsy.domain.statement;

import com.gsy.domain.expression.Expression;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PrintStatement implements Statement {

    private final Expression expression;
}
