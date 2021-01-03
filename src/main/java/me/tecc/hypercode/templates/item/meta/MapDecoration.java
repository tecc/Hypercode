package me.tecc.hypercode.templates.item.meta;

public class MapDecoration {

    String id;
    byte type;
    double x;
    double z;
    double rot;

    public MapDecoration(String id, byte type, double x, double z, double rot) {

        this.id = id;
        this.type = type;
        this.x = x;
        this.z = z;
        this.rot = rot;
    }
}
