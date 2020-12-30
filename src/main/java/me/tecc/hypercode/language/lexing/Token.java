package me.tecc.hypercode.language.lexing;

public class Token {
    Type type = Type.UNKNOWN;
    String content = "";

    enum Type {
        UNKNOWN,
        KEYWORD,
        STRING,
        OPERATOR
    }
}
