package me.tecc.hypercode.templates;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Template encoder/decoder.
 */
public class TemplateCoder {

    /**
     * Encodes a template.
     *
     * @param template The template to encode.
     * @return The encoded template as a string.
     */
    public static String encode(JsonObject template) {
        try {
            // writes gzipped template to a byte array output stream
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            GZIPOutputStream gz = new GZIPOutputStream(byteOut);
            gz.write(template.toString().getBytes());

            // read from the output stream
            byte[] bytes = byteOut.toByteArray();
            return new String(Base64.getEncoder().encode(bytes));
        } catch (IOException e) {
            System.out.println("Couldn't encode template, printing stack trace.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Decodes an encoded Hypercube template to a {@link Template}.
     *
     * @param encoded The encoded string to be decoded
     * @return The decoded template.
     */
    public static JsonObject decode(String encoded) {
        byte[] bytes = Base64.getDecoder().decode(encoded);
        try {
            // read the gzipped data from byte array
            ByteArrayInputStream byteIn = new ByteArrayInputStream(bytes);
            GZIPInputStream gz = new GZIPInputStream(byteIn);
            String json = IOUtils.toString(gz, StandardCharsets.UTF_8);

            // json parsing
            JsonElement jsonElement = JsonParser.parseString(json);
            return jsonElement.getAsJsonObject();
        } catch (IOException e) {
            System.out.println("Couldn't decode template, printing stack trace.");
            e.printStackTrace();
            return null;
        }
    }
}
