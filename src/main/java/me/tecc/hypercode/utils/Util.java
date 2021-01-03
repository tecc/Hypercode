package me.tecc.hypercode.utils;

import net.querz.nbt.io.NBTDeserializer;
import net.querz.nbt.io.NamedTag;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.UUID;

public class Util {
    static final NBTDeserializer NBT_DESERIALIZER = new NBTDeserializer(false);

    public static String escapeNBT(String nbt) {
        return nbt.replace("\"", "\\\"");
    }

    public static NamedTag deserialize(String nbt) throws IOException {
        ByteArrayInputStream array = new ByteArrayInputStream(nbt.getBytes());
        return NBT_DESERIALIZER.fromStream(array);
    }

    public static UUID decodeUUID(int[] ints) {
        if (ints.length < 4) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0, intsLength = ints.length; i < intsLength; i++) {
            int anInt = ints[i];
            String s = Integer.toHexString(anInt);
            stringBuilder.append(s);
            if (i != 3) {
                stringBuilder.append("-");
            }
        }
        return UUID.fromString(stringBuilder.toString());
    }

    public static int[] encodeUUID(UUID uuid) {
        String[] hexArray = uuid.toString().split("-");
        int[] uuidBytes = new int[4];
        for (int i = 0, hexArrayLength = hexArray.length; i < hexArrayLength; i++) {
            String hex = hexArray[i];
            Integer decodedInteger = Integer.decode(hex);
            uuidBytes[i] = decodedInteger;
        }
        return uuidBytes;
    }
}
