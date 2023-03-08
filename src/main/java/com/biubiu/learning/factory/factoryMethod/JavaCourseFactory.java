package com.biubiu.learning.factory.factoryMethod;

public class JavaCourseFactory implements IcourseFactory{
    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
