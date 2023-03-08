package com.biubiu.learning.factory.singletonPattern.lazy;

/**
 * Created by biubiu
 */

/**
 * 优点：节省了内存
 * 缺点：可能存在线程不安全的情况(加了synchronized会变得安全，但是会导致性能下降)
 */

public class LazySimpleSingleton {
    private static LazySimpleSingleton instance;
    private LazySimpleSingleton(){}

    public static synchronized LazySimpleSingleton getInstance(){
        if (instance == null){
            return new LazySimpleSingleton();
        }
        return instance;
    }

}
