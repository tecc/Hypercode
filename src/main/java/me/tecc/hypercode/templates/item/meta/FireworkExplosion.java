package me.tecc.hypercode.templates.item.meta;

public class FireworkExplosion {
    byte flicker;
    byte trail;
    int[] colors;
    int[] fadeColors;

    public FireworkExplosion(byte flicker, byte trail, int[] colors, int[] fadeColors) {

        this.flicker = flicker;
        this.trail = trail;
        this.colors = colors;
        this.fadeColors = fadeColors;
    }
}
