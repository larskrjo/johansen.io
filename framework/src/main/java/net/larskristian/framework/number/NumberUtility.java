package net.larskristian.framework.number;

import net.larskristian.framework.exception.ExceptionMessages;
import net.larskristian.framework.exception.type.number.NumberException;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
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

    public static Set<Integer> getRandomIntegers(int number, int min, int max) {
        if (number <= 0) {
            return new HashSet<Integer>();
        }
        if (max - min + 1 < number) {
            throw new NumberException(ExceptionMessages.MESSAGE_NUMBER_RESULT_NOT_POSSIBLE);
        }
        Set<Integer> integers = new HashSet<Integer>();
        for (int i = 0; i < number; i++) {
            Integer randomInteger = getRandomInteger(min, max);
            if (integers.contains(randomInteger)) {
                --i;
                continue;
            }
            integers.add(randomInteger);
        }
        return integers;
    }

    public static Integer getRandomInteger(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }
}
