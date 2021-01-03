package me.tecc.hypercode.language.lexing;

import me.tecc.hypercode.utils.TextPosition;

import java.util.Objects;

public class Token {
    public Type type = Type.UNKNOWN;
    public String content = "";
    public TextPosition position;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return type == token.type && Objects.equals(content, token.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, content);
    }

    public enum Type {
        UNKNOWN,
        KEYWORD,
        STRING,
        OPERATOR,
        IDENTIFIER,
        NUMBER
    }

    public String toString() {
        return "[" + position + " " + type.name() + ": '" + content + "']";
    }
}
