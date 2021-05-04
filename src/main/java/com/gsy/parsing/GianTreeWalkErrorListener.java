package com.gsy.parsing;

import com.gsy.gian.GianBaseListener;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class GianTreeWalkErrorListener extends BaseErrorListener {

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {

        final String errorFormat = "Syntax error at line %d,char %d :(. Details:\n%s";
        final String errorMsg = String.format(errorFormat, line, charPositionInLine, msg);
        System.err.println(errorMsg);
    }
}
