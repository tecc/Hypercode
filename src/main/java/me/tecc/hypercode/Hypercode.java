package me.tecc.hypercode;

import com.google.gson.JsonObject;
import me.tecc.hypercode.templates.TemplateCoder;

public class Hypercode {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Requires arguments");
            return;
        }
        System.out.println("Decoding...");
        JsonObject j = TemplateCoder.decode(args[0]);
        assert j != null : "Something went wrong during decoding";
        System.out.println(j.toString());
    }
}
