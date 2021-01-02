package me.tecc.hypercode.templates.item;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import me.tecc.hypercode.templates.item.meta.AttributeModifier;
import me.tecc.hypercode.templates.item.meta.CustomPotionEffect;
import me.tecc.hypercode.templates.item.meta.Enchantment;
import me.tecc.hypercode.utils.IJsonModel;
import net.md_5.bungee.api.chat.TextComponent;
import net.querz.nbt.io.NamedTag;
import net.querz.nbt.tag.CompoundTag;

import java.util.List;

/**
 * Wrapper for Items from the DiamondFire templates format.
 */
public class Item implements IJsonModel<Item>, IItem {

    NamedTag namedTag;
    String minecraftId;
    byte minecraftCount;
    CompoundTag minecraftTag;
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

    @Override
    public JsonObject toJson(Item value) {

        return null;
    }

    public static Item fromJson(String json) {
        JsonElement element = JsonParser.parseString(json);
        System.out.println(element);
        return null;
    }
}
