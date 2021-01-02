package me.tecc.hypercode.templates.item;

import com.google.gson.JsonObject;
import me.tecc.hypercode.templates.reference.ItemType;
import me.tecc.hypercode.utils.IBuilder;
import me.tecc.hypercode.utils.JsonReader;
import me.tecc.hypercode.utils.Util;
import net.querz.nbt.io.NamedTag;
import net.querz.nbt.tag.CompoundTag;

import java.io.IOException;

public class ItemBuilder implements IBuilder<Item> {

    // Generic data.
    protected JsonObject itemJson;
    protected long slot;

    // Item type.
    protected ItemType itemType;

    // Normal item.
    private Item item;

    public ItemBuilder() {
        this(new JsonObject());
    }

    public ItemBuilder(JsonObject itemJson) {
        this(itemJson, 0);
    }

    public ItemBuilder(JsonObject itemJson, long slot) {
        this.itemJson = itemJson;
        this.slot = slot;
        this.initialParse();
    }

    private void initialParse() {
        JsonReader json = new JsonReader(itemJson);
        String id = json.readString("id", "");
        JsonObject data = json.readObject("data", new JsonObject());

        // Set the item type.
        this.itemType = ItemType.getByIdentifier(id);

        switch (id) {
            // Normal item.
            case "item":
                // Parsing the NBT
                String nbt = data.get("item").getAsString();
                NamedTag namedTag = this.parseNBT(nbt);
                CompoundTag compoundTag = (CompoundTag) namedTag.getTag();
                this.item = ItemCoder.decode(compoundTag);

                break;
            // Chest tag.
            case "bl_tag":

                break;
            default:
                break;
        }
    }

    private NamedTag parseNBT(String data) {
        try {
            return Util.deserialize(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new NullPointerException("Could not deserialize the NBT data: " + data);
    }

    public ItemBuilder setItemJson(JsonObject itemJson) {
        this.itemJson = itemJson;
        return this;
    }

    public ItemBuilder setSlot(long slot) {
        this.slot = slot;
        return this;
    }

    @Override
    public Item build() {
        return item;
    }
}
