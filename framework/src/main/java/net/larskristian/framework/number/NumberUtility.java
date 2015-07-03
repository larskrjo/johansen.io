package net.larskristian.framework.number;

import java.util.UUID;

/**
 * @author Lars K. Johansen
 */
public final class NumberUtility {

    private NumberUtility() {
        // Utility class
    }

    public static String getUUID() {
        return UUID.randomUUID().toString();
    }
}
