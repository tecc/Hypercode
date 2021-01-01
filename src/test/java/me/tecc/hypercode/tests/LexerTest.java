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

    @Test
    public void lexerTest () {
        Lexer lexer = new Lexer();

        lexer.init();
        List<Token> tokens = lexer.lex("on event");
        for (Token t : tokens) {
            log.info(t::toString);
        }
        for (LexingError error : lexer.errors()) {
            log.error(error::toString);
        }
        Assertions.assertEquals(0, lexer.errors().size(), "Errors were encountered during lexing");
        Assertions.assertEquals(2, tokens.size(), "Expected 2 tokens");

        lexer.init();
        tokens = lexer.lex("var a = 2");
        for (Token t : tokens) {
            log.info(t::toString);
        }
        for (LexingError error : lexer.errors()) {
            log.error(error::toString);
        }
        Assertions.assertEquals(0, lexer.errors().size(), "Errors were encountered during lexing");
        Assertions.assertEquals(4, tokens.size(), "Expected 4 tokens");

        lexer.init();
        lexer.lex("function doALot(param1, param2) { doSomething(param1); doSomethingElse(param2) }");

    }

}
