package com.gsy.domain.expression;

import com.gsy.domain.scope.FunctionSignature;
import com.gsy.domain.type.Type;
import lombok.Getter;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Getter
public class FunctionCall extends Expression {

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
}
