package com.gsy.domain.statement;

import com.gsy.domain.expression.Expression;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class VariableDeclarationStatement implements Statement {

    private final String name;
    private final Expression expression;
}
