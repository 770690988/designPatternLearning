package com.biubiu.learning.factory.factoryMethod;

/*
工厂方法模式

用户只需关心所需产品对应的工厂，无须关心创建细节

加入新产品符合开闭原则 ，提高了系统的可扩展性

缺点：
类的个数容易过得，增加代码结构复杂性
增加系统逻辑复杂现象
 */

public class Test {
    public static void main(String[] args) {
        IcourseFactory factory = new PythonCourseFactory();
        ICourse course = factory.create();
        course.record();
    }
}
