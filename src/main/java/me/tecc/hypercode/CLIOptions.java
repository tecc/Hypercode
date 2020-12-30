package me.tecc.hypercode;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

/**
 * Simple class that does
 */
public class CLIOptions {
    Option output = new Option("out", "outputDir", true, "Sets the output directory.");

    Options get() {
        return new Options()
                .addOption(output);
    }
}
