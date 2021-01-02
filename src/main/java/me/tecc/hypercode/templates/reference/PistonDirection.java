package me.tecc.hypercode.templates.reference;

public enum PistonDirection {
    OPEN("open"),
    CLOSE("close"),
    NULL("null")
    ;

    final String identifier;

    PistonDirection(String identifier) {
        this.identifier = identifier;
    }

    /**
     * Finds a PistonDirection by the given identifier name.
     * @param identifier The identifier.
     * @return PistonDirection matching the given identifier.
     */
    public static PistonDirection getByIdentifier(String identifier) {
        for (PistonDirection pistonDirection : values()) {
            if (pistonDirection.identifier.equalsIgnoreCase(identifier)) {
                return pistonDirection;
            }
        }
        throw new NullPointerException("Could not find a PistonDirection " +
                "with the following identifier: \"" + identifier + " \"");
    }
}
