package com.biubiu.learning.factory.singletonPattern;

import com.biubiu.learning.factory.singletonPattern.threadLocal.ExectorThread;
import com.biubiu.learning.factory.singletonPattern.threadLocal.ThreadLocalSingleton;

public class ThreadLocalSingletonTestest {
    public static void main(String[] args) {
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());

        Thread t1 = new Thread(new ExectorThread());
        Thread t2 = new Thread(new ExectorThread());
        t1.start();
        t2.start();
        System.out.println("End");
    }
}
