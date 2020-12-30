package me.tecc.hypercode.templates.reference;

public enum BlockId {
    CODE_BLOCK("block"),
    BRACKET("bracket");

    final String identifier;

    BlockId(String identifier) {
        this.identifier = identifier;
    }

    /**
     * Finds a BlockId by the given identifier name.
     * @param identifier The identifier.
     * @return BlockId matching the given identifier.
     */
    public static BlockId getByIdentifier(String identifier) {
        for (BlockId blockId : values()) {
            if (blockId.identifier.equalsIgnoreCase(identifier)) {
                return blockId;
            }
        }
        throw new NullPointerException("Could not find a BlockId " +
                "with the following identifier: \"" + identifier + " \"");
    }
}
