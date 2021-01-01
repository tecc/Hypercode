package me.tecc.hypercode.language.parsing;

public class ParsingError {
    ASTNode node;
    String message;

    ParsingError(ASTNode node, String message) {
        this.node = node;
        this.message = message;
    }
}
