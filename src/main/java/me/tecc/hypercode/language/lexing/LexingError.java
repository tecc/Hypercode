package me.tecc.hypercode.language.lexing;

public class LexingError {
    Token token;
    String error;

    LexingError(Token t, String err) {
        this.token = t;
        this.error = err;
    }

    public String toString() {
        return "Error in token " + token.toString() + ": " + error;
    }
}
