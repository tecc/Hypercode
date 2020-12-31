package me.tecc.hypercode.templates.item;

public class Item {
    String material;
    short amount;

    ItemMeta meta;

    public Item(String material, short amount, ItemMeta meta) {
        this.material = material;
        this.amount = amount;
        this.meta = meta;
    }
}
