package com.gsy.domain;

import org.objectweb.asm.MethodVisitor;

public interface Instruction {
    void apply(MethodVisitor methodVisitor);
}
