package com.gsy.domain.statement;

import com.gsy.bytecodegeneration.StatementGenerator;

public interface Statement extends Node {

    void accept(StatementGenerator generator);
}
