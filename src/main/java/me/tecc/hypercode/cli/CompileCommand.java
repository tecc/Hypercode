package me.tecc.hypercode.cli;

import me.tecc.hypercode.language.HCPipe;
import me.tecc.hypercode.language.PipeResult;
import me.tecc.hypercode.language.lexing.LexingError;
import me.tecc.hypercode.language.parsing.ParsingError;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class CompileCommand extends CLICommand {
    private static Options getOpts() {
        Options opts = new Options()
                .addOption("o", "out", true, "The output file name. If it's a directory")
                .addOption("pt", "plotType", true, "The plot type to compile for.");
        return opts;
    }

    public CompileCommand() {
        super(
                new String[]{ "compile" },
                "Tries to compile a Hypercode source file.",
                getOpts()
        );
    }

    @Override
    public void execute(CommandLine cmd) {
        List<String> sourceFiles = cmd.getArgList();
        String out = cmd.getOptionValue("o");
        if (out == null) {
            out = "./";
        }

        File outputDirectory = new File(out);

        HCPipe pipe = new HCPipe();
        for (String sourceFile : sourceFiles) {
            try {
                String code = StringUtils.join(
                        IOUtils.readLines(
                                new FileInputStream(sourceFile),
                                Charset.defaultCharset()
                        )
                );

                PipeResult result = pipe.pipe(code);
                if (!result.successful()) {
                    System.out.println("Errors occurred during build:");
                    for (LexingError err : result.lexErrors()) {
                        System.out.println("    " + err.toString());
                    }
                    for (ParsingError err : result.parseErrors()) {
                        System.out.println("    " + err.toString());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void printErrors() {

    }
}
