package com.gsy.parsing.visitor;

import com.gsy.exception.NoVisitorReturnedValueException;
import com.gsy.gian.GianBaseVisitor;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.Arrays;
import java.util.Objects;

public class CompositeVisitor<T> {

    private final GianBaseVisitor<? extends T>[] visitors;

    @SafeVarargs
    public CompositeVisitor(GianBaseVisitor<? extends T>... visitors) {

        this.visitors = visitors;
    }

    public T accept(ParserRuleContext context) {

        return Arrays.stream(visitors)
                .map(context::accept)
                .filter(Objects::nonNull)
                .findFirst()
                .orElseThrow(NoVisitorReturnedValueException::new);
    }
}
