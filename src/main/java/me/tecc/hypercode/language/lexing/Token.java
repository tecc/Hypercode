package me.tecc.hypercode.language.lexing;

public class Token {
    public Type type = Type.UNKNOWN;
    public String content = "";

    public enum Type {
        UNKNOWN,
        KEYWORD,
        STRING,
        OPERATOR
    }
}
