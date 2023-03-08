package com.biubiu.learning.factory.abstractFactory;

public class JavaCourseFactory extends CourseFactory{
    protected INote createNode(){
        super.init();
        return new JavaNote();
    }

    protected IVideo createVideo(){
        super.init();
        return new JavaVideo();
    }
}
