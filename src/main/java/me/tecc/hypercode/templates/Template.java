package me.tecc.hypercode.templates;

import com.google.gson.JsonObject;

/**
 * Holds data about a singular template.
 */
public class Template implements Cloneable {
    final JsonObject data;

    public Template(JsonObject data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    @Override
    public Template clone() {
        return new Template(data.deepCopy());
    }

}
