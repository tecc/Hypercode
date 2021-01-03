package me.tecc.hypercode.templates.item.meta;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Base64;

public class SkullTexture {
    String signature;
    String encodedValue;
    JsonObject textureJSon;

    public SkullTexture(String signature, String encodedValue) {
        this.signature = signature;
        this.encodedValue = encodedValue;

        // Initial: Decoding encoded string to JSON texture.
        this.initialParse();
    }

    private void initialParse() {
        if (encodedValue != null && !encodedValue.isEmpty()){
            try {
                // Decoding the encoded texture.
                byte[] bytes = Base64.getDecoder().decode(encodedValue);
                JsonElement jsonElement = JsonParser.parseString(new String(bytes));
                this.textureJSon = jsonElement.getAsJsonObject();

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}
