package com.myles.demo.utils;

public enum StudentsStringUtils {

    MAIN_MENU("MAIN MENU"),
    SHOW_ALL_STUDENTS("SHOW ALL STUDENTS"),

    FIRST_NAME("First name"),
    LAST_NAME("Last name"),
    GENDER("Gender"),
    AGE("Age"),
    SAVE_BUTTON("Save"),
    CLEAR_BUTTON("Clear");

    private final String mString;

    private StudentsStringUtils(String string){
        this.mString = string;
    }

    public String getString(){
        return this.mString;
    }

}
