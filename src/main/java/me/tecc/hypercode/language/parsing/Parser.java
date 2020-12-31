package me.tecc.hypercode.language.parsing;

import me.tecc.hypercode.language.lexing.*;

import java.util.List;

public class Parser {


    public AbstractSyntaxTree parse(List<Token> tokens) {
        for (Token token : tokens) {
            if (token.type == Token.Type.KEYWORD) {
                switch (token.content) {
                    case "function":
                        break;
                }
            }
        }

        return null;
    }
}
