package com.example.demo;

import com.example.demo.validation.NotNullVersioned;

import javax.validation.constraints.NotNull;

public class PersonDto {
    
    @NotNull
    private String name;
    @NotNull
    private Integer age;
    @NotNull(groups = ApiVersion.ApiV2.class) // means that on v1 empty phoneNumber is Ok but on v2 should be rejected
    private String phoneNumber;
    @NotNull(groups = ApiVersion.ApiV3.class)
    private String country;
    @NotNullVersioned
    private String creditCardNumber;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
}
