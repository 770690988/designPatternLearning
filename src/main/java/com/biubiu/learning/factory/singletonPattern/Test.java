package com.biubiu.learning.factory.singletonPattern;

/*
单例模式属于一个创建的模式 确保任何情况下都绝对只有一个实例

隐藏其所有的构造方法

属于创建型模式

1.饿汉式单例
2.懒汉式单例
3.注册式单例
4.ThreadLocal单例

 */


import com.biubiu.learning.factory.singletonPattern.lazy.LazyStaticInnerClassSingleton;

public class Test {
    public static void main(String[] args) {
        LazyStaticInnerClassSingleton instance = LazyStaticInnerClassSingleton.getInstance();
        LazyStaticInnerClassSingleton instance2 = LazyStaticInnerClassSingleton.getInstance();
        System.out.println(instance);
        System.out.println(instance2);
    }
}
