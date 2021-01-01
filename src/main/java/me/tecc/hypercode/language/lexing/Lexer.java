package me.tecc.hypercode.language.lexing;

import java.util.ArrayList;
import java.util.List;
import static me.tecc.hypercode.language.lexing.Token.Type;

/**
 * Breaks down a string of Hypercode into smaller parts (tokens).
 */
public class Lexer {
    public static final String NUMBERS = "0123456789";
    public static final char NUMBER_DECIMAL_SEPARATOR = '.';
    List<Token> tokens;
    List<LexingError> errors;
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
            iterateLexing(c);
        }
        // remember to add recommendation of new line as last line
        if (!code.endsWith("\n")) iterateLexing('\n');
        put();
        return tokens;
    }
    boolean expectIdentifier = false;
    private void iterateLexing(char c) {
        // if in a string, append char to string
        if (current.type == Type.STRING) {
            if (current.content.charAt(0) == c) {
                // this works because the function never directly accesses the current index
                if (!isEscaped(current.content.length())) {
                    // removes the first index
                    current.content = current.content.substring(1);
                    put();
                    return;
                }
            }
            current.content += c;
            return;
        }
        // if begin string
        if (c == '"' || c == '\'') {
            put();
            current.type = Type.STRING;
            current.content += c;

            return;
        }

        if (NUMBERS.contains("" + c)) {
            System.out.println("number");
            put();
            this.current.type = Type.NUMBER;
            this.current.content += c;
            return;
        }

        // explicit check in case decimal separator is operator
        // hint: it is
        if (this.current.type == Type.NUMBER && c == NUMBER_DECIMAL_SEPARATOR) {
            if (this.current.content.contains("" + NUMBER_DECIMAL_SEPARATOR)) {
                error("Multiple decimal separators in a single number.");
            }
            this.current.content += c;
            return;
        }

        // now we get on to operators
        // very simple, it's 2 steps;
        // 1. check if character is in operator alphabet; if so, set the current type to operator
        // 2. when space reached, check which operator it is.
        if (Operator.ALPHABET.contains("" + c)) {
            if (this.current.type != Type.OPERATOR) {
                put();
                this.current.type = Type.OPERATOR;
            }
            this.current.content += c;
            return;
        }

        // the whitespace thing is in var because i don't wanna repeat the condition
        boolean isWhitespace = c == ' ' || c == '\n';

        // operator pt2
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
            return;
        }

        // normal if whitespace
        if (isWhitespace) {
            if (Keyword.isKeyword(this.current.content)) {
                if (expectIdentifier) {
                    error("Expected identifier, got keyword.");
                }
                this.current.type = Type.KEYWORD;
                switch (Keyword.getKeyword(this.current.content)) {
                    case ON:
                    case VAR:
                    case FUNCTION:
                    case MACRO:
                        expectIdentifier = true;
                }
            } else if (expectIdentifier) {
                this.current.type = Type.IDENTIFIER;
                expectIdentifier = false;
            }
            put();
            return;
        }
        this.current.content += c;
    }

    public List<LexingError> errors() {
        return errors;
    }

    private void error(String message) {
        this.errors.add(new LexingError(this.current, message));
    }

    private boolean isEscaped(int index) {
        if (index <= 0) return false;
        if (index - 1 == 0) return current.content.charAt(0) == '\\';

        char c = current.content.charAt(index - 1);
        if (c == '\\') return !isEscaped(index - 1);
        else return false;
    }

    private void put() {
        if (current == null) {
            current = new Token();
        }
        if (current.equals(new Token())) {
            return;
        }
        tokens.add(current);
        current = new Token();
    }
}
