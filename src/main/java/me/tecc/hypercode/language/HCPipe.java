package me.tecc.hypercode.language;

import com.google.gson.JsonObject;
import me.tecc.hypercode.language.compiling.Compiler;
import me.tecc.hypercode.language.lexing.*;
import me.tecc.hypercode.language.parsing.*;
import me.tecc.hypercode.templates.Template;
import me.tecc.hypercode.language.compiling.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Hypercode Pipe.
 * Lexes, parses and compiles code all at once.
 */
public class HCPipe {
    private Lexer lexer;
    private Parser parser;
    private Compiler compiler;

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
