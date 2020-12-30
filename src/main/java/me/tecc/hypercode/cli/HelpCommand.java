package me.tecc.hypercode.cli;

import me.tecc.hypercode.Hypercode;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.lang3.StringUtils;

public class HelpCommand extends CLICommand {

    public HelpCommand() {
        super(
                new String[]{ "help", "h", "usage", "u" },
                "Displays information about the Hypercode CLI."
        );
    }

    @Override
    protected void execute(CommandLine cmd) {
        if (cmd.getArgs().length > 0) {
            String commandName = cmd.getArgs()[0];
            CLICommand command = Hypercode.getCommand(commandName);
            HelpFormatter h = new HelpFormatter();
            h.printHelp("hypercode " + commandName + " [options]", options);
            return;
        }

        System.out.println("Usage: hypercode <command> [arguments...]");
        System.out.println("Commands:");
        for (CLICommand command : Hypercode.commands) {
            System.out.printf("    %s: %s\n", StringUtils.join(command.names, " | "), command.description);
        }

        HelpFormatter h = new HelpFormatter();
    }
}
