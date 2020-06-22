package org.example.common;

import org.example.module.dao.MultiThreadInsertProblemDao;

public class ReflectUtils {

    public static Object get(String route) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        Class clazz = Class.forName(route);
        Object object = clazz.newInstance();
        return object;

    }
}
