package me.tecc.hypercode.templates.variables;

import com.google.gson.JsonObject;

public class Sound extends Var {

    private SoundType soundType;
    private double pitch;
    private double volume;
    private JsonObject Object;

    public Sound(SoundType soundType, double pitch, double volume) {
        data = new JsonObject();
        data.addProperty("sound",soundType.getHypercubeid());
        data.addProperty("pitch",pitch);
        data.addProperty("vol",volume);

        Object = this.buildVar("snd",data);
    }

    public static JsonObject getRawSoundData(Sound sound){
        return sound.data;
    }

    public static JsonObject getRawSoundObject(Sound sound){
        return sound.Object;
    }
}
