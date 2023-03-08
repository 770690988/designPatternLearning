package com.biubiu.learning.factory.singletonPattern.lazy;

/**
 * Created by biubiu
 */

/**
 * 优点：节省了内存
 * 缺点：程序可读性难度加大，代码不够优雅
 */

public class LazyDoubleCheckSingleton {
    private volatile static LazyDoubleCheckSingleton instance;
    private LazyDoubleCheckSingleton(){}

    public static LazyDoubleCheckSingleton getInstance(){
        //检查是否要阻塞
        if (instance == null){
            synchronized (LazyDoubleCheckSingleton.class){
                //检查是否创建实例
                if (instance == null){
                    return new LazyDoubleCheckSingleton();
                    //指令重排序的问题
                }
            }
        }
        return instance;
    }
}
