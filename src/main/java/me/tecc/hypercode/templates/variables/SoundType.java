package me.tecc.hypercode.templates.variables;

public enum SoundType {
    WITHERAMBIENT("Wither Ambient", "entity.wither.ambient"),
    WITHERBREAKBLOCK("Wither Break Block","entity.wither.break_block"),
    WITHERDEATH("Wither Death","entity.wither.death"),
    WITHERHURT("Wither Hurt","entity.wither.hurt"),
    WITHERSHOOT("Wither Shoot","entity.wither.shoot"),
    WITHERSPAWN("Wither Spawn","entity.wither.spawn"),
    WITHERSKELETONAMBIENT("Wither Skeleton Ambient","entity.wither_skeleton.ambient"),
    WITHERSKELETONDEATH("Wither Skeleton Death","entity.wither_skeleton.death"),
    WITHERSKELETONHURT("Wither Skeleton Hurt","entity.wither_skeleton.hurt"),
    WITHERSKELETONSTEP("Wither Skeleton Step","entity.wither_skeleton.step");

    //TODO: ADD ALL SOUNDS PLS/THNX





    private String hypercubeid;
    private String mcid;

    SoundType(String hypercubeid, String mcid) {
        this.hypercubeid = hypercubeid;
        this.mcid = mcid;
    }

    public String getHypercubeid() {
        return hypercubeid;
    }

    public String getMCID() {
        return mcid;
    }
}
