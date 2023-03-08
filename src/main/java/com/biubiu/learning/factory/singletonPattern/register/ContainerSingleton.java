package com.biubiu.learning.factory.singletonPattern.register;

import java.lang.invoke.StringConcatFactory;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by biubiu
 */
public class ContainerSingleton {

    private ContainerSingleton(){}

    private static Map<String,Object> ioc = new ConcurrentHashMap<>();

    public static Object getInstance(String className){
        Object instance = null;
        if (!ioc.containsKey(className)){
            try{
                instance = Class.forName(className).getDeclaredConstructor().newInstance();
                ioc.put(className,instance);
            }catch (Exception e){
                e.printStackTrace();
            }
            return instance;
        }
        return ioc.get(className);
    }
}
