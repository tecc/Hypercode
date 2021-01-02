package me.tecc.hypercode.templates.reference;

public enum PistonType {
    NORMAL("norm"),
    REPEAT("repeat"),
    NULL("null")
    ;

    final String identifier;

    PistonType(String identifier) {
        this.identifier = identifier;
    }

    /**
     * Finds a PistonType by the given identifier name.
     * @param identifier The identifier.
     * @return PistonType matching the given identifier.
     */
    public static PistonType getByIdentifier(String identifier) {
        for (PistonType pistonType : values()) {
            if (pistonType.identifier.equalsIgnoreCase(identifier)) {
                return pistonType;
            }
        }
        throw new NullPointerException("Could not find a PistonType " +
                "with the following identifier: \"" + identifier + " \"");
    }
}
