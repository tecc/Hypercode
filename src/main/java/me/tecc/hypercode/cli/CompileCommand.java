package me.tecc.hypercode.cli;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import java.io.File;
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
    }
}
