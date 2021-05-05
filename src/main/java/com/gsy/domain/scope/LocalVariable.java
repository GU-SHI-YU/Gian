package com.gsy.domain.scope;

import com.gsy.domain.expression.Expression;
import com.gsy.domain.type.Type;
import lombok.Getter;

@Getter
public class LocalVariable extends Expression {

    private final String name;

    public LocalVariable(String name, Type type) {
        super(type);
        this.name = name;
    }
}
