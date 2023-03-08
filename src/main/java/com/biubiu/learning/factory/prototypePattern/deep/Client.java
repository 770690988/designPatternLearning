package com.biubiu.learning.factory.prototypePattern.deep;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        ConcretePrototype prototype = ConcretePrototype.getInstance();
        prototype.setAge(18);
        prototype.setName("Tom");
        List<String> hobbies = new ArrayList<>();
        hobbies.add("书法");
        hobbies.add("美术");
        prototype.setHobbies(hobbies);
        System.out.println(prototype);


        //拷贝原型对象
        ConcretePrototype cloneType = prototype.deepClone();
        cloneType.getHobbies().add("技术控");
        System.out.println("克隆对象："+cloneType);
        System.out.println("原型对象："+prototype);
        System.out.println(cloneType.getHobbies() == prototype.getHobbies());
    }
}
