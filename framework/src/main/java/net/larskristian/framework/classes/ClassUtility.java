package net.larskristian.framework.classes;

import java.lang.reflect.ParameterizedType;

/**
 * @author Lars K. Johansen
 */
public final class ClassUtility {

    private ClassUtility() {
        // Utility class
    }

    public static Class getGenericClass(Object o) {
        ParameterizedType parameterizedType = (ParameterizedType) o.getClass().getGenericSuperclass();
        return (Class) parameterizedType.getActualTypeArguments()[0];
    }

}
