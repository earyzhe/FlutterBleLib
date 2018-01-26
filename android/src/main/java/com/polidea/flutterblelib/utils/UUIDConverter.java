package com.polidea.flutterblelib.utils;

import java.util.UUID;

public class UUIDConverter {

    private static String baseUUIDPrefix = "0000";
    private static String baseUUIDSuffix = "-0000-1000-8000-00805F9B34FB";

    public static UUID convert(String sUUID) {
        if (sUUID.length() == 4) {
            sUUID = baseUUIDPrefix + sUUID + baseUUIDSuffix;
        } else if (sUUID.length() == 8) {
            sUUID = sUUID + baseUUIDSuffix;
        }
        try {
            return UUID.fromString(sUUID);
        } catch (Throwable e) {
            return null;
        }
    }

    public static UUID[] convert(String... sUUIDs) {
        UUID[] UUIDs = new UUID[sUUIDs.length];
        for (int i = 0; i < sUUIDs.length; i++) {
            try {
                if (sUUIDs[i].length() == 4) {
                    sUUIDs[i] = baseUUIDPrefix + sUUIDs[i] + baseUUIDSuffix;
                } else if (sUUIDs[i].length() == 8) {
                    sUUIDs[i] = sUUIDs[i] + baseUUIDSuffix;
                }
                UUIDs[i] = UUID.fromString(sUUIDs[i]);
            } catch (Throwable e) {
                return null;
            }
        }
        return UUIDs;
    }


    public static String fromUUID(UUID uuid) {
        return uuid.toString().toLowerCase();
    }
}