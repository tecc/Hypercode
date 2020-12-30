package me.tecc.hypercode.cli;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import java.util.List;

public class CompileCommand extends CLICommand {
    private static Options getOpts() {
        Options opts = new Options()
                .addOption("o", "out", true, "The output file name.")
                .addOption("pt", "plotType", true, "The plot type to compile for.");
        return opts;
    }

    public CompileCommand() {
        super(
                new String[]{ "compile" },
                "Attempts to compile a file."
        );
    }

    @Override
    public void execute(CommandLine cmd) {

    }
}
