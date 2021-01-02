package me.tecc.hypercode.templates.item;

import me.tecc.hypercode.templates.item.meta.AttributeModifier;
import me.tecc.hypercode.templates.item.meta.CustomPotionEffect;
import me.tecc.hypercode.templates.item.meta.Enchantment;
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

    public Item() {
        this.namedTag = null;

        this.minecraftId =  null;
        this.minecraftCount = -1;
        this.minecraftTag = new CompoundTag();
        this.hexColor = -1;
        this.itemName = null;
        this.itemLore = new ArrayList<>();
        this.hideflags = -1;
        this.itemDamage = -1;
        this.itemUnbreakabke = -1;
        this.itemCanDestroy = new ArrayList<>();
        this.itemCustomModelData = -1;
        this.itemCanPlaceOn = new ArrayList<>();
        this.enchantments = new ArrayList<>();
        this.storedEnchantments = new ArrayList<>();
        this.repairCost = -1;
        this.attributeModifiers = new ArrayList<>();
        this.customPotionEffects = new ArrayList<>();
        this.potion = null;
        this.customPotionColor = -1;
    }

}
