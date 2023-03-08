package com.biubiu.learning.factory.abstractFactory;

public class PythonCourseFactorry extends CourseFactory{
    @Override
    protected INote createNode() {
        super.init();
        return new PythonNote();
    }

    @Override
    protected IVideo createVideo() {
        super.init();
        return new PythonVideo();
    }
}
