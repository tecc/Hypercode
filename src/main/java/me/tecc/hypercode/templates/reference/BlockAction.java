package me.tecc.hypercode.templates.reference;

public enum BlockAction {
    JOIN("join");

    final String identifier;

    BlockAction(String identifier) {
        this.identifier = identifier;
    }

    /**
     * Finds a BlockAction by the given identifier name.
     * @param identifier The identifier.
     * @return BlockAction matching the given identifier.
     */
    public static BlockAction getByIdentifier(String identifier) {
        for (BlockAction blockAction : values()) {
            if (blockAction.identifier.equalsIgnoreCase(identifier)) {
                return blockAction;
            }
        }
        throw new NullPointerException("Could not find a BlockAction " +
                "with the following identifier: \"" + identifier + " \"");
    }
}
