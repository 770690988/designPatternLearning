package com.biubiu.learning.factory.prototypePattern.deep;

import lombok.Data;

import java.io.*;
import java.util.List;

@Data
public class ConcretePrototype implements Cloneable,Serializable{
    private int age;
    private String name;
    private List<String> hobbies;

    @Override
    public ConcretePrototype clone(){
        try {
            return (ConcretePrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ConcretePrototype deepClone(){
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            return (ConcretePrototype) ois.readObject();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public String toString() {
        return "ConcretePrototype{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }
}
