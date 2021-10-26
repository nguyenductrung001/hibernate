package utils;

import java.util.Collection;

public class ConnnectionUtils {
    public static boolean isEmpty(Collection collection) {
        return !ObjectUtil.isEmpty(collection) && collection.isEmpty();
    }
}
