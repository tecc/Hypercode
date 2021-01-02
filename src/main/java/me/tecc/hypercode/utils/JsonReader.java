package me.tecc.hypercode.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Provides a safer way of reading JSON objects.
 */
public class JsonReader {
    JsonObject json;

    public JsonReader(JsonObject json) {
        this.json = json;
    }

    public String readString(String key, String defaultValue) {
        return containsKey(key) ? json.get(key).getAsString() : defaultValue;
    }

    public long readNumber(String key, long defaultValue) {
        return containsKey(key) ? json.get(key).getAsLong() : defaultValue;
    }

    public JsonArray readArray(String key, JsonArray defaultValue) {
        return containsKey(key) ? json.get(key).getAsJsonArray() : defaultValue;
    }

    public JsonObject readObject(String key, JsonObject defaultValue) {
        return containsKey(key) ? json.get(key).getAsJsonObject() : defaultValue;
    }

    public boolean containsKey(String key) {
        return json.has(key);
    }

}
