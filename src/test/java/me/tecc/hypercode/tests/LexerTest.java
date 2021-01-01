package me.tecc.hypercode.tests;


import me.tecc.hypercode.language.lexing.Lexer;
import me.tecc.hypercode.language.lexing.LexingError;
import me.tecc.hypercode.language.lexing.Token;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.List;

public class LexerTest {
    Logger log = LoggerFactory.getLogger(this.getClass());
    Lexer lexer = new Lexer();

    @Test
    public void lexerTest () {
        // few whitespace tests
        lex("var pi=3.14159265389", 4);
        lex("var pi = 3.141592658389", 4);
        // bombard it with a bunch of stuff
        lex("function doALot(param1, param2) { doSomething(param1) doSomethingElse(param2) }", 17);
        lex("macro randomMacro=doALot(randomMacro, pi)", 9);
        lex("macro 1 = \"1\"", 4, 1); // if this was possible it would be pure evil
    }

    private void lex(String code, int expectedTokens) {
        lex(code, expectedTokens, 0);
    }

    private void lex(String code, int expectedTokens, int expectedErrors) {
        log.info(() -> "Lexing code: " + code);
        lexer.init();
        List<Token> tokens = lexer.lex(code);
        log.info(() -> "Logging tokens...");
        StringBuilder b = new StringBuilder();
        for (Token t : tokens) {
            b.append(t);
        }
        log.info(b::toString);
        log.info(() -> "Logging errors (if any)...");
        for (LexingError error : lexer.errors()) {
            log.error(error::toString);
        }
        Assertions.assertEquals(expectedErrors, lexer.errors().size(), "Expected " + expectedErrors + " errors");
        Assertions.assertEquals(expectedTokens, tokens.size(), "Expected " + expectedTokens + " errors");

    }
}
