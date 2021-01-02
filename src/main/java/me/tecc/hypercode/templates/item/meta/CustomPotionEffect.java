package me.tecc.hypercode.templates.item.meta;

public class CustomPotionEffect {
    byte id;
    byte amplifier;
    int duration;
    byte ambient;
    byte showParticles;
    byte showIcon;

    public CustomPotionEffect(byte id, byte amplifier, int duration, byte ambient, byte showParticles, byte showIcon) {

        this.id = id;
        this.amplifier = amplifier;
        this.duration = duration;
        this.ambient = ambient;
        this.showParticles = showParticles;
        this.showIcon = showIcon;
    }
}
