package me.tecc.hypercode.language.lexing;

public class TokenError {
    Token token;
    String error;

    TokenError(Token t, String err) {
        this.token = t;
        this.error = err;
    }
}
