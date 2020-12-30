package me.tecc.hypercode.language.lexing;

import java.util.ArrayList;
import java.util.List;
import static me.tecc.hypercode.language.lexing.Token.Type;

/**
 * Breaks down a string of Hypercode into smaller parts (tokens).
 */
public class Lexer {
    List<Token> tokens;
    Token current;

    public void init() {
        tokens = new ArrayList<>();
        current = new Token();
    }

    /**
     * Lex a string and break it down into tokens.
     *
     * @param code the string to lex
     */
    public List<Token> lex(String code) {
        for (char c : code.toCharArray()) {
            // if in a string, append char to string
            if (current.type == Type.STRING) {
                if (current.content.charAt(0) == c) {
                    // this works because the function never directly accesses the current index
                    if (!isEscaped(current.content.length())) {
                        current.content = current.content.substring(1);
                        put();
                        continue;
                    }
                }
                current.content += c;
                continue;
            }
            if (c == '"' || c == '\'') {
                put();
                current.type = Type.STRING;
                current.content += c;

                continue;
            }
            if (c == ' ') {
                if (isKeyword(current.content)) {
                    this.current.type = Type.KEYWORD;
                }
                put();
            }

        }
        put();
        return tokens;
    }

    private boolean isKeyword(String s) {
        switch (s) {
            case "on":
            case "var":
            case "true":
            case "false":
                return true;
            default:
                return false;
        }
    }

    private boolean isEscaped(int index) {
        if (index <= 0) return false;
        if (index - 1 == 0) return current.content.charAt(0) == '\\';

        char c = current.content.charAt(index - 1);
        if (c == '\\') return !isEscaped(index - 1);
        else return false;
    }

    private void put() {
        if (current == null) current = new Token();
        if (current.equals(new Token())) return;
        tokens.add(current);
        current = new Token();
    }
}
