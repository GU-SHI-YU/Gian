package com.gsy.compiler;

import com.gsy.domain.CompilationUnit;
import com.gsy.parsing.Parser;
import com.gsy.validation.ARGUMENT_ERRORS;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Compiler {

    public static void main(String[] args) throws Exception {

        new Compiler().compile(args);
    }

    public void compile(String[] args) throws Exception {

        final ARGUMENT_ERRORS argumentsErrors = getArgumentValidationErrors(args);
        if (argumentsErrors != ARGUMENT_ERRORS.NONE) {
            System.out.println(argumentsErrors.getMessage());
            return;
        }
        final File gianFile = new File(args[0]);
        String fileAbsolutePath = gianFile.getAbsolutePath();
        CompilationUnit compilationUnit = new Parser().getCompilationUnit(fileAbsolutePath);
        saveBytecodeToClassFile(compilationUnit);
    }

    private static void saveBytecodeToClassFile(CompilationUnit compilationUnit) throws Exception {

        final byte[] bytecode = compilationUnit.getByteCode();
        String className = compilationUnit.getClassName();
        OutputStream outputStream = new FileOutputStream(className + ".class");
        IOUtils.write(bytecode, outputStream);
    }

    private ARGUMENT_ERRORS getArgumentValidationErrors(String[] args) {
        if (args.length != 1) {
            return ARGUMENT_ERRORS.NO_FILE;
        }
        String filePath = args[0];
        if (!filePath.endsWith(".gian")) {
            return ARGUMENT_ERRORS.BAD_FILE_EXTENSION;
        }
        return ARGUMENT_ERRORS.NONE;
    }
}
