package me.tecc.hypercode.templates;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import me.tecc.hypercode.templates.item.Item;
import me.tecc.hypercode.templates.item.ItemBuilder;
import me.tecc.hypercode.utils.JsonReader;

import java.util.ArrayList;
import java.util.List;

public class CodeBlockChest {
    private final List<Item> items;

    public CodeBlockChest(JsonObject args) {
        this.items = new ArrayList<>();

        // Starting to read the JSON safely.
        JsonReader json = new JsonReader(args);
        JsonArray array = json.readArray("items", new JsonArray());

        // Searching for all items.
        for (JsonElement jsonElement : array) {
            if (jsonElement instanceof JsonObject) {
                JsonObject itemJson = jsonElement.getAsJsonObject();

                // Parsing the item.
                Item item = this.parseItem(itemJson);
                if (item != null) {
                    this.items.add(item);
                }
            }
        }
    }

    private Item parseItem(JsonObject jsonObject) {
        // Safe reader.
        JsonReader json = new JsonReader(jsonObject);
        JsonObject itemJson = json.readObject("item", new JsonObject());
        long slot = json.readNumber("slot", 0);

        // Creating item.
        return new ItemBuilder(itemJson, slot).build();
    }

    public List<Item> getItems() {
        return items;
    }
}
