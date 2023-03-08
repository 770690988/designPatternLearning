package com.biubiu.learning.factory.singletonPattern.hungry;

/*
  Created by biubiu
 */

public class HungryStaticSingleton {
    //类加载顺序：
    /*
    先上后下
    先属性后方法
     */
    private static final HungryStaticSingleton hungrySingleton;

    static {
        hungrySingleton = new HungryStaticSingleton();
    }

    private HungryStaticSingleton(){}

    public static HungryStaticSingleton getInstance(){return hungrySingleton;}
}
