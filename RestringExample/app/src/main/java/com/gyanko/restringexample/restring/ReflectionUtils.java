package com.gyanko.restringexample.restring;

import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by chris on 17/12/14.
 * Copied from Calligraphy:
 * https://github.com/chrisjenx/Calligraphy/blob/master/calligraphy/src/main/java/uk/co/chrisjenx/calligraphy/ReflectionUtils.java
 */
class ReflectionUtils {

    private static final String TAG = ReflectionUtils.class.getSimpleName();

    static Field getField(Class clazz, String fieldName) {
        try {
            final Field f = clazz.getDeclaredField(fieldName);
            f.setAccessible(true);
            return f;
        } catch (NoSuchFieldException ignored) {
        }
        return null;
    }

    static Object getValue(Field field, Object obj) {
        try {
            return field.get(obj);
        } catch (IllegalAccessException ignored) {
        }
        return null;
    }

    static void setValue(Field field, Object obj, Object value) {
        try {
            field.set(obj, value);
        } catch (IllegalAccessException ignored) {
        }
    }

    static Method getMethod(Class clazz, String methodName) {
        final Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }

    static void invokeMethod(Object object, Method method, Object... args) {
        try {
            if (method == null) return;
            method.invoke(object, args);
        } catch (IllegalAccessException e) {
            Log.d(TAG, "Can't invoke method using reflection", e);
        } catch (InvocationTargetException e) {
            Log.d(TAG, "Can't invoke method using reflection", e);
        }
    }
}
