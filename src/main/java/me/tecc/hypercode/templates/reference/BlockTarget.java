package me.tecc.hypercode.templates.reference;

public enum BlockTarget {
    DEFAULT(""),
    SELECTED("selected"),
    ALL(""),
    ;

    final String identifier;

    BlockTarget(String identifier) {
        this.identifier = identifier;
    }

    /**
     * Finds a BlockTarget by the given identifier name.
     * @param identifier The identifier.
     * @return BlockTarget matching the given identifier.
     */
    public static BlockTarget getByIdentifier(String identifier) {
        for (BlockTarget blockTarget : values()) {
            if (blockTarget.identifier.equalsIgnoreCase(identifier)) {
                return blockTarget;
            }
        }
        throw new NullPointerException("Could not find a BlockTarget " +
                "with the following identifier: \"" + identifier + " \"");
    }
}
