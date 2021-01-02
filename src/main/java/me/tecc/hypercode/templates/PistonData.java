package me.tecc.hypercode.templates;

import me.tecc.hypercode.templates.reference.PistonDirection;
import me.tecc.hypercode.templates.reference.PistonType;

public class PistonData {
    private final PistonType type;
    private final PistonDirection dir;

    public PistonData(PistonType type, PistonDirection dir) {
        this.type = type;
        this.dir = dir;
    }

    public PistonType getType() {
        return type == null ? PistonType.NULL : type;
    }

    public PistonDirection getDir() {
        return dir == null ? PistonDirection.NULL : dir;
    }
}
