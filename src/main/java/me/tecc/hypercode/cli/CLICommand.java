package me.tecc.hypercode.cli;

import org.apache.commons.cli.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Superclass of all commands available in the CLI.
 */
public abstract class CLICommand {
    List<String> names;
    String description;
    CommandUsage usage;
    Options options;

    /**
     * Creates a CLI command.
     *
     * @param names The names that can be used when trying to invoke this command.
     *              {@code names[0]} is the display name.
     * @param description The description of the command.
     *
     * @see #CLICommand(String[], String, Options)
     * @see #CLICommand(String[], String, CommandUsage, Options)
     */
    public CLICommand(String[] names, String description) {
        this(names, description, new Options());
    }
    /**
     * Creates a CLI command.
     *
     * @param names The names that can be used when trying to invoke this command.
     *              {@code names[0]} is the display name.
     * @param description The description of the command.
     * @param options The options for this command.
     *
     * @see #CLICommand(String[], String, CommandUsage, Options)
     */
    public CLICommand(String[] names, String description, Options options) {
        this(names, description, CommandUsage.getDefaultUsage(), options);
    }

    /**
     * Creates a CLI command.
     *
     * @param names The names that can be used when trying to invoke this command.
     *              {@code names[0]} is the display name.
     * @param description The description of the command.
     * @param usage The usage for this command.
     */
    public CLICommand(String names[], String description, CommandUsage usage) {
        this(names, description, usage, new Options());
    }

    /**
     * Creates a CLI command.
     *
     * @param names The names that can be used when trying to invoke this command.
     *              {@code names[0]} is the display name.
     * @param description The description of this command.
     * @param usage The usage for this command.
     * @param options The options for this command.
     */
    public CLICommand(String[] names, String description, CommandUsage usage, Options options) {
        this.names = Arrays.stream(names)
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        this.description = description;
        this.options = options;
        this.usage = usage;
    }

    /**
     * Checks if {@code name} is one of this commands aliases.
     *
     * @param name The command name to check.
     * @return True if {@code name} is one of this commands names,
     *         false otherwise.
     */
    public boolean isCommand(String name) {
        return names.contains(name.toLowerCase());
    }

    /**
     * Runs the command.
     *
     * @param args The command line arguments passed to this command
     * @throws ParseException If any problems were encountered whilst parsing the arguments.
     *
     * @see CommandLineParser
     */
    public final void run(String[] args) throws ParseException {
        CommandLineParser parser = new DefaultParser();
        CommandLine cli = parser.parse(options, args);
        execute(cli);
    }

    /**
     * Attempts to execute the command.
     *
     * @param cmd The {@link CommandLine} object generated by Commons Cli when parsing options.
     */
    protected abstract void execute(CommandLine cmd);

    protected void printUsage() {
        HelpFormatter h = new HelpFormatter();
        h.printHelp("hypercode " + this.names.get(0) + " " + this.usage.getUsageString(), options);
        if (this.usage.argumentCount() > 0) {
            System.out.println("Arguments:");
            System.out.println(this.usage.getArgumentDescription(4));
        }
    }
}
