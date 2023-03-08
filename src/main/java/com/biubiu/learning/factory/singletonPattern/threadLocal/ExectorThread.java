package com.biubiu.learning.factory.singletonPattern.threadLocal;

import com.biubiu.learning.factory.singletonPattern.lazy.LazyDoubleCheckSingleton;

public class ExectorThread implements Runnable{
    public void run(){
        ThreadLocalSingleton instance = ThreadLocalSingleton.getInstance();
        System.out.println(Thread.currentThread().getName()+":"+instance);

    }
}
