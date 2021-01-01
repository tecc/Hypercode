package me.tecc.hypercode.templates.variables;

import com.google.gson.JsonObject;

public class Location extends Var{

    private double x;
    private double y;
    private double z;
    private double pitch;
    private double yaw;
    private JsonObject LocationObject;
    private JsonObject Object;


    //NOTE: If isBlock gets used this will be deprecated
    public Location(double x, double y, double z, double pitch, double yaw) {
        LocationObject = new JsonObject();
        LocationObject.addProperty("x",x);
        LocationObject.addProperty("y",y);
        LocationObject.addProperty("z",z);
        LocationObject.addProperty("pitch",pitch);
        LocationObject.addProperty("yaw",yaw);

        data = new JsonObject();
        data.add("loc",LocationObject);
        data.addProperty("isBlock",false);

        Object = this.buildVar("loc",data);

    }

    //NOTE: If isBlock gets used this will be deprecated
    public Location(double x, double y, double z){
        LocationObject = new JsonObject();
        LocationObject.addProperty("x",x);
        LocationObject.addProperty("y",y);
        LocationObject.addProperty("z",z);
        LocationObject.addProperty("pitch",0.0);
        LocationObject.addProperty("yaw",0.0);

        data = new JsonObject();
        data.add("loc",LocationObject);
        data.addProperty("isBlock",false);

        Object = this.buildVar("loc",data);
    }

    public static JsonObject getRawLocationData(Location location) {
        return location.data;
    }

    public static JsonObject getRawLocationObjectFull(Location location) {
        return location.Object;
    }

    public static JsonObject getRawLocationObject(Location location){
        return location.LocationObject;
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
}
