package me.tecc.hypercode.language;

import com.google.gson.JsonObject;
import me.tecc.hypercode.language.lexing.LexingError;
import me.tecc.hypercode.language.parsing.ParsingError;
import me.tecc.hypercode.templates.Template;

import java.util.List;

public interface PipeResult {
    Template template();
    boolean successful();
    List<LexingError> lexErrors();
    List<ParsingError> parseErrors();
}
