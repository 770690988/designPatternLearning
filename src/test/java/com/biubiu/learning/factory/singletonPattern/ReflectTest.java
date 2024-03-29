package com.biubiu.learning.factory.singletonPattern;

import com.biubiu.learning.factory.singletonPattern.lazy.LazyStaticInnerClassSingleton;

import java.lang.reflect.Constructor;

public class ReflectTest {
    public static void main(String[] args) {
        try {
            Class<?> clazz = LazyStaticInnerClassSingleton.class;
            Constructor c = clazz.getDeclaredConstructor(null);

            c.setAccessible(true);
            Object instance1 = c.newInstance();
//            Object instance2 = c.newInstance();
            System.out.println(instance1);
//            System.out.println(instance2);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
