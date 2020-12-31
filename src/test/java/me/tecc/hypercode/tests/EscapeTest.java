package me.tecc.hypercode.tests;

import me.tecc.hypercode.language.lexing.Lexer;
import me.tecc.hypercode.language.lexing.Token;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EscapeTest {
    Lexer l = new Lexer();

    @Test
    public void escapeTest() {
        l.init();
        List<Token> tokens = l.lex("\"\\\\e\"");
        Assertions.assertEquals(1, tokens.size());
        Token expected = new Token();
        expected.type = Token.Type.STRING;
        expected.content = "\\\\e";
        Assertions.assertEquals(tokens.get(0), expected);
    }
}
