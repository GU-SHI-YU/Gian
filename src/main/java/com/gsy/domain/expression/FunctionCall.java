package com.gsy.domain.expression;

import com.gsy.bytecodegeneration.ExpressionGenerator;
import com.gsy.bytecodegeneration.StatementGenerator;
import com.gsy.domain.scope.FunctionSignature;
import com.gsy.domain.statement.Statement;
import com.gsy.domain.type.Type;
import lombok.Getter;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Getter
public class FunctionCall extends Expression implements Statement {

    private final Type owner;
    private final FunctionSignature signature;
    private final Collection<Expression> parameters;

    public FunctionCall(FunctionSignature signature, Collection<Expression> parameters, Type owner) {

        super(signature.getReturnType());
        this.signature = signature;
        this.parameters = parameters;
        this.owner = owner;
    }

    public Optional<Type> getOwner() {

        return Optional.ofNullable(owner);
    }

    public Collection<Expression> getParameters() {
        return Collections.unmodifiableCollection(parameters);
    }

    public String getName() {

        return signature.getName();
    }

    @Override
    public void accept(ExpressionGenerator generator) {

        generator.generate(this);
    }

    @Override
    public void accept(StatementGenerator generator) {

        generator.generate(this);
    }
}
