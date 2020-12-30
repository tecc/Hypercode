package me.tecc.hypercode.utils;

import com.google.gson.JsonObject;

/**
 * Categorises objects that can be turn into JSON objects.
 * @param <T> The object type.
 */
public interface IJsonModel<T> {

    /**
     * Serializes the object to JSON format.
     * @param value The object to serialize.
     * @return The JSON object.
     */
    JsonObject toJson(T value);
}
