package com.biubiu.learning.factory.singletonPattern;

import com.biubiu.learning.factory.singletonPattern.register.EnumSingleton;

import java.lang.reflect.Constructor;

public class EnumSingletonTest {
    public static void main(String[] args) {
        EnumSingleton instance = EnumSingleton.getInstance();
        instance.setData(new Object());

        Class clazz = EnumSingleton.class;
        try {
            Constructor c = clazz.getDeclaredConstructor(String.class,int.class);
            c.setAccessible(true);
            Object o = c.newInstance();
            System.out.println(o);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
