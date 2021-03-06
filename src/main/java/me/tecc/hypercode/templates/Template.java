package me.tecc.hypercode.templates;

import com.google.gson.JsonObject;

/**
 * Wrapper class for Hypercube templates
 */
public class Template implements Cloneable {
    final JsonObject data;

    /**
     * The template for Hypercube
     *
     * @param data The NBT Data for the Template
     */
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
