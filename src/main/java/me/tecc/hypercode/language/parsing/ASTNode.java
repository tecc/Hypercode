package me.tecc.hypercode.language.parsing;

import me.tecc.hypercode.language.lexing.Token;

import java.util.List;

public class ASTNode {
    ASTNode parent;
    List<Token> tokens;
    ASTNode[] children;
    public enum Type {
        FUNCTION_DECLARATION
    }
}
