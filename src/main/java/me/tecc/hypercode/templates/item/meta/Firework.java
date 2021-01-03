package me.tecc.hypercode.templates.item.meta;

import java.util.List;

public class Firework {
    byte flight;
    List<FireworkExplosion> fireworkExplosions;

    public Firework(byte flight, List<FireworkExplosion> fireworkExplosions) {

        this.flight = flight;
        this.fireworkExplosions = fireworkExplosions;
    }
}
