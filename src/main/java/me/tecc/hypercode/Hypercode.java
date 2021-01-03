package me.tecc.hypercode;

import me.tecc.hypercode.cli.CLICommand;
import me.tecc.hypercode.cli.CompileCommand;
import me.tecc.hypercode.cli.HelpCommand;
import me.tecc.hypercode.cli.TemplateCommand;
import org.apache.commons.cli.ParseException;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Hypercode {
    public static final List<CLICommand> commands = Arrays.asList(
            new HelpCommand(),
            new CompileCommand(),
            new TemplateCommand()
    );

    public static HypercodeMeta meta;

    public static void main(String[] args) throws ParseException, IOException {
        meta = HypercodeMeta.load();
        System.out.printf("Hypercode CLI - Version %s for patch %s\n", meta.version(), meta.hypercubeVersion());
        System.out.println("Copyright (c) 2020-2021 Technotype, MarcusSlover & Hammer86gn. All rights reserved.");
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
