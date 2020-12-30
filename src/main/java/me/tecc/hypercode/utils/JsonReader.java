package me.tecc.hypercode.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Provides a decent way of reading JSON objects.
 */
public class JsonReader {
    JsonObject json;

    public JsonReader(JsonObject json) {
        this.json = json;
    }

    public String readString(String key, String defaultValue) {
        return containsKey(key) ? json.get(key).getAsString() : defaultValue;
    }

    public int readInteger(String key, int defaultValue) {
        return containsKey(key) ? json.get(key).getAsInt() : defaultValue;
    }

    public JsonArray readArray(String key, JsonArray defaultValue) {
        return containsKey(key) ? json.get(key).getAsJsonArray() : defaultValue;
    }

    public boolean containsKey(String key) {
        return json.has(key);
    }

}
