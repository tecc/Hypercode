package me.tecc.hypercode.templates.item.meta;

import java.util.List;
import java.util.UUID;

public class SkullMeta extends ItemMeta {

    UUID uuid;
    String ownerName;
    List<SkullTexture> skullTextureList;

    public SkullMeta(UUID uuid, String ownerName, List<SkullTexture> skullTextureList) {

        this.uuid = uuid;
        this.ownerName = ownerName;
        this.skullTextureList = skullTextureList;
    }
}
