package com.gsy.domain.global;

import com.gsy.domain.clazz.Function;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@Getter
public class ClassDeclaration {

    private final String name;
    private final Collection<Function> methods;

    public List<Function> getMethods() {

        return new ArrayList<>(methods);
    }
}
