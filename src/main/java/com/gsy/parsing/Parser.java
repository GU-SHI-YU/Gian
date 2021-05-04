package com.gsy.parsing;

import com.gsy.domain.CompilationUnit;
import com.gsy.domain.Instruction;
import com.gsy.gian.GianLexer;
import com.gsy.gian.GianParser;
import com.gsy.parsing.visitor.CompilationUnitVisitor;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.util.Queue;

public class Parser {

    public CompilationUnit getCompilationUnit(String fileAbsolutePath) throws IOException {

        CharStream charStream = CharStreams.fromFileName(fileAbsolutePath);
        GianLexer lexer = new GianLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        GianParser parser = new GianParser(tokenStream);

        BaseErrorListener errorListener = new GianTreeWalkErrorListener();
        GianTreeWalkListener treeWalkListener = new GianTreeWalkListener();
        parser.addErrorListener(errorListener);
        parser.addParseListener(treeWalkListener);

        parser.compilationUnit();
        //CompilationUnitVisitor compilationUnitVisitor = new CompilationUnitVisitor();
        return treeWalkListener.getCompilationUnit();
    }
}
