package me.tecc.hypercode.cli;

import java.util.ArrayList;
import java.util.List;

public class CommandUsage {
    public List<Argument> arguments;

    /**
     * Simple constructor.
     * Initialises required values.
     */
    public CommandUsage() {
        this.arguments = new ArrayList<>();
    }

    public int argumentCount() {
        return arguments.size();
    }

    /**
     * Adds an argument to this Usage.
     * By default, the argument is not variadic.
     *
     * @param name The name of the argument.
     * @param description The description of the argument.
     *
     * @return A reference to this usage.
     *
     * @see #addArgument(String, String, boolean)
     * @see #addArgument(String, String, boolean, boolean)
     */
    public CommandUsage addArgument(String name, String description) {
        return addArgument(name, description, false);
    }

    /**
     * Adds an argument to this Usage.
     * By default, the argument is not variadic.
     *
     * @param name The name of the argument.
     * @param description The description of the argument.
     * @param optional Whether or not this argument is optional.
     *
     * @return A reference to this usage.
     *
     * @see #addArgument(String, String, boolean, boolean)
     */
    public CommandUsage addArgument(String name, String description, boolean optional) {
        return addArgument(name, description, optional, false);
    }

    /**
     * Adds an argument to this Usage.
     * By default, the argument is not variadic.
     *
     * @param name The name of the argument.
     * @param description The description of the argument.
     * @param optional Whether or not this argument is optional.
     * @param variadic Whether or not this argument is variadic (can be included multiple times).
     *
     * @return A reference to this usage.
     */
    public CommandUsage addArgument(String name, String description, boolean optional, boolean variadic) {
        arguments.add(new Argument(name, description, optional, variadic));
        return this;
    }

    /**
     * Bundles all arguments up into a string describing the usage of a command.
     *
     * @return the usage string
     */
    public String getUsageString() {
        if (arguments.size() == 0) return "";
        StringBuilder b = new StringBuilder();
        for (Argument arg : arguments) {
            b.append(arg).append(" ");
        }
        return b.toString();
    }

    /**
     * Equivalent of {@link #getUsageString()}.
     *
     * @see #getUsageString()
     */
    public String toString() {
        return getUsageString();
    }

    /**
     * Gets all arguments description and appends them to another.
     *
     * @return The argument description for this Usage.
     */
    public String getArgumentDescription(int indent) {
        StringBuilder b = new StringBuilder();
        for (Argument arg : arguments) {
            for (int i = 0; i < indent; ++i) b.append(" ");
            b.append(arg.name).append(": ").append(arg.description);
        }
        return b.toString();
    }

    /**
     * Wrapper class for arguments.
     * Only here to hold data.
     */
    public class Argument {
        public static final String OPTIONAL_ARGUMENT_FORMAT = "[%s]";
        public static final String REQUIRED_ARGUMENT_FORMAT = "<%s>";

        String name;
        String description;
        boolean optional;
        boolean variadic;

        public Argument(String name, String description, boolean optional, boolean variadic) {
            this.name = name;
            this.description = description;
            this.optional = optional;
            this.variadic = variadic;
        }

        /**
         * Gets the argument as it would be displayed in the "usage: " part of a help message.
         *
         * @return The display of the argument.
         */
        public String getArgument() {
            if (optional)
                return String.format(OPTIONAL_ARGUMENT_FORMAT, this.name + (this.variadic ?  "..." : ""));
            else
                return String.format(REQUIRED_ARGUMENT_FORMAT, this.name + (this.variadic ? "..." : ""));
        }

        /**
         * Equivalent to {@link #getArgument()}
         *
         * @see #getArgument()
         */
        public String toString() {
            return this.getArgument();
        }
    }

    public static CommandUsage getDefaultUsage() {
        // might do something here later so..
        return new CommandUsage();
    }
}
