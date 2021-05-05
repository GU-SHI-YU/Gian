package com.gsy.domain.expression;

import com.gsy.domain.statement.Statement;
import com.gsy.domain.type.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Expression implements Statement {

    private final Type type;
}
