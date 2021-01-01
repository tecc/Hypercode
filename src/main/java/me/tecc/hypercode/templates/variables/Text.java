package me.tecc.hypercode.templates.variables;

import com.google.gson.JsonObject;

public class Text extends Var {

    private String text;
    private JsonObject object;

    public Text(String text) {

        data = new JsonObject();
        object = new JsonObject();

        data.addProperty("name", text);
        object = this.buildVar("txt", data);
    }

    public static JsonObject getRawTextData(Text text) {
        return text.data;
    }

    public static JsonObject getRawTextObject(Text text) {
        return text.object;
    }

}
