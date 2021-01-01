package me.tecc.hypercode.language.parsing;

import me.tecc.hypercode.language.lexing.Token;

import java.util.List;

public class ASTNode {
    List<Token> tokens;
    public enum Type {
        FUNCTION
    }
}
