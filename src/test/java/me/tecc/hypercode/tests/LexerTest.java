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
        lex("var pi=3.14159265389", 4);
        lex("function doALot(param1, param2) { doSomething(param1) doSomethingElse(param2) }", 17);
    }


    private void lex(String code, int expectedTokens) {
        System.out.println("Lexing code: " + code);
        lexer.init();
        List<Token> tokens = lexer.lex(code);
        log.info(() -> "Logging tokens...");
        for (Token t : tokens) {
            log.info(t::toString);
        }
        log.info(() -> "Logging errors (if any)...");
        for (LexingError error : lexer.errors()) {
            log.error(error::toString);
        }
        Assertions.assertEquals(0, lexer.errors().size(), "Errors were encountered during lexing");
        Assertions.assertEquals(expectedTokens, tokens.size(), "Expected 4 tokens");

    }
}
