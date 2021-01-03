package me.tecc.hypercode.cli;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import me.tecc.hypercode.templates.TemplateCoder;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class TemplateCommand extends CLICommand {
    private static CommandUsage getUsage() {
        CommandUsage usage = new CommandUsage();
        // usage.addArgument("options", "Options.", true, true);
        usage.addArgument("mode", "The command mode", false);
        usage.addArgument("input", "The input for the mode.", false);
        return usage;
    }

    private static Options getOptions() {
        return new Options();
    }

    public TemplateCommand() {
        super(
                new String[]{ "template", "t" },
                "Template utilities.",
                getUsage(),
                getOptions()
        );
    }

    @Override
    protected void execute(CommandLine cmd) {
        List<String> args = cmd.getArgList();
        if (args.size() < 2) {
            System.out.println("There needs to at least 2 arguments. Printing usage.");
            this.printUsage();
            return;
        }

        Mode mode = Mode.getMode(args.get(0));
        if (mode == null) {
            System.out.println("Invalid mode. Printing usage.");
            this.printUsage();
            return;
        }

        String rest = StringUtils.join(args.stream().skip(2).toArray(), " ");
        if (mode == Mode.DECODE) {
            JsonObject decoded = TemplateCoder.decode(rest);
            if (decoded == null) return;
            System.out.printf("Decoded template: \n%s\n", decoded.toString());

        } else {
            String encoded = TemplateCoder.encode(JsonParser.parseString(rest).getAsJsonObject());
            if (encoded == null) return;
            System.out.printf("Encoded template: %s\n", encoded);
        }


    }

    private enum Mode {
        DECODE("decode", "decompress", "d"),
        ENCODE("encode", "compress", "e");
        List<String> names;
        Mode(String... names) {
            this.names = Arrays.asList(names);
        }

        public static Mode getMode(String name) {
            for (Mode m : Mode.values()) {
                if (m.names.contains(name))
                    return m;
            }
            return null;
        }
    }
}
