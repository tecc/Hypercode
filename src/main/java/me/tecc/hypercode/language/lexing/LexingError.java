package me.tecc.hypercode.language.lexing;

import me.tecc.hypercode.utils.TextPosition;

public class LexingError {
    Token token;
    String error;
    TextPosition position;

    LexingError(Token t, String err, long line, long column) {
        this.token = t;
        this.error = err;
        this.position = new TextPosition(line, column);
    }

    public String toString() {
        return "Error at " + position + ": " + error;
    }
}
