package me.tecc.hypercode;

import com.google.gson.JsonObject;
import me.tecc.hypercode.cli.CLICommand;
import me.tecc.hypercode.cli.CompileCommand;
import me.tecc.hypercode.cli.HelpCommand;
import me.tecc.hypercode.templates.TemplateCoder;
import org.apache.commons.cli.ParseException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

public class Hypercode {
    public static final List<CLICommand> commands = Arrays.asList(
            new HelpCommand(),
            new CompileCommand()
    );

    public static void main(String[] args) throws ParseException {
        System.out.println("Hypercode CLI");
        System.out.println("Copyright (c) 2020 Technotype, MarcusSlover & 1pe. All rights reserved.");
        if (args.length < 1) {
            System.out.println("No command provided, resorting to help.");
            args = new String[]{"help"};
        }
        String command = args[0];
        CLICommand cmd = getCommand(command);
        if (cmd == null) {
            System.out.println("Command not found, resorting to help.");
            cmd = getCommand("help");
        }
        System.out.println();
        assert cmd != null;
        cmd.run(Arrays.stream(args)
                .skip(1)
                .collect(Collectors.toList())
                .toArray(new String[]{})
        );
    }

    public static CLICommand getCommand(String name) {
        for (CLICommand cmd : commands) {
            if (cmd.isCommand(name)) return cmd;
        }
        return null;
    }
}
