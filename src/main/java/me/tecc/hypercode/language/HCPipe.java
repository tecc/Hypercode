package me.tecc.hypercode.language;

import me.tecc.hypercode.language.compiling.Compiler;
import me.tecc.hypercode.language.lexing.Lexer;
import me.tecc.hypercode.language.lexing.LexingError;
import me.tecc.hypercode.language.lexing.Token;
import me.tecc.hypercode.language.parsing.AbstractSyntaxTree;
import me.tecc.hypercode.language.parsing.Parser;
import me.tecc.hypercode.language.parsing.ParsingError;
import me.tecc.hypercode.templates.Template;

import java.util.ArrayList;
import java.util.List;

/**
 * Hypercode Pipe.
 * Lexes, parses and compiles code all at once.
 */
public class HCPipe {
    private final Lexer lexer;
    private final Parser parser;
    private final Compiler compiler;

    public HCPipe() {
        this.lexer = new Lexer();
        this.parser = new Parser();
        this.compiler = new Compiler();
    }

    public PipeResult pipe(String code) {
        List<Token> tokens = lexer.lex(code);

        if (lexer.errors().size() > 0) {
            return new PipeResult() {
                @Override
                public Template template() {
                    return null;
                }

                @Override
                public boolean successful() {
                    return false;
                }

                @Override
                public List<LexingError> lexErrors() {
                    return lexer.errors();
                }

                @Override
                public List<ParsingError> parseErrors() {
                    return new ArrayList<>();
                }
            };
        }

        AbstractSyntaxTree ast = parser.parse(tokens);
        // TODO parser stuff
        return new PipeResult() {
            @Override
            public Template template() {
                return null;
            }

            @Override
            public boolean successful() {
                return false;
            }

            @Override
            public List<LexingError> lexErrors() {
                return new ArrayList<>();
            }

            @Override
            public List<ParsingError> parseErrors() {
                return new ArrayList<>();
            }
        };
    }
}
