package me.tecc.hypercode.templates;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import me.tecc.hypercode.templates.reference.BlockAction;
import me.tecc.hypercode.templates.reference.BlockId;
import me.tecc.hypercode.templates.reference.BlockTarget;
import me.tecc.hypercode.templates.reference.BlockType;
import me.tecc.hypercode.utils.IJsonModel;
import me.tecc.hypercode.utils.JsonReader;

public class CodeBlock implements IJsonModel<CodeBlock> {

    BlockId blockId;
    BlockType blockType = null;
    BlockAction blockAction = null;
    BlockTarget blockTarget = null;
    boolean isPiston;
    boolean isInverted;

    protected CodeBlock(String id, String block, String action, String target, String inverted, JsonArray args, String type, String dir) {
        this.blockId = BlockId.getByIdentifier(id);

        if (!block.isEmpty()) {
            this.blockType = BlockType.getByIdentifier(block);
        }
        if (!action.isEmpty()) {
            this.blockAction = BlockAction.getByIdentifier(action);
        }
        if (!target.isEmpty()) {
            this.blockTarget = BlockTarget.getByIdentifier(target);
        }
        this.isInverted = !inverted.isEmpty();
        this.isPiston = blockId.equals(BlockId.BRACKET);
    }

    @Override
    public JsonObject toJson(CodeBlock value) {
        return null;
    }

    public static CodeBlock fromJson(JsonObject jsonObject) {
        // Using a utility for comfortable reading.
        JsonReader json = new JsonReader(jsonObject);

        // Typical data.
        String id = json.readString("id", "");
        String block = json.readString("block", "");
        String action = json.readString("action", "");
        String target = json.readString("target", "");
        String inverted = json.readString("inverted", ""); //Default Value is Nothing... Like it isnt there
        JsonArray args = json.readArray("args", new JsonArray());

        // Pistons (brackets) data.
        String type = json.readString("type", "");
        String dir = json.readString("direct", "");


        return new CodeBlock(id, block, action, target, inverted, args, type, dir);
    }
}
