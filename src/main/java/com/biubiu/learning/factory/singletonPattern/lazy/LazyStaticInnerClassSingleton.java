package com.biubiu.learning.factory.singletonPattern.lazy;

/*
    CLassPath:LazystaticInnerclasssingleton.class(没有调用前只会调用这个类)
              LazystaticInnerclasssingleton$LazyHolder.cLass
  优点：写法优雅，利用了Java本身语法特点，性能高，避免内存浪费 不能够被反射破坏
  缺点：
 */

public class LazyStaticInnerClassSingleton {
    private LazyStaticInnerClassSingleton(){
        if (LazyHolder.INSTACNE != null){
            throw new RuntimeException("不允许非法访问");
        }
        else {
            System.out.println(LazyHolder.INSTACNE);
        }
    }

    public static LazyStaticInnerClassSingleton getInstance(){
        return LazyHolder.INSTACNE;
    }

    private static class LazyHolder{
        private static final LazyStaticInnerClassSingleton INSTACNE = new LazyStaticInnerClassSingleton();
    }

}
