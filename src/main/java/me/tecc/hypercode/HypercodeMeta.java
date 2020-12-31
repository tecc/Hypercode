package me.tecc.hypercode;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public interface HypercodeMeta {
    String version();
    String hypercubeVersion();

    static HypercodeMeta load() throws IOException {
        InputStream resource = Hypercode.class.getClassLoader().getResourceAsStream("hm.json");
        if (resource == null) {
            throw new IOException("Resource is null!");
        }
        JsonObject obj = JsonParser.parseReader(
                new InputStreamReader(resource)
        ).getAsJsonObject();

        return new HypercodeMeta() {
            @Override
            public String version() {
                return obj.get("version").getAsString();
            }

            @Override
            public String hypercubeVersion() {
                return obj.get("hypercubeVersion").getAsString();
            }
        };
    }
}
