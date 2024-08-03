package com.learning.ioc;

import javax.inject.Inject;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class SimpleIoCContainer {
    private Map<Class<?>, Class<?>> classMap = new HashMap<>();

    public void register(Class<?> baseClass, Class<?> implClass) {
        classMap.put(baseClass, implClass);
    }

    public <T> T resolve(Class<T> baseClass) {
        try {
            Class<?> implClass = classMap.get(baseClass);
            if (implClass == null) {
                implClass = baseClass;
            }
            Constructor<?>[] constructors = implClass.getConstructors();
            for (Constructor<?> constructor : constructors) {
                if (constructor.isAnnotationPresent(Inject.class)) {
                    Class<?>[] paramTypes = constructor.getParameterTypes();
                    Object[] params = new Object[paramTypes.length];
                    for (int i = 0; i < paramTypes.length; i++) {
                        params[i] = resolve(paramTypes[i]);
                    }
                    return (T) constructor.newInstance(params);
                }
            }
            return (T) implClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
