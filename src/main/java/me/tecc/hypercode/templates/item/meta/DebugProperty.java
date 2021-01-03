package me.tecc.hypercode.templates.item.meta;

import net.querz.nbt.tag.CompoundTag;

public class DebugProperty {
     CompoundTag debugProperty;
     String blockId;

    public DebugProperty(CompoundTag debugProperty, String blockId) {

        this.debugProperty = debugProperty;
        this.blockId = blockId;
    }
}
