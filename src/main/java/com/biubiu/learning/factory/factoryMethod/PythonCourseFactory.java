package com.biubiu.learning.factory.factoryMethod;

public class PythonCourseFactory implements IcourseFactory{
    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
