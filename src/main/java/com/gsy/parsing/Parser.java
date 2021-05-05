package com.gsy.parsing;

import com.gsy.domain.global.CompilationUnit;
import com.gsy.gian.GianLexer;
import com.gsy.gian.GianParser;
import com.gsy.parsing.visitor.CompilationUnitVisitor;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

public class Parser {

    public CompilationUnit getCompilationUnit(String fileAbsolutePath) throws IOException {

        CharStream charStream = CharStreams.fromFileName(fileAbsolutePath);
        GianLexer lexer = new GianLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        GianParser parser = new GianParser(tokenStream);

        BaseErrorListener errorListener = new GianTreeWalkErrorListener();
        parser.addErrorListener(errorListener);

        CompilationUnitVisitor compilationUnitVisitor = new CompilationUnitVisitor();
        return parser.compilationUnit().accept(compilationUnitVisitor);
    }
}
