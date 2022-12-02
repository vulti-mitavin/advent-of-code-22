package ch.grassl.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Util {

    public static boolean isEmpty(String value) {
        return value == null || value.length() == 0;
    }
}
