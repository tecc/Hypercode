package me.tecc.hypercode.templates;

import com.google.gson.JsonObject;
import me.tecc.hypercode.templates.reference.*;
import me.tecc.hypercode.utils.IJsonModel;
import me.tecc.hypercode.utils.JsonReader;

/**
 * Class containing all the information about a singular code-block.
 */
public class CodeBlock implements IJsonModel<CodeBlock> {

    // Generic data.
    BlockId blockId;
    BlockType blockType = null;
    BlockAction blockAction = null;
    BlockTarget blockTarget = null;
    boolean isInverted; // True, if the code-block sign contained the 'NOT' line.

    // Piston data.
    PistonData pistonData;
    boolean isPiston;

    // Chest data.
    CodeBlockChest chest;

    protected CodeBlock(String id, String block, String action, String target, String inverted, JsonObject args, String type, String dir) {
        this.blockId = BlockId.getByIdentifier(id); // All blocks have their id.

        if (!block.isEmpty()) { // Type of the block e.g "event"
            this.blockType = BlockType.getByIdentifier(block);
        }
        if (!action.isEmpty()) { // Action of the block e.g "Join"
            this.blockAction = BlockAction.getByIdentifier(action);
        }
        // Target of the block e.g "Default"
        this.blockTarget = BlockTarget.getByIdentifier(target);

        // Not arrow!
        this.isInverted = !inverted.isEmpty();

        // Reading pistons.
        PistonType pistonType = null;
        PistonDirection pistonDirection = null;
        this.isPiston = blockId.equals(BlockId.BRACKET);

        if (!type.isEmpty()) {
            pistonType = PistonType.getByIdentifier(type);
        }
        if (!dir.isEmpty()) {
            pistonDirection = PistonDirection.getByIdentifier(dir);
        }
        this.pistonData = new PistonData(pistonType, pistonDirection);

        // More complex data.
        this.chest = new CodeBlockChest(args);
    }

    @Override
    public JsonObject toJson(CodeBlock value) {
        JsonObject json = new JsonObject();

        return json;
    }

    public static CodeBlock fromJson(JsonObject jsonObject) {
        // Using a utility for more comfortable reading.
        JsonReader json = new JsonReader(jsonObject);

        // Generic data.
        String id = json.readString("id", "");
        String block = json.readString("block", "");
        String action = json.readString("action", "");
        String target = json.readString("target", "");
        String inverted = json.readString("inverted", "");
        JsonObject args = json.readObject("args", new JsonObject());

        // Pistons (brackets) data.
        String type = json.readString("type", "");
        String dir = json.readString("direct", "");

        // Creation of the object.
        return new CodeBlock(id, block, action, target, inverted, args, type, dir);
    }
}
