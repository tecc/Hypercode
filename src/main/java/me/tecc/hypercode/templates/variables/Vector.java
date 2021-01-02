package me.tecc.hypercode.templates.variables;

import com.google.gson.JsonObject;

public class Vector extends Var {

    private double x;
    private double y;
    private double z;
    private JsonObject Object;

    public Vector(double x, double y, double z) {

        data = new JsonObject();
        data.addProperty("data",x);
        data.addProperty("data",y);
        data.addProperty("data",z);

        Object = this.buildVar("vec",data);

    }

    public static JsonObject getRawVectorData(Vector vector) {
        return vector.data;
    }

    public static JsonObject getRawVectorObject(Vector vector) {
        return vector.Object;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public static Location toLocation(Vector vector) {

        return new Location(vector.getX(), vector.getY(), vector.getZ());
    }
}
