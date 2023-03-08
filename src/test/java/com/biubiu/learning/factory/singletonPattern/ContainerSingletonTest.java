package com.biubiu.learning.factory.singletonPattern;

import com.biubiu.learning.factory.singletonPattern.register.ContainerSingleton;
import com.biubiu.learning.factory.singletonPattern.seriable.SeriableSingleton;

import java.lang.reflect.Constructor;

/**
 * Created by biubiu
 */

public class ContainerSingletonTest {
    public static void main(String[] args) {
        Object instance = ContainerSingleton.getInstance("com.biubiu.learning.factory.singletonPattern.Pojo");
        Class<?> c = SeriableSingleton.class;
        try{
            Constructor<?> con = c.getDeclaredConstructor(null);
            con.setAccessible(true);
            Object o = con.newInstance();
            System.out.println(o);
        }
        catch (Exception e){

        }
        System.out.println(instance);
    }
}
