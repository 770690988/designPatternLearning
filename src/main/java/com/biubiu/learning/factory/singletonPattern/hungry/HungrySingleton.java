package com.biubiu.learning.factory.singletonPattern.hungry;

/*
优点：执行效率高，性能高，没有任何的锁
缺点：某些情况下，可能会造成内存浪费
 */

public class HungrySingleton {
    private static final HungrySingleton hungrysingleton = new HungrySingleton();
    private HungrySingleton(){}

    public static HungrySingleton getInstance(){return hungrysingleton;}
}
