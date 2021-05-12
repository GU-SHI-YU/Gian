package com.gsy.domain.clazz;

import com.gsy.bytecodegeneration.ExpressionGenerator;
import com.gsy.domain.expression.Expression;
import com.gsy.domain.expression.FunctionParameter;
import com.gsy.domain.scope.Scope;
import com.gsy.domain.statement.Statement;
import com.gsy.domain.type.Type;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public class Function {

    private final String name;
    private final List<FunctionParameter> arguments;
    private final List<Statement> statements;
    private final Scope scope;
    private final Type returnType;

    public Function(Scope scope, String name, Type returnType,
                    List<FunctionParameter> arguments, List<Statement> statements) {

        this.returnType = returnType;
        this.scope = scope;
        this.name = name;
        this.arguments = arguments;
        this.statements = statements;
    }

    public List<FunctionParameter> getArguments() {

        return Collections.unmodifiableList(arguments);
    }

    public List<Statement> getStatements() {

        return Collections.unmodifiableList(statements);
    }
}
