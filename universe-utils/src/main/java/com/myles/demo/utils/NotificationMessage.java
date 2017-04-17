package com.myles.demo.utils;

public enum NotificationMessage {

    STUDENT_SAVE_VALIDATION_ERROR_TITLE("ERROR"),
    STUDENT_SAVE_VALIDATION_ERROR_RESTRICTION("Fields must be filled"),
    STUDENT_SAVE_SUCCESS_TITLE("SAVE"),
    STUDENT_SAVE_SUCCESS_DESCRIPTION("Student has been saved.");

    private final String mString;

    private NotificationMessage(String string){
         this.mString = string;
    }

    public String getString(){
        return this.mString;
    }
}
