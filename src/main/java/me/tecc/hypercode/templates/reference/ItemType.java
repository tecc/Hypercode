package me.tecc.hypercode.templates.reference;

public enum ItemType {
    ITEM("item"),
    TAG("bl_tag"),
    NULL("null")
    ;

    final String identifier;

    ItemType(String identifier) {
        this.identifier = identifier;
    }

    /**
     * Finds a ItemType by the given identifier name.
     * @param identifier The identifier.
     * @return ItemType matching the given identifier.
     */
    public static ItemType getByIdentifier(String identifier) {
        for (ItemType itemType : values()) {
            if (itemType.identifier.equalsIgnoreCase(identifier)) {
                return itemType;
            }
        }
        throw new NullPointerException("Could not find a ItemType " +
                "with the following identifier: \"" + identifier + " \"");
    }
}
