package com.biubiu.learning.factory.simpleFactory;

import java.util.Calendar;

public class CourseFactory {
    public ICourse create(Class<? extends ICourse> clazz){
//        if (name.equals("java")){
//            return new JavaCourse();
//        } else if (name.equals("python")) {
//            return new PythonCourse();
//        }

//        try{
//            if (null == className || "".equals(className)){
//                return (ICourse)Class.forName(className).newInstance();
//            }
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }

        try{
            if (clazz!=null){
                return (ICourse)clazz.getDeclaredConstructor().newInstance();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
