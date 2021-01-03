package me.tecc.hypercode.language.parsing;

import me.tecc.hypercode.language.lexing.Token;

import java.util.List;

public class Parser {
    List<ASTNode> nodes;
    ASTNode current;
    List<ParsingError> errors;

    public AbstractSyntaxTree parse(List<Token> tokens) {
        // expectations
        // for error catching, prediction and in general faster compilation
        boolean expectParameterList = false;
        boolean expectDeclaration = false;

        for (Token token : tokens) {

        }

        return null;
    }


    private void error(String message) {
        errors.add(new ParsingError(this.current, message));
    }
}
