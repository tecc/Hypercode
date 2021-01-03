package me.tecc.hypercode.cli;

import me.tecc.hypercode.Hypercode;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.lang3.StringUtils;

public class HelpCommand extends CLICommand {
    private static CommandUsage getUsage() {
        CommandUsage usage = new CommandUsage();
        usage.addArgument(
                "command",
                "The command to get help for. If omitted, prints a list of commands.",
                true);
        return usage;
    }

    public HelpCommand() {
        super(
                new String[]{ "help", "h", "usage", "u" },
                "Displays information about the Hypercode CLI.",
                getUsage()
        );
    }

    @Override
    protected void execute(CommandLine cmd) {
        if (cmd.getArgs().length > 0) {
            String commandName = cmd.getArgs()[0];
            CLICommand command = Hypercode.getCommand(commandName);
            command.printUsage();
            return;
        }

        System.out.println("usage: hypercode <command> [arguments...]");
        System.out.println("Commands:");
        for (CLICommand command : Hypercode.commands) {
            System.out.printf("    %s: %s\n", StringUtils.join(command.names, " | "), command.description);
        }

        HelpFormatter h = new HelpFormatter();
    }
}
