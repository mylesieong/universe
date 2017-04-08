package com.myles.demo.utils;

public enum StudentsStringUtils {

    MAIN_MENU("MAIN MENU"),
    SHOW_ALL_STUDENTS("SHOW ALL STUDENTS");

    private final String mString;

    private StudentsStringUtils(String string){
        this.mString = string;
    }

    public String getString(){
        return this.mString;
    }

}
