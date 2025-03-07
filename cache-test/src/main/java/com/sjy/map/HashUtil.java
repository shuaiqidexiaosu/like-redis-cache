package com.sjy.map;

public class HashUtil {

    private HashUtil() {
    }

    public static int hash(Object object) {
        if (object == null) {
            return 0;
        }
        return object.hashCode();
    }


    public static int indexFor(int h, int length) {
        return h & (length - 1);
    }
}
