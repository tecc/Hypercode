package me.tecc.hypercode.templates.variables;

import com.google.gson.JsonObject;

public class Number extends Var {

    private String number;
    private JsonObject object;

    public Number(String number) {

        data = new JsonObject();
        object = new JsonObject();

        data.addProperty("name", number);
        object = this.buildVar("num", data);

        long num = Long.parseLong(number);
        // sorry, but no redundant code
        // quality code only
        // This is the quality code ZONE
    }

    public static JsonObject getRawNumberData(Number number) {
        return number.data;
    }

    public static JsonObject getRawNumberObject(Number number) {
        return number.object;
    }

}
