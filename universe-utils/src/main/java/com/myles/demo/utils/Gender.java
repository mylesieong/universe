package com.myles.demo.utils;

public enum Gender {

    GENDER_MALE("Male"),
    GENDER_FEMALE("Female");

    private final String mString;

    private Gender(String string){
         this.mString = string;
    }

    public String getString(){
        return this.mString;
    }
}
