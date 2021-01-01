package me.tecc.hypercode.utils;

public class Util {
    public String escapeNBT(String nbt) {
        return nbt.replace("\"", "\\\"");
    }
}
