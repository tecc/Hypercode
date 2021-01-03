package me.tecc.hypercode.templates.item;

import me.tecc.hypercode.templates.item.meta.*;
import me.tecc.hypercode.utils.Util;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.chat.ComponentSerializer;
import net.querz.nbt.tag.CompoundTag;
import net.querz.nbt.tag.ListTag;
import net.querz.nbt.tag.StringTag;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ItemCoder {
    public static Item decode(CompoundTag compoundTag) {
        Item item = new Item();

        item.minecraftId = compoundTag.getString("id");
        item.minecraftCount = compoundTag.getByte("Count");

        // Additional item NBT.
        if (compoundTag.containsKey("tag")) {
            CompoundTag minecraftTag = compoundTag.getCompoundTag("tag");
            item.minecraftTag = minecraftTag;

            // Damage NBT.
            if (minecraftTag.containsKey("Damage")) {
                item.itemDamage = minecraftTag.getInt("Damage");
            }

            // Unbreakable NBT.
            if (minecraftTag.containsKey("Unbreakable")) {
                item.itemUnbreakabke = minecraftTag.getByte("Unbreakable");
            }

            // CanDestroy NBT.
            if (minecraftTag.containsKey("CanDestroy")) {
                ListTag<?> canDestroy = minecraftTag.getListTag("CanDestroy");
                item.itemCanDestroy = new ArrayList<>();

                @SuppressWarnings("unchecked")
                ListTag<StringTag> stringTags = (ListTag<StringTag>) canDestroy;

                for (StringTag stringTag : stringTags) {
                    item.itemCanDestroy.add(stringTag.getValue());
                }
            }

            // CustomModelData NBT
            if (minecraftTag.containsKey("CustomModelData")) {
                item.itemCustomModelData = minecraftTag.getInt("CustomModelData");
            }

            // Display NBT.
            if (minecraftTag.containsKey("display")) {
                CompoundTag display = minecraftTag.getCompoundTag("display");

                // Hex color.
                if (display.containsKey("color")) {
                    item.hexColor = display.getInt("color");
                }

                // Item name.
                if (display.containsKey("Name")) {
                    String nameJson = display.getString("Name");
                    BaseComponent[] parse = ComponentSerializer.parse(nameJson);
                    item.itemName = new TextComponent(parse);
                }

                // Item lore.
                if (display.containsKey("Lore")) {
                    ListTag<?> lore = display.getListTag("Lore");
                    item.itemLore = new ArrayList<>();

                    // Translating NBT into JSON components.
                    @SuppressWarnings("unchecked")
                    ListTag<StringTag> stringTags = (ListTag<StringTag>) lore;

                    for (StringTag stringTag : stringTags) {
                        String value = stringTag.getValue();
                        BaseComponent[] parse = ComponentSerializer.parse(value);
                        item.itemLore.add(new TextComponent(parse));
                    }
                }
            }

            // Hideflags NBT.
            if (minecraftTag.containsKey("HideFlags")) {
                item.hideflags = minecraftTag.getInt("HideFlags");
            }

            // CanPlaceOn NBT
            if (minecraftTag.containsKey("CanPlaceOn")) {
                ListTag<?> canPlaceOn = minecraftTag.getListTag("CanPlaceOn");
                item.itemCanPlaceOn = new ArrayList<>();

                @SuppressWarnings("unchecked")
                ListTag<StringTag> stringTags = (ListTag<StringTag>) canPlaceOn;

                for (StringTag stringTag : stringTags) {
                    item.itemCanPlaceOn.add(stringTag.getValue());
                }

            }

            // Enchantments
            if (minecraftTag.containsKey("Enchantments")) {
                ListTag<?> enchantments = minecraftTag.getListTag("Enchantments");
                item.enchantments = new ArrayList<>();

                @SuppressWarnings("unchecked")
                ListTag<CompoundTag> compoundTags = (ListTag<CompoundTag>) enchantments;

                for (CompoundTag tag : compoundTags) {
                    String id = tag.getString("id");
                    int lvl = tag.getInt("lvl");
                    item.enchantments.add(new Enchantment(id, lvl));
                }
            }

            if (minecraftTag.containsKey("StoredEnchantments")) {
                ListTag<?> enchantments = minecraftTag.getListTag("StoredEnchantments");
                item.storedEnchantments = new ArrayList<>();

                @SuppressWarnings("unchecked")
                ListTag<CompoundTag> compoundTags = (ListTag<CompoundTag>) enchantments;

                for (CompoundTag tag : compoundTags) {
                    String id = tag.getString("id");
                    int lvl = tag.getInt("lvl");
                    item.storedEnchantments.add(new Enchantment(id, lvl));
                }
            }

            if (minecraftTag.containsKey("RepairCost")) {
                item.repairCost = minecraftTag.getInt("RepairCost");
            }

            // Attribute
            if (minecraftTag.containsKey("AttributeModifiers")) {
                ListTag<?> attributeModifiers = minecraftTag.getListTag("AttributeModifiers");
                item.attributeModifiers = new ArrayList<>();

                @SuppressWarnings("unchecked")
                ListTag<CompoundTag> compoundTags = (ListTag<CompoundTag>) attributeModifiers;

                for (CompoundTag tag : compoundTags) {
                    String attributeName = tag.getString("AttributeName");
                    String name = tag.getString("Name");
                    String slot = tag.getString("Slot");
                    int operation = tag.getInt("Operation");
                    double amount = tag.getDouble("Amount");
                    UUID uuid = Util.decodeUUID(tag.getIntArray("UUID"));

                    item.attributeModifiers.add(new AttributeModifier(attributeName, name, slot, operation, amount, uuid));
                }
            }

            // Potions
            if (minecraftTag.containsKey("CustomPotionEffects")) {
                ListTag<?> customPotionEffects = minecraftTag.getListTag("CustomPotionEffects");
                item.customPotionEffects = new ArrayList<>();

                @SuppressWarnings("unchecked")
                ListTag<CompoundTag> compoundTags = (ListTag<CompoundTag>) customPotionEffects;

                for (CompoundTag tag : compoundTags) {
                    byte id = tag.getByte("Id");
                    byte amplifier = tag.getByte("Amplifier");
                    int duration = tag.getInt("Duration");
                    byte ambient = tag.getByte("Ambient");
                    byte showParticles = tag.getByte("ShowParticles");
                    byte showIcon = tag.getByte("ShowIcon");

                    item.customPotionEffects.add(new CustomPotionEffect(id, amplifier, duration, ambient, showParticles, showIcon));
                }
            }

            if (minecraftTag.containsKey("Potion")) {
                item.potion = minecraftTag.getString("Potion");
            }

            if (minecraftTag.containsKey("CustomPotionColor")) {
                item.customPotionColor = minecraftTag.getInt("CustomPotionColor");
            }

            // Crossbow
            if (minecraftTag.containsKey("ChargedProjectiles")) {
                ListTag<?> chargedProjectiles = minecraftTag.getListTag("ChargedProjectiles");
                item.chargedProjectiles = new ArrayList<>();

                @SuppressWarnings("unchecked")
                ListTag<CompoundTag> compoundTags = (ListTag<CompoundTag>) chargedProjectiles;

                for (CompoundTag tag : compoundTags) {
                    item.chargedProjectiles.add(tag);
                }
            }

            if (minecraftTag.containsKey("Charged")) {
                item.charged = minecraftTag.getByte("Charged");
            }

            // Written Books
            if (minecraftTag.containsKey("resolved")) {
                item.resolved = minecraftTag.getByte("resolved");
            }

            if (minecraftTag.containsKey("generation")) {
                item.generation = minecraftTag.getInt("generation");
            }

            if (minecraftTag.containsKey("author")) {
                item.author = minecraftTag.getString("author");
            }

            if (minecraftTag.containsKey("title")) {
                item.title = minecraftTag.getString("title");
            }

            if (minecraftTag.containsKey("pages")) {
                ListTag<?> pages = minecraftTag.getListTag("pages");
                item.pages = new ArrayList<>();

                // Translating NBT into JSON components.
                @SuppressWarnings("unchecked")
                ListTag<StringTag> stringTags = (ListTag<StringTag>) pages;

                for (StringTag stringTag : stringTags) {
                    String value = stringTag.getValue();
                    BaseComponent[] parse = ComponentSerializer.parse(value);
                    item.pages.add(new TextComponent(parse));
                }
            }

            // Player Heads
            if (minecraftTag.containsKey("SkullOwner")) {
                CompoundTag skullOwner = minecraftTag.getCompoundTag("SkullOwner");

                UUID uuid = null;
                String ownerName = null;
                CompoundTag properties = null;
                List<SkullTexture> skullTextureList = new ArrayList<>();

                if (skullOwner.containsKey("Id")) {
                    uuid = Util.decodeUUID(skullOwner.getIntArray("Id"));
                }
                if (skullOwner.containsKey("Name")) {
                    ownerName = skullOwner.getString("Name");
                }
                if (skullOwner.containsKey("Properties")) {
                    properties = skullOwner.getCompoundTag("Properties");
                }

                if (properties != null) {
                    if (properties.containsKey("textures")) {
                        ListTag<?> textures = minecraftTag.getListTag("textures");

                        @SuppressWarnings("unchecked")
                        ListTag<CompoundTag> compoundTags = (ListTag<CompoundTag>) textures;

                        for (CompoundTag tag : compoundTags) {
                            String signature = "";
                            String encodedValue = "";

                            if (tag.containsKey("Signature")) {
                                signature = tag.getString("Signature");
                            }
                            if (tag.containsKey("Value")) {
                                encodedValue = tag.getString("Value");
                            }

                            skullTextureList.add(new SkullTexture(signature, encodedValue));
                        }
                    }
                }

                item.skullMeta = new SkullMeta(uuid, ownerName, skullTextureList);
            }


            // Fireworks
            if (minecraftTag.containsKey("Explosion")) {
                CompoundTag explosion = minecraftTag.getCompoundTag("Explosion");
                item.fireworkExplosion = decodeFireworkExplosion(explosion);
            }
            if (minecraftTag.containsKey("Fireworks")) {
                CompoundTag fireworks = minecraftTag.getCompoundTag("Fireworks");
                byte flight = 0;
                List<FireworkExplosion> fireworkExplosions = new ArrayList<>();

                if (fireworks.containsKey("Flight")) {
                    flight = fireworks.getByte("Flight");
                }
                if (fireworks.containsKey("Explosions")) {
                    ListTag<?> explosions = minecraftTag.getListTag("Explosions");

                    @SuppressWarnings("unchecked")
                    ListTag<CompoundTag> compoundTags = (ListTag<CompoundTag>) explosions;
                    for (CompoundTag tag : compoundTags) {
                        fireworkExplosions.add(decodeFireworkExplosion(tag));
                    }

                }
                item.fireworks = new Firework(flight, fireworkExplosions);
            }

            //TODO rest of item NBTs

        }

        return item;
    }

    private static FireworkExplosion decodeFireworkExplosion(CompoundTag explosion) {
        byte flicker = 0;
        byte trail = 0;
        int[] colors = new int[] {};
        int[] fadeColors = new int[] {};

        if (explosion.containsKey("Flicker")) {
            flicker = explosion.getByte("Flicker");
        }
        if (explosion.containsKey("Trail")) {
            trail = explosion.getByte("Trail");
        }
        if (explosion.containsKey("Colors")) {
            colors = explosion.getIntArray("Colors");
        }
        if (explosion.containsKey("FadeColors")) {
            fadeColors = explosion.getIntArray("FadeColors");
        }

        return new FireworkExplosion(flicker, trail, colors, fadeColors);
    }

    public static CompoundTag encode(Item item) {
        CompoundTag tag = new CompoundTag();



        return tag;
    }
}
