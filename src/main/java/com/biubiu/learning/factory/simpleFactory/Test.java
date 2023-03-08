package com.biubiu.learning.factory.simpleFactory;

/*
简单工厂使用场景

工厂类负责创建的对象较少

客户端只需要传入工厂类的参数，对于如何创建对象的逻辑不需要关心

工厂类的职责相对过重，增加新的产品时需要修改工厂类的判断逻辑，违背开闭原则
不易于扩展过于复杂的产品需求
 */
public class Test {
    public static void main(String[] args) {
        ICourse course = new CourseFactory().create(JavaCourse.class);
        course.record();
    }
}
