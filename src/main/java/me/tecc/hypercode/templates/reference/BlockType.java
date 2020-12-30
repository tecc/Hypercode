package me.tecc.hypercode.templates.reference;

/**
 * Field reference to block types.
 */
public enum BlockType {
    PLAYER_EVENT("event"),
    ENTITY_EVENT("entity_event"),
    FUNCTION("func"),
    PROCESS("process"),
    IF_PLAYER("if_player"),
    IF_ENTITY("if_entity"),
    IF_GAME("if_game"),
    IF_VARIABLE("if_var"),
    ELSE("else"),
    PLAYER_ACTION("player_action"),
    ENTITY_ACTION("entity_action"),
    GAME_ACTION("game_action"),
    SELECT_OBJECT("select_obj"),
    SET_VARIABLE("set_var"),
    CONTROL("control"),
    REPEAT("repeat"),
    CALL_FUNCTION("call_func"),
    START_PROCESS("start_process");

    final String identifier;

    BlockType(String identifier) {
        this.identifier = identifier;
    }

    /**
     * Finds a BlockType by the given identifier name.
     * @param identifier The identifier.
     * @return BlockType matching the given identifier.
     */
    public static BlockType getByIdentifier(String identifier) {
        for (BlockType blockType : values()) {
            if (blockType.identifier.equalsIgnoreCase(identifier)) {
                return blockType;
            }
        }
        throw new NullPointerException("Could not find a BlockType " +
                "with the following identifier: \"" + identifier + " \"");
    }
}
