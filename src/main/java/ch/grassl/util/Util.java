package ch.grassl.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Util {

    public static boolean isEmpty(String data) {
        return data == null || data.length() == 0;
    }
}
