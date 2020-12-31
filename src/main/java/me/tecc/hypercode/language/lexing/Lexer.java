package me.tecc.hypercode.language.lexing;

import java.util.ArrayList;
import java.util.List;
import static me.tecc.hypercode.language.lexing.Token.Type;

/**
 * Breaks down a string of Hypercode into smaller parts (tokens).
 */
public class Lexer {
    List<Token> tokens;
    List<TokenError> errors;
    Token current;

    public void init() {
        tokens = new ArrayList<>();
        errors = new ArrayList<>();
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
                        // removes the first index
                        current.content = current.content.substring(1);
                        put();
                        continue;
                    }
                }
                current.content += c;
                continue;
            }
            // if begin string
            if (c == '"' || c == '\'') {
                put();
                current.type = Type.STRING;
                current.content += c;

                continue;
            }
            // now we get on to operators
            // very simple, it's 2 steps;
            // 1. check if character is in operator alphabet; if so, set the current type to operator
            // 2. when space reached, check which operator it is.
            if (Operator.ALPHABET.contains("" + c)) {
                this.current.type = Type.OPERATOR;
                continue;
            }
            // checks if in operator
            // the whitespace thing is in var because i don't wanna repeat the condition
            boolean isWhitespace = c == ' ' || c == '\n';
            if (this.current.type == Type.OPERATOR && !Operator.ALPHABET.contains("" + c)) {
                // report error if invalid operator
                if (!Operator.isOperator(this.current.content)) {
                    error("Invalid operator " + this.current.content);
                }
                put();
                // append new character to current token if character isn't whitespace
                if (!isWhitespace) {
                    this.current.content += c;
                }
                continue;
            }

            // normal if whitespace
            if (isWhitespace) {
                if (isKeyword(current.content)) {
                    this.current.type = Type.KEYWORD;
                }
                put();
            }
        }
        put();
        return tokens;
    }

    private void error(String message) {
        this.errors.add(new TokenError(this.current, message));
    }

    private boolean isKeyword(String s) {
        for (Keyword keyword : Keyword.values()) {
            if (keyword.is(s))
                return true;
        }

        return false;
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
