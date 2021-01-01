package me.tecc.hypercode.language.lexing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        char prev = ' ';
        for (char curr : code.toCharArray()) {
            iterateLexing(prev, curr);
            prev = curr;
        }
        // remember to add recommendation of new line as last line
        if (!code.endsWith("\n")) iterateLexing(prev, '\n');
        put();
        tokens = tokens.stream()
                .map(token -> {
                    if (token.type == Type.UNKNOWN)
                        token.type = Type.IDENTIFIER;
                    return token;
                }).collect(Collectors.toList());
        return tokens;
    }

    boolean expectIdentifier = false;

    private void iterateLexing(char prevChar, char currChar) {
        // the whitespace thing is in var because i don't wanna repeat the condition
        boolean isWhitespace = currChar == ' ' || currChar == '\n';
        // if in a string, append char to string
        if (current.type == Type.STRING) {
            if (current.content.charAt(0) == currChar) {
                // this works because the function never directly accesses the current index
                if (!isEscaped(current.content.length())) {
                    // removes the first index
                    current.content = current.content.substring(1);
                    put();
                    return;
                }
            }
            current.content += currChar;
            return;
        }
        // if begin string
        if (currChar == '"' || currChar == '\'') {
            put();
            current.type = Type.STRING;
            current.content += currChar;

            return;
        }

        number_check:
        if (NUMBERS.contains("" + currChar)) {
            if (!isWhitespace && !(NUMBERS + NUMBER_DECIMAL_SEPARATOR).contains("" + prevChar)) {
                if (!Operator.ALPHABET.contains("" + prevChar))
                    break number_check;
            }
            if (this.current.type != Type.NUMBER) {
                put();
                this.current.type = Type.NUMBER;
            }
            this.current.content += currChar;
            return;
        }

        // explicit check in case decimal separator is operator
        // hint: it is
        if (this.current.type == Type.NUMBER && currChar == NUMBER_DECIMAL_SEPARATOR) {
            if (this.current.content.contains("" + NUMBER_DECIMAL_SEPARATOR)) {
                error("Multiple decimal separators in a single number.");
            }
            this.current.content += currChar;
            return;
        }

        // now we get on to operators
        // very simple, it's 2 steps;
        // 1. check if character is in operator alphabet; if so, set the current type to operator
        // 2. when space reached, check which operator it is.
        if (Operator.ALPHABET.contains("" + currChar)) {
            if (this.current.type != Type.OPERATOR) {
                put();
                this.current.type = Type.OPERATOR;
            }
            this.current.content += currChar;
            return;
        }

        // operator pt2
        if (this.current.type == Type.OPERATOR && !Operator.ALPHABET.contains("" + currChar)) {
            // report error if invalid operator
            if (!Operator.isOperator(this.current.content)) {
                error("Invalid operator " + this.current.content);
            }
            put();
            // append new character to current token if character isn't whitespace
            if (!isWhitespace) {
                this.current.content += currChar;
            }
            return;
        }

        // normal if whitespace
        if (isWhitespace) {
            if (current.type == Type.NUMBER) {
                put();
                return;
            }
            if (Keyword.isKeyword(this.current.content)) {
                if (expectIdentifier) {
                    error("Expected identifier, got keyword.");
                }
                this.current.type = Type.KEYWORD;
                //noinspection ConstantConditions
                switch (Keyword.getKeyword(this.current.content)) {
                    case ON:
                    case VAR:
                    case FUNCTION:
                    case MACRO:
                        expectIdentifier = true;
                }
            }
            if (expectIdentifier) {
                if (this.current.type == Type.UNKNOWN) this.current.type = Type.IDENTIFIER;
                expectIdentifier = false;
            }
            put();
            return;
        }
        this.current.content += currChar;
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
