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

            item.itemDamage = minecraftTag.getInt("Damage");
            item.itemUnbreakabke = minecraftTag.getByte("Unbreakable");

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

            item.itemCustomModelData = minecraftTag.getInt("CustomModelData");

            // Display NBT.
            if (minecraftTag.containsKey("display")) {
                CompoundTag display = minecraftTag.getCompoundTag("display");

                // Hex color.
                item.hexColor = display.getInt("color");
                item.mapColor = display.getInt("MapColor");

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
            item.hideflags = minecraftTag.getInt("HideFlags");

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

            item.repairCost = minecraftTag.getInt("RepairCost");

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

            item.potion = minecraftTag.getString("Potion");
            item.customPotionColor = minecraftTag.getInt("CustomPotionColor");

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

            item.charged = minecraftTag.getByte("Charged");

            // Written Books
            item.resolved = minecraftTag.getByte("resolved");
            item.generation = minecraftTag.getInt("generation");
            item.author = minecraftTag.getString("author");
            item.title = minecraftTag.getString("title");


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

                UUID uuid = Util.decodeUUID(skullOwner.getIntArray("Id"));
                String ownerName = skullOwner.getString("Name");

                CompoundTag properties = null;
                List<SkullTexture> skullTextureList = new ArrayList<>();

                if (skullOwner.containsKey("Properties")) {
                    properties = skullOwner.getCompoundTag("Properties");
                }

                if (properties != null) {
                    if (properties.containsKey("textures")) {
                        ListTag<?> textures = minecraftTag.getListTag("textures");

                        @SuppressWarnings("unchecked")
                        ListTag<CompoundTag> compoundTags = (ListTag<CompoundTag>) textures;

                        for (CompoundTag tag : compoundTags) {
                            String signature = tag.getString("Signature");
                            String encodedValue = tag.getString("Value");
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
                byte flight = fireworks.getByte("Flight");
                List<FireworkExplosion> fireworkExplosions = new ArrayList<>();

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

            // Entity Tag
            if (minecraftTag.containsKey("EntityTag")) {
                item.entityTag = minecraftTag.getCompoundTag("EntityTag");
            }

            // Bucket of Fish
            item.bucketVariantTag = minecraftTag.getInt("BucketVariantTag");

            // Maps
            item.map = minecraftTag.getString("map");
            item.mapScaleDirection = minecraftTag.getString("map_scale_direction");

            // Map decorations
            if (minecraftTag.containsKey("Decorations")) {
                ListTag<?> decorations = minecraftTag.getListTag("Decorations");
                item.mapDecorations = new ArrayList<>();

                @SuppressWarnings("unchecked")
                ListTag<CompoundTag> compoundTags = (ListTag<CompoundTag>) decorations;
                for (CompoundTag tag : compoundTags) {
                    String id = tag.getString("id");
                    byte type = tag.getByte("type");
                    double x = tag.getDouble("x");
                    double z = tag.getDouble("z");
                    double rot = tag.getDouble("rot");

                    item.mapDecorations.add(new MapDecoration(id, type, x, z, rot));
                }
            }

            // Suspicious Stew
            if (minecraftTag.containsKey("Effects")) {
                ListTag<?> effects = minecraftTag.getListTag("Effects");
                item.stewEffects = new ArrayList<>();

                @SuppressWarnings("unchecked")
                ListTag<CompoundTag> compoundTags = (ListTag<CompoundTag>) effects;
                for (CompoundTag tag : compoundTags) {
                    byte effectId = tag.getByte("EffectId");
                    int effectDuration = tag.getInt("EffectDuration");
                    item.stewEffects.add(new StewEffect(effectId, effectDuration));
                }
            }

            // Debug Sticks
            if (minecraftTag.containsKey("DebugProperty")) {
                CompoundTag debugProperty = minecraftTag.getCompoundTag("DebugProperty");
                String blockId = debugProperty.getString("BlockId");
                item.debugProperty = new DebugProperty(debugProperty, blockId);
            }

            // Compass
            item.lodestoneTracked = minecraftTag.getByte("LodestoneTracked");
            item.lodestoneDimension = minecraftTag.getString("LodestoneDimension");

            if (minecraftTag.containsKey("LodestonePos")) {
                CompoundTag lodestonePos = minecraftTag.getCompoundTag("LodestonePos");
                int x = lodestonePos.getInt("x");
                int y = lodestonePos.getInt("y");
                int z = lodestonePos.getInt("z");

                item.compass = new Compass(x, y, z);
            }

            // Bundles
            if (minecraftTag.containsKey("Items")) {
                ListTag<?> items = minecraftTag.getListTag("Items");
                item.items = new ArrayList<>();

                @SuppressWarnings("unchecked")
                ListTag<CompoundTag> compoundTags = (ListTag<CompoundTag>) items;
                for (CompoundTag tag : compoundTags) {
                    item.items.add(ItemCoder.decode(tag));
                }
            }
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
        CompoundTag minecraftTag = item.minecraftTag;

        //TODO Extra encoders

        return minecraftTag;
    }
}
