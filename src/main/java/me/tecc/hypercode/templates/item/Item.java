package me.tecc.hypercode.templates.item;

import me.tecc.hypercode.templates.item.meta.*;
import net.md_5.bungee.api.chat.TextComponent;
import net.querz.nbt.io.NamedTag;
import net.querz.nbt.tag.CompoundTag;

import java.util.ArrayList;
import java.util.List;

/**
 * Wrapper for Items from the DiamondFire templates format.
 */
public class Item implements IItem {
    NamedTag namedTag;

    // Generic data
    String minecraftId;
    byte minecraftCount;
    CompoundTag minecraftTag; // Deep NBT data.

    // Display & structure
    int hexColor;
    int mapColor; // Map color
    TextComponent itemName;
    List<TextComponent> itemLore;
    int hideflags;
    int itemDamage;
    byte itemUnbreakabke;
    List<String> itemCanDestroy;
    int itemCustomModelData;

    // Enchantments & CanPlaceOn
    List<String> itemCanPlaceOn;
    List<Enchantment> enchantments;
    List<Enchantment> storedEnchantments;
    int repairCost;

    // Potions
    List<AttributeModifier> attributeModifiers;
    List<CustomPotionEffect> customPotionEffects;
    String potion;
    int customPotionColor;

    // Crossbow
    List<CompoundTag> chargedProjectiles;
    byte charged;

    // Written books
    byte resolved;
    int generation;
    String author;
    String title;
    List<TextComponent> pages;

    // Player skull
    SkullMeta skullMeta;

    // Fireworks
    FireworkExplosion fireworkExplosion;
    Firework fireworks;

    // Entity
    CompoundTag entityTag;

    // Fish
    int bucketVariantTag;

    // Maps
    String map;
    String mapScaleDirection;
    List<MapDecoration> mapDecorations;

    // Stew
    List<StewEffect> stewEffects;

    // Debug stick
    DebugProperty debugProperty;

    // Compass
    byte lodestoneTracked;
    String lodestoneDimension;
    Compass compass;

    // Bundle
    List<Item> items;

    public Item() {
        this.namedTag = null;

        this.minecraftId =  null;
        this.minecraftCount = 0;
        this.minecraftTag = null;
        this.hexColor = 0;
        this.itemName = null;
        this.itemLore = new ArrayList<>();
        this.hideflags = 0;
        this.itemDamage = 0;
        this.itemUnbreakabke = 0;
        this.itemCanDestroy = new ArrayList<>();
        this.itemCustomModelData = 0;
        this.itemCanPlaceOn = new ArrayList<>();
        this.enchantments = new ArrayList<>();
        this.storedEnchantments = new ArrayList<>();
        this.repairCost = 0;
        this.attributeModifiers = new ArrayList<>();
        this.customPotionEffects = new ArrayList<>();
        this.potion = null;
        this.customPotionColor = 0;
        this.chargedProjectiles = new ArrayList<>();
        this.charged = 0;
        this.resolved = 0;
        this.generation = 0;
        this.author = null;
        this.title = null;
        this.pages = new ArrayList<>();
        this.skullMeta = null;
        this.fireworkExplosion = null;
        this.fireworks = null;
        this.entityTag = null;
        this.bucketVariantTag = 0;
        this.map = null;
        this.mapScaleDirection = null;
        this.mapDecorations = new ArrayList<>();
        this.stewEffects = new ArrayList<>();
        this.debugProperty = null;
        this.lodestoneTracked = 0;
        this.lodestoneDimension = null;
        this.compass = null;
        this.items = new ArrayList<>();
    }

}
