package com.gsy.utils;

import com.gsy.domain.type.BuiltInType;
import com.gsy.domain.type.ClassType;
import com.gsy.domain.type.Type;
import com.gsy.gian.GianParser;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Optional;

public class TypeResolver {

    public static Type getFromTypeName(GianParser.TypeContext typeContext) {

        if (typeContext == null) {
            return BuiltInType.VOID;
        }
        String typeName = typeContext.getText();
        Optional<? extends Type> buildInType = getBuildInType(typeName);
        if (buildInType.isPresent()) {
            return buildInType.get();
        }
        return new ClassType(typeName);
    }

    public static Type getFromValue(String value) {

        if (StringUtils.isEmpty(value)) {
            return BuiltInType.VOID;
        }
        if (StringUtils.isNumeric(value)) {
            return BuiltInType.INT;
        }
        return BuiltInType.STRING;
    }

    private static Optional<BuiltInType> getBuildInType(String typeName) {

        return Arrays.stream(BuiltInType.values())
                .filter(type -> type.getName().equals(typeName))
                .findFirst();
    }
}
