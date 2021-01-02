package me.tecc.hypercode.templates.variables;

import com.google.gson.JsonObject;

public class Text extends Var {

    private String text;
    private JsonObject object;


    /**
     * The Text variable for Hypercube
     *
     * @param text the text data for the Var
     */
    public Text(String text) {

        data = new JsonObject();
        object = new JsonObject();

        data.addProperty("name", text);
        object = this.buildVar("txt", data);
    }

    /**
     * Get the raw Json data for the text variable
     *
     * @param text the text to get
     * @return Returns the raw data
     */
    public static JsonObject getRawTextData(Text text) {
        return text.data;
    }

    /**
     * Get the raw Json <b1>Object</b1> for the text variable
     *
     * @param text the text to get
     * @return Returns the raw object
     */
    public static JsonObject getRawTextObject(Text text) {
        return text.object;
    }

}
