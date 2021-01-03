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

    String minecraftId;
    byte minecraftCount;
    CompoundTag minecraftTag; // Deep NBT data.
    int hexColor;
    TextComponent itemName;
    List<TextComponent> itemLore;
    int hideflags;
    int itemDamage;
    byte itemUnbreakabke;
    List<String> itemCanDestroy;
    int itemCustomModelData;

    List<String> itemCanPlaceOn;
    List<Enchantment> enchantments;
    List<Enchantment> storedEnchantments;
    int repairCost;

    List<AttributeModifier> attributeModifiers;
    List<CustomPotionEffect> customPotionEffects;
    String potion;
    int customPotionColor;

    List<CompoundTag> chargedProjectiles;
    byte charged;

    byte resolved;
    int generation;
    String author;
    String title;
    List<TextComponent> pages;

    SkullMeta skullMeta;

    FireworkExplosion fireworkExplosion;
    Firework fireworks;

    CompoundTag entityTag;

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
    }

}
