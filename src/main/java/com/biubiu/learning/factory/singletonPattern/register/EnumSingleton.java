package com.biubiu.learning.factory.singletonPattern.register;

public enum EnumSingleton {
    INSTANCE;

    private Object data;

    public Object getData(){
        return data;
    }

    public void setData(Object data){
        this.data = data;
    }

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}
