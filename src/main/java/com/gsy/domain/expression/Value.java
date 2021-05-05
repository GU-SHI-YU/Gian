package com.gsy.domain.expression;

import com.gsy.domain.type.Type;
import lombok.Getter;

@Getter
public class Value extends Expression {

    private final String value;

    public Value(String value, Type type) {

        super(type);
        this.value = value;
    }
}
