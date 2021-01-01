package me.tecc.hypercode.templates.item;

import com.google.gson.JsonObject;
import me.tecc.hypercode.utils.IJsonModel;

/**
 * Wrapper for Items from the DiamondFire templates format.
 */
public class Item implements IJsonModel<Item> {
    String material; // E.g. "firework_rocket"
    short amount;
    ItemMeta meta;

    public Item(String material, short amount, ItemMeta meta) {
        this.material = material;
        this.amount = amount;
        this.meta = meta;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setAmount(short amount) {
        this.amount = amount;
    }

    public void setMeta(ItemMeta meta) {
        this.meta = meta;
    }

    @Override
    public JsonObject toJson(Item value) {
        return null;
    }
}
