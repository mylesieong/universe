package com.myles.demo.model.entity;

public class Student {

    private Integer mId;
    private String mFirstName;
    private String mLastName;
    private Integer mAge;
    private String mGender;

    public Student(){}

    public Integer getId(){return this.mId;}
    public void setId(Integer id){this.mId = id;}

    public String getFirstName(){return this.mFirstName;}
    public void setFirstName(String firstName){this.mFirstName = firstName;}

    public String getLastName(){return this.mLastName;}
    public void setLastName(String lastName){this.mLastName = lastName;}

    public Integer getAge(){return this.mAge;}
    public void setAge(Integer age){this.mAge = age;}

    public String getGender(){return this.mGender;}
    public void setGender(String gender){this.mGender = gender;}

    @Override 
    public String toString(){
        return this.mFirstName + "-" + this.mLastName + "-" + this.mAge;
    }
}
