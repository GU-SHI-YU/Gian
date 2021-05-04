package com.gsy.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Queue;

@AllArgsConstructor
@Getter
public class ClassDeclaration {

    private final Queue<Instruction> instructionQueue;
    private final String name;
}
