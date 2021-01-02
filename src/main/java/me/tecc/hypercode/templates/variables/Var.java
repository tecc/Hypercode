package me.tecc.hypercode.templates.variables;

import com.google.gson.JsonObject;

public class Var {
    private String id;
    protected JsonObject data;
    private JsonObject data2;

    /**
     * Used to create a new Variable type for Hypercode
     *
     * @param id the Hypercube Json id
     * @param data the Json data that is part of the Variable
     * @return Returns the new Variable as a JsonObject which can be compiled into a Hypercube template
     */
    public JsonObject buildVar(String id, JsonObject data) {
        JsonObject variable = new JsonObject();
        variable.addProperty("id", id);
        variable.add("data", data);

        return variable;
    }


    /**
     * Used to create a new Variable type for Hypercode
     *
     * @param id the Hypercube Json id
     * @param data the Json data that is part of the Variable
     * @param data2 the extra Json data that is part of the Variable
     * @return Returns the new Variable as a JsonObject which can be compiled into a Hypercube template
     */
    public JsonObject buildVar(String id, JsonObject data, JsonObject data2) {
        JsonObject variable = new JsonObject();
        variable.addProperty("id", id);
        variable.add("data", data);
        variable.add("data", data2);

        return variable;
    }

}
