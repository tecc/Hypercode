package me.tecc.hypercode.templates.item.meta;

import java.util.UUID;

public class AttributeModifier {
    String attributeName;
    String name;
    String slot;
    int operation;
    double amount;
    UUID uuid;

    public AttributeModifier(String attributeName, String name, String slot, int operation, double amount, UUID uuid) {
        this.attributeName = attributeName;
        this.name = name;
        this.slot = slot;
        this.operation = operation;
        this.amount = amount;
        this.uuid = uuid;
    }
}
