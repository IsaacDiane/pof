package com.Model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Student {
    private int id;
    private String name;
    private String age;
    public void setId(int id){
        this.id=id;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);

    }
}
