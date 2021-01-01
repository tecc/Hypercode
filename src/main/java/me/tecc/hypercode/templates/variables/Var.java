package me.tecc.hypercode.templates.variables;

import com.google.gson.JsonObject;

public class Var {
    private String id;
    protected JsonObject data;
    private JsonObject data2;

    public JsonObject buildVar(String id, JsonObject data) {
        JsonObject variable = new JsonObject();
        variable.addProperty("id", id);
        variable.add("data", data);

        return variable;
    }


    public JsonObject buildVar(String id, JsonObject data, JsonObject data2) {
        JsonObject variable = new JsonObject();
        variable.addProperty("id", id);
        variable.add("data", data);
        variable.add("data", data2);

        return variable;
    }

}
