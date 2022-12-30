package com.example.demo;

import javax.validation.constraints.NotNull;

public class PersonDto {
    
    @NotNull
    private String name;
    @NotNull
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

}
